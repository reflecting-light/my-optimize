package com.gw.opt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Component
@Slf4j
public class Compile {

    public byte[] exec(String command) throws IOException, InterruptedException{
        log.info("执行脚本:"+command);
        InputStream stream = null;
        Process process = null;
        byte[] b = new byte[10];
        try{
            process = Runtime.getRuntime().exec(command);
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                stream = process.getInputStream();
            }catch (Exception e){
                e.printStackTrace();
            } finally {

                if (process != null) {
                    process.destroy();
                }
                byte[] re = stream.readAllBytes();
                stream.close();
                return re;
            }

        }

    }

    public void genByteCode(String commond) throws IOException, InterruptedException {
//        Path path = FileSystems.getDefault().getPath("./");
        byte[] bytecode = this.exec(commond);
        String bc = this.bytesToHex(bytecode).split("\n")[2];
       System.out.println(bc);
    }

    /**
     * 字节数组转16进制
     * @param bytes 需要转换的byte数组
     * @return  转换后的Hex字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }

}
