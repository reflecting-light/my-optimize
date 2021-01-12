import com.gw.opt.Compile;
import com.gw.opt.bean.AssemblyCode;
import com.gw.opt.controller.SolidityController;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.gw.opt.ConstantProperties.EVM_COMMAND;
import static com.gw.opt.ConstantProperties.SOLC_COMMAND;


@Slf4j
public class EvmTest {



    @Test
    void testEvm() throws IOException, InterruptedException {
        Compile compile = new Compile();
        Path p = compile.genByteCode(SOLC_COMMAND, "test.sol");
        for(AssemblyCode as:compile.genAssemblyCode(EVM_COMMAND, p)){
            System.out.println(as.toString());
        }

        compile.deleteTempFile(p);

    }


//    @Test
//    void writeTest() throws IOException {
//        Compile compile = new Compile();
//        String bytecode = "608060405260043610603e5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631003e2d281146043575b600080fd5b348015604e57600080fd5b5060586004356073565b60408051921515835260208301919091528051918290030190f35b6000805482018082558190831115608657fe5b9150915600";
//        Path path = compile.writeTempFile(bytecode, "test.sol");
//        compile.deleteTempFile(path);
//
//    }
}
