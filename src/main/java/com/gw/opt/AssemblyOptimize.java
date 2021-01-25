package com.gw.opt;

import com.gw.opt.rule.AssemblyReturn;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.gw.opt.ConstantProperties.*;

@Slf4j
public class AssemblyOptimize {

    AssemblyRule rule = new AssemblyRule();
    public AssemblyReturn optimizeAll(List<AssemblyCode> acs) {
        AssemblyReturn assemblyReturn = optimizeTwo(acs);
        assemblyReturn = optimizeThree(assemblyReturn);
        while(assemblyReturn.isEdit()){

            assemblyReturn = optimizeTwo(assemblyReturn.getAfter());
            if(!assemblyReturn.isEdit())
                break;
            assemblyReturn = optimizeThree(assemblyReturn);
        }
        return assemblyReturn;
    }

    private AssemblyReturn optimizeTwo(List<AssemblyCode> ac){

        List<Integer> editLine = new ArrayList<>();
        boolean isEdit = false;
        List<AssemblyCode> newac = new ArrayList<>();
        List<AssemblyCode> before = new ArrayList<>();
        AssemblyCode assemblyCode = new AssemblyCode();
        int pos = 0x00000;

        for(int i = 0, j = 1 ; j < ac.size(); i++, j++){
            EVM_OP_CODE op1 = ac.get(i).getOp();
            EVM_OP_CODE op2 = ac.get(j).getOp();
            int opv1 = op1.getValue();
            int opv2 = op2.getValue();

            // SWAPX SWPAX ; PUSHX POP
            if ((opv1 >= 0x90 && opv1 <=0x9f && opv1 == opv2) || (opv1 >= 0x60 && opv1 <= 0x7f && opv2 == 0x50) ){
                newac.add(assemblyCode);
                newac.add(assemblyCode);
                editLine.addAll(addEdits(DELETE_CHANGE, 2));
                before.add(ac.get(i));
                before.add(ac.get(j));

                i ++;
                j ++;
                isEdit = true;
                continue;
            }
            else {
                // POP CHANGE
                if(op2 == EVM_OP_CODE.POP){
                    if(rule.getPOP1().contains(op1)){
                        isEdit = true;
                        newac.add(assemblyCode);
                        newac.addAll(Change(pos, 1, EVM_OP_CODE.POP));
                        editLine.add(DELETE_CHANGE);
                        editLine.add(NOT_CHANGE);
                        before.add(ac.get(i));
                        before.add(ac.get(j));
                        pos++;
                        i ++;
                        j ++;
                        continue;
                    }
                    else if(rule.getPOP2().contains(op1)){
                        isEdit = true;
                        newac.addAll(Change(pos, 2, EVM_OP_CODE.POP));
                        editLine.add(CHANGE);
                        editLine.add(NOT_CHANGE);
                        before.add(ac.get(i));
                        before.add(ac.get(j));
                        pos+=2;
                        i ++;
                        j ++;
                        continue;
                    }
                    else if(rule.getPOP3().contains(op1)){
                        isEdit = true;
                        newac.addAll(Change(pos, 3, EVM_OP_CODE.POP));
                        editLine.add(CHANGE);
                        editLine.add(ADD_CHANGE);
                        editLine.add(NOT_CHANGE);

                        before.add(ac.get(i));
                        before.add(assemblyCode);
                        before.add(ac.get(j));

                        pos+=3;
                        i ++;
                        j ++;
                        continue;
                    }
                    else if(rule.getPOPD().contains(op1)){
                        isEdit = true;
                        newac.add(assemblyCode);
                        newac.add(assemblyCode);
                        editLine.addAll(addEdits(DELETE_CHANGE, 2));
                        before.add(ac.get(i));
                        before.add(ac.get(j));
                        i ++;
                        j ++;
                        continue;
                    }
                    else{

                        ac.get(i).setPosition(pos);
                        newac.add(ac.get(i));
                        editLine.add(NOT_CHANGE);

                        before.add(ac.get(i));

                        if(ac.get(i).getArg() == ""){
                            pos ++;
                        }else{
                            pos += 2;
                        }
                    }
                }
                // SWAP1 CHANGE
                else if(op1 == EVM_OP_CODE.SWAP1 && rule.getSWAP1().contains(op2)){
                    isEdit = true;
                    newac.add(assemblyCode);
                    newac.addAll(Change(pos, 1, op2));

                    editLine.add(DELETE_CHANGE);
                    editLine.add(NOT_CHANGE);

                    before.add(ac.get(i));
                    before.add(ac.get(j));

                    pos++;
                    i ++;
                    j ++;
                    continue;
                }
                // sequential JUMPDEST
                else if(op1 == EVM_OP_CODE.JUMPDEST && op2 == EVM_OP_CODE.JUMPDEST){
                    isEdit = true;
                    newac.add(assemblyCode);
                    newac.addAll(Change(pos, 1, op1));

                    editLine.add(DELETE_CHANGE);
                    editLine.add(NOT_CHANGE);

                    before.add(ac.get(i));
                    before.add(ac.get(j));

                    pos++;
                    i++;
                    j++;
                    continue;
                }
                // PUSHX NOT
                else if(opv1 >= 0x60 && opv1 <= 0x7f && op2 == EVM_OP_CODE.NOT ){
                    isEdit = true;
                    int arg = ~Integer.parseInt(ac.get(i).getArg());
                    AssemblyCode temp = change(pos, op1);
                    temp.setArg(String.valueOf(arg));
                    newac.add(temp);
                    newac.add(assemblyCode);

                    editLine.add(CHANGE);
                    editLine.add(DELETE_CHANGE);

                    before.add(ac.get(i));
                    before.add(ac.get(j));
                    pos+=2;
                    i++;
                    j++;
                    continue;
                }
                else{
                    ac.get(i).setPosition(pos);
                    newac.add(ac.get(i));
                    editLine.add(NOT_CHANGE);
                    before.add(ac.get(i));

                    if(ac.get(i).getArg() == ""){
                        pos ++;
                    }else{
                        pos += 2;
                    }
                }
            }
        }
        before.add(ac.get(ac.size()-1));
        ac.get(ac.size() - 1).setPosition(pos);
        newac.add(ac.get(ac.size() - 1));
        editLine.add(NOT_CHANGE);

        return new AssemblyReturn(before, newac, editLine, isEdit);
    }

    private AssemblyReturn optimizeThree(AssemblyReturn ar) {
        List<AssemblyCode> ac = ar.getAfter();

        List<Integer> editLine = new ArrayList<>();
        boolean isEdit = false;
        List<AssemblyCode> newac = new ArrayList<>();
        List<AssemblyCode> before = new ArrayList<>();
        AssemblyCode assemblyCode = new AssemblyCode();
        int pos = 0x00000;

        for (int i = 0, j = 1, k = 2; k < ac.size(); i++, j++, k++) {
            EVM_OP_CODE op1 = ac.get(i).getOp();
            EVM_OP_CODE op2 = ac.get(j).getOp();
            EVM_OP_CODE op3 = ac.get(k).getOp();

            // OP/ISZERO/ISZERO -> POP OP
            if (op2 == EVM_OP_CODE.ISZERO && op3 == op2 && rule.getZERO().contains(op1)) {
                isEdit = true;
                newac.add(assemblyCode);
                newac.add(change(pos,  EVM_OP_CODE.POP));
                pos++;
                newac.add(change(pos,  op1));
                editLine.add(DELETE_CHANGE);
                editLine.addAll(addEdits(CHANGE, 2));

                before.add(ac.get(i));
                before.add(ac.get(j));
                before.add(ac.get(k));

                pos++;
                i += 2;
                j += 2;
                k += 2;
            }
            // SWAP1/DUP2/SWAP1 -> DUP1/SWAP2
            else if(op1 == EVM_OP_CODE.SWAP1 && op1 == op3 && op2 == EVM_OP_CODE.DUP2){
                isEdit = true;
                newac.add(assemblyCode);
                newac.add(change(pos,  EVM_OP_CODE.DUP1));
                pos++;
                newac.add(change(pos,  EVM_OP_CODE.SWAP2));
                pos++;

                editLine.add(DELETE_CHANGE);
                editLine.addAll(addEdits(CHANGE, 2));

                before.add(ac.get(i));
                before.add(ac.get(j));
                before.add(ac.get(k));

                i += 2;
                j += 2;
                k += 2;
            }else {
                before.add(ac.get(i));
                ac.get(i).setPosition(pos);
                newac.add(ac.get(i));
                editLine.add(ar.getEditLine().get(i));

                if(ac.get(i).getArg() == ""){
                    pos ++;
                }else{
                    pos += 2;
                }
            }
        }
        before.add(ac.get(ac.size()-2));
        ac.get(ac.size() - 2).setPosition(pos);
        newac.add(ac.get(ac.size() - 2));
        editLine.add(NOT_CHANGE);

        before.add(ac.get(ac.size()-1));
        ac.get(ac.size() - 1).setPosition(pos);
        newac.add(ac.get(ac.size() - 1));
        editLine.add(NOT_CHANGE);

        return new AssemblyReturn(before, newac, editLine, isEdit);

    }

    private List<AssemblyCode> Change(int pos, int n, EVM_OP_CODE op){
        List<AssemblyCode> re = new ArrayList<>();

        for(int i = 0; i < n; i++ ){
           re.add(change(pos, op));
           pos++;
        }
        return re;
    }

    private AssemblyCode change(int pos, EVM_OP_CODE op){

        AssemblyCode as = new AssemblyCode();
        as.setPosition(pos);
        as.setOp(op);

       return as;
    }

    private List<Integer> addEdits(int type, int n){
        List<Integer> lines = new ArrayList<>();
        for(int i = 0; i < n; i++){
            lines.add(type);
        }
        return lines;
    }

}
