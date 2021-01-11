import com.gw.opt.controller.SolidityController;

import com.gw.opt.service.impl.SoAssemblyImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Slf4j
public class EvmTest {
    /**
     * Slf4j注解方式实现日志
     */
    @Test
    public static void main(String[] args) throws IOException {
        SolidityController sc = new SolidityController();
        String c = "./src/main/resources/evm";
        try {sc.exec(c);

        }catch (Exception e) {
            log.error(e.toString());

        }
//        SoAssemblyImpl saim = new SoAssemblyImpl();
//        saim.genAssembly();
    }
}



