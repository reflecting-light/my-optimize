package com.gw.opt.controller;


import com.gw.opt.bean.AssemblyCode;
import com.gw.opt.service.impl.SoAssemblyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@CrossOrigin("http://localhost")
@RestController
public class SolidityController {

    @Autowired
    SoAssemblyImpl sai;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file)throws Exception{
        Path path =  FileSystems.getDefault().getPath(file.getOriginalFilename());
        Files.copy(file.getInputStream(),path);
        return "success";
    }

    @RequestMapping("/test")
    @ResponseBody
    public List<List<String>> test()throws Exception{

        return sai.genAssembly();
    }

    public static boolean exec(String command) throws IOException, InterruptedException{
//        log.info("执行脚本:"+command);
        Process process = Runtime.getRuntime().exec(command);
        int exitValue = process.waitFor();
        if (process != null) {
            process.destroy();
        }
        if (exitValue!=0){
            return false;
        }
        return true;
    }

}
