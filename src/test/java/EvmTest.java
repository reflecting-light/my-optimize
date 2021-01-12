import com.gw.opt.Compile;
import com.gw.opt.bean.AssemblyCode;
import com.gw.opt.controller.SolidityController;


import com.gw.opt.service.impl.SoAssemblyImpl;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.assertj.core.error.ShouldBeAfterYear;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.gw.opt.ConstantProperties.*;


@Slf4j
public class EvmTest {



    @Test
    void testEvm() throws IOException, InterruptedException {
        Compile compile = new Compile();
        try{
            Path p = compile.genByteCode(SOLC_COMMAND, "test.sol");
            try{

                for(AssemblyCode as:compile.genAssemblyCode(EVM_COMMAND, p)){
                    System.out.println(as.toString());
                }
            } catch (Exception e){
                compile.deleteTempFile(p);
            }
        } catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }





//        String bytecode = "608060405260043610603e5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631003e2d281146043575b600080fd5b348015604e57600080fd5b5060586004356073565b60408051921515835260208301919091528051918290030190f35b6000805482018082558190831115608657fe5b9150915600";
//        Path path = compile.writeTempFile(bytecode, "test.sol");
////        System.out.println(asmc.trim());
//        try{
//            List<AssemblyCode> ass = sc.genAssembly(true, ASSEMBLY_TEST_CODE);
//            for(AssemblyCode as:ass){
//                System.out.println(as.toString());
//            }
//        } catch (Exception e){
//            compile.deleteTempFile(path);
//            e.printStackTrace();
//        }


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
