package com.gw.opt;

import com.gw.opt.bean.AssemblyCode;
import com.gw.opt.controller.SolidityController;
import com.gw.opt.service.impl.SoAssemblyImpl;
import lombok.extern.slf4j.Slf4j;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Compile {
    @Autowired
    SoAssemblyImpl sc ;

    public byte[] exec(String command) throws IOException, InterruptedException{
        log.info("执行脚本:"+command);
        InputStream stream = null;
        Process process = null;

        try{
            process = Runtime.getRuntime().exec(command);
            try{
                stream = process.getInputStream();
                byte[] re = stream.readAllBytes();
                return re;
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                stream.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            process.destroy();
        }
        return null;
    }

    public Path genByteCode(String command, String arg) throws IOException, InterruptedException {

        byte[] re = this.exec(command+arg);
        String bytecode = new String(re).split("\n")[3];
        Path path = FileSystems.getDefault().getPath("./");
        return writeTempFile(bytecode, arg);


    }

    public List<AssemblyCode> genAssemblyCode(String command, Path path) throws IOException, InterruptedException {
        List<AssemblyCode> ass;
        byte[] re = this.exec(command+path.toString());
        String asmc = new String(re);
        ass = sc.genAssembly(true, asmc);
        return ass;
    }

    public Path writeTempFile(String bytecode, String arg){
        Path path = null;
        try{
            path = Files.createTempFile(arg, ".bytecode");
            byte[] buf = bytecode.getBytes();
            Files.write(path, buf);
            return path;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public boolean deleteTempFile(Path path) throws IOException {
        if(path == null)
            return false;
        try{
            System.out.println(path.toString());
//            final Path p = path;
//            new Files("/tmp").listFiles();
//            Files.
//            Files.deleteIfExists(path);
            Files.delete(path);
            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
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
