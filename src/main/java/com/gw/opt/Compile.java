package com.gw.opt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
@Slf4j
public class Compile {


    /**
     *
     * @param command
     * @dev 命令行执行
     * @return 二进制文件执行结果
     * @throws IOException
     * @throws InterruptedException
     */
    public byte[] exec(String command) throws IOException, InterruptedException{
//        log.info("执行脚本:"+command);
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

    /**
     *
     * @param command
     * @param filename 源文件
     * @dev 将命令行执行后生成字节码写入临时文件
     * @return 临时文件路径
     * @throws IOException
     * @throws InterruptedException
     */
    public Path genByteCode(String command, String filename) throws IOException, InterruptedException {

        byte[] re = this.exec(command+filename);
        String bytecode = new String(re).split("\n")[3];
        return writeTempFile(bytecode, filename);


    }

    /**
     *
     * @param command
     * @param path 临时文件（字节码）路径
     * @dev 生成汇编码
     * @return 汇编码对象列表
     * @throws IOException
     * @throws InterruptedException
     */
    public List<AssemblyCode> genAssemblyCode(String command, Path path) throws IOException, InterruptedException {
        List<AssemblyCode> ass;
        SoAssemblyImpl sc = new SoAssemblyImpl() ;
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
            Files.delete(path);
            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }


}
