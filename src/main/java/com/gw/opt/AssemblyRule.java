package com.gw.opt;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;

import static com.gw.opt.EVM_OP_CODE.*;

@Slf4j
public class AssemblyRule {

    //CHANGEAD CHANGED  CHANGE DELETE

    private List<EVM_OP_CODE> POP1 = Arrays.asList(ISZERO,NOT,CALLDATALOAD,EXTCODESIZE,BLOCKHASH,MLOAD,SLOAD);
    private List<EVM_OP_CODE> POP2 = Arrays.asList(LT,GT,SLT,SGT,EQ,AND,OR,XOR,BYTE,SHA3,ADD,MUL,SUB,DIV,SDIV,MOD,SMOD,EXP,SIGNEXTEND);
    private List<EVM_OP_CODE> POP3 = Arrays.asList(ADDMOD, MULMOD);
    private List<EVM_OP_CODE> POPD = Arrays.asList(ADDRESS,ORIGIN,CALLER,CALLVALUE,CALLDATALOAD,COINBASE,TIMESTAMP,NUMBER,DIFFICULTY,GASLIMIT,CODESIZE,GASPRICE,PC,MSIZE,GAS);
    private List<EVM_OP_CODE> SWAP1 = Arrays.asList(ADD,MUL,AND,OR,XOR);
    private List<EVM_OP_CODE> ZERO = Arrays.asList(LT, GT, SLT, SGT, EQ);

    public List<EVM_OP_CODE> getPOP1() {
        return POP1;
    }

    public List<EVM_OP_CODE> getPOP2() {
        return POP2;
    }

    public List<EVM_OP_CODE> getPOP3() {
        return POP3;
    }

    public List<EVM_OP_CODE> getPOPD() {
        return POPD;
    }

    public List<EVM_OP_CODE> getSWAP1() {
        return SWAP1;
    }

    public List<EVM_OP_CODE> getZERO() {
        return ZERO;
    }
}
