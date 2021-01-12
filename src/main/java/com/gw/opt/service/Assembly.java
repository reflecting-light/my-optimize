package com.gw.opt.service;

import com.gw.opt.bean.AssemblyCode;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
public interface Assembly {

    List<AssemblyCode> genAssembly (boolean isObject, String file) throws IOException;
    List<List<String>> genAssembly (String file) throws IOException;

}
