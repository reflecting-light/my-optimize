package com.gw.opt.controller;


import com.gw.opt.bean.AssemblyCode;
import com.gw.opt.service.impl.SoAssemblyImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@CrossOrigin("http://localhost")
@RestController
@Slf4j
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



}
