package com.gw.opt;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Service
public interface Assembly {

    List<AssemblyCode> genAssembly (boolean isObject, String f) throws IOException;

    String reAssembly (List<AssemblyCode> ac);

    String reByteCode(Path p) throws IOException;
}
