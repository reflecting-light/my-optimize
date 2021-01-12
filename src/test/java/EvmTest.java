import com.gw.opt.Compile;
import com.gw.opt.controller.SolidityController;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


@Slf4j
public class EvmTest {



    @Test
    void testEvm() throws IOException, InterruptedException {
        Compile compile = new Compile();
        String evm = "./src/main/resources/evm";
        String solc = "./src/main/resources/solc --bin-runtime test.sol";
        String str = compile.genByteCode(solc);
        System.out.println(str);
//        for(String x:str){
//            System.out.println("line"+ x);
//        }

//        byte[] bytecode = compile.exec(solc);
//
//        Path path = FileSystems.getDefault().getPath("./");
//
//        byte[] asm = compile.exec(evm);
//        System.out.println(new String(re));


    }


}
