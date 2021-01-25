package com.gw.opt;


import com.gw.opt.rule.AssemblyReturn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.gw.opt.ConstantProperties.EVM_COMMAND;
import static com.gw.opt.ConstantProperties.SOLC_COMMAND;


@CrossOrigin("http://localhost")
@RestController
@Slf4j
public class SolidityController {


    static Path byteCode;
    Compile compile = new Compile();
    SoAssemblyImpl sai = new SoAssemblyImpl();
    AssemblyOptimize opt = new AssemblyOptimize();

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file)throws Exception{
        Path path =  FileSystems.getDefault().getPath(file.getOriginalFilename());
        Files.copy(file.getInputStream(),path);
        compile.genByteCode(SOLC_COMMAND)

        return "success";
    }

    @RequestMapping("/test")
    @ResponseBody
    public AssemblyReturn test()throws Exception{

        Compile compile = new Compile();
        List<AssemblyCode> ass = new ArrayList<>();
        AssemblyReturn re = new AssemblyReturn();
        try{
            Path p = compile.genByteCode(SOLC_COMMAND, "test.sol");
            try{
                ass = compile.genAssemblyCode(EVM_COMMAND, p);
                return opt.optimizeAll(ass);
            } catch (Exception e){
                compile.deleteTempFile(p);
            }
        } catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
        return opt.optimizeAll(ass);
    }

    @RequestMapping("/getbytecode")
    public String getByteCode(){
        return sai.reByteCode();
    }

}
