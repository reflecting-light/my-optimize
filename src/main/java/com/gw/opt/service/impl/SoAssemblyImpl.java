package com.gw.opt.service.impl;

import com.gw.opt.bean.AssemblyCode;
import com.gw.opt.service.Assembly;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoAssemblyImpl implements Assembly {

    @Autowired
    Assembly assembly;

    /**
     * @dev 用于测试以txt生成的汇编码列表(以对象形式返回)
     * @param isObject 确定是否要调用返回对象的生成方法
     * @return
     */
    public List<AssemblyCode> genAssembly(boolean isObject, String f) throws IOException {


        List<AssemblyCode> ass = new ArrayList<>();
        if (!isObject){
            return ass;
        }

        String[] datas = f.trim().split("\n");

        try{
            for(int i = 1; i <= datas.length; i++){
                String[] arr = datas[i].split(" ");
                AssemblyCode as = new AssemblyCode();
                if(arr.length == 3) {
                    as.setPosition(arr[0]);
                    as.setInstruction(arr[1]);
                    as.setArg(arr[2]);
                }
                else {
                    as.setPosition(arr[0]);
                    as.setInstruction(arr[1]);
                    as.setArg("");
                }
                ass.add(as);
                System.out.println(as.toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        }



        return ass;
    }

    /**
     * @dev 用于测试以txt生成的汇编码列表（以三条列表形式返回）
     * @return
     */
    public List<List<String>> genAssembly(String f) throws IOException {

        FileInputStream file = new FileInputStream("f");
        InputStreamReader reader = new InputStreamReader(file);
        BufferedReader buffReader = new BufferedReader(reader);
        String data = "";
        List<List<String>> ass = new ArrayList<>();
        int i = 0;
        List<String> pos = new ArrayList<>();
        List<String> in = new ArrayList<>();
        List<String> con = new ArrayList<>();
        while((data = buffReader.readLine()) != null){
            String[] arr = data.split(" ");
//            AssemblyCode as = new AssemblyCode();
            if(arr.length == 3) {
                pos.add(arr[0]);
                in.add(arr[1]);
                con.add(arr[2]);
            }
            else {
                pos.add(arr[0]);
                in.add(arr[1]);
                con.add("");
            }

        }

        ass.add(pos);
        ass.add(in);
        ass.add(con);
        return ass;
    }
}
