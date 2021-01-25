package com.gw.opt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class SoAssemblyImpl implements Assembly {

    @Autowired
    Assembly assembly;

    /**
     * @dev 生成汇编码(以对象形式返回)
     * @param isObject 确定是否要调用返回对象的生成方法
     * @return 对象列表
     */
    @Override
    public List<AssemblyCode> genAssembly(boolean isObject, String f) throws IOException {
        List<AssemblyCode> ass = new ArrayList<>();

        String[] datas = f.trim().split("\n");
        String[] arr;

        arr = datas[1].split(" ");
        AssemblyCode as1 = new AssemblyCode();
        if (arr.length == 3) {
            as1.setPosition(0x00);
            as1.setOp(EVM_OP_CODE.valueOf(arr[1]));
            as1.setArg(arr[2].substring(2));
        } else {
            as1.setPosition(0x00);
            try{
                as1.setOp(EVM_OP_CODE.valueOf(arr[1]));
            } catch (IllegalArgumentException e){
                as1.setOp(EVM_OP_CODE.valueOf("UNDEFINE"));
                as1.setInstruction(Integer.decode(arr[2]));
            }

        }
        ass.add(as1);

        for(int i = 2; i < datas.length; i++) {
            arr = datas[i].split(" ");
            AssemblyCode as = getAcObject(arr);
            ass.add(as);
        }
        return ass;

    }

    @Override
    public String reAssembly(List<AssemblyCode> acs) {
        String re = "" ;
        for(AssemblyCode ac: acs){
            if(ac.getArg() != "" && ac.getInstruction() == 0){
                re += formatHexString(ac.getOp().getValue());
                re += ac.getArg();
            } else if (ac.getInstruction() !=0 ){
                re += formatHexString(ac.getInstruction());
            } else {
                re += formatHexString(ac.getOp().getValue());

            }
        }
        System.out.println(re);

        return re;
    }

    @Override
    public String reByteCode(Path p) throws IOException {
        try{
            byte[] data = Files.readAllBytes(p);
            return new String(data);

        }catch (IOException e){
            return "Error";
        }
    }

    private AssemblyCode getAcObject(String[] arr) {
        int pos = 0x00 ;
        AssemblyCode as = new AssemblyCode();
        if (arr.length == 3) {
            pos += 2;
            as.setPosition(pos);
            as.setOp(EVM_OP_CODE.valueOf(arr[1]));
            as.setArg(arr[2].substring(2));
        } else {
            pos ++;
            as.setPosition(pos);
            try{
                as.setOp(EVM_OP_CODE.valueOf(arr[1]));
            } catch (IllegalArgumentException e){

                as.setOp(EVM_OP_CODE.valueOf("UNDEFINE"));
                as.setInstruction(Integer.decode(arr[2]));
            }
        }
        return as;
    }

    private String formatHexString(int hex){
        String str = Integer.toHexString(hex);
        return str.length() == 1 ? "0"+str : str;
    }
}
