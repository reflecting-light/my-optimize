import com.gw.opt.*;


import lombok.extern.slf4j.Slf4j;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

import static com.gw.opt.ConstantProperties.*;
import static com.gw.opt.EVM_OP_CODE.*;
import static com.gw.opt.EVM_OP_CODE.ISZERO;


@Slf4j
public class EvmTest {



    @Test
    void testEvm() throws IOException, InterruptedException {
        Compile compile = new Compile();
        List<AssemblyCode> ass = new ArrayList<>();
        try{
            Path p = compile.genByteCode(SOLC_COMMAND, "test.sol");
            try{
                ass = compile.genAssemblyCode(EVM_COMMAND, p);

                System.out.println(ass.get(0).toString()+"\n" + ass.get(1).toString());
            } catch (Exception e){
//                compile.deleteTempFile(p);
            }
        } catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

    }


    @Test
    void writeTest() throws IOException {
        Compile compile = new Compile();
        String bytecode = "608060405260043610603e5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631003e2d281146043575b600080fd5b348015604e57600080fd5b5060586004356073565b60408051921515835260208301919091528051918290030190f35b6000805482018082558190831115608657fe5b9150915600";
//        Path path = compile.writeTempFile(bytecode, "test.sol");
//        compile.deleteTempFile(path);

    }

    @Test
    void enumTest(){
        for (EVM_OP_CODE evm_op_code : EnumSet.allOf(EVM_OP_CODE.class))
        {
            System.out.println(evm_op_code.getValue());
        }
        System.out.println(EVM_OP_CODE.SWAP1.getValue());
        System.out.println(EVM_OP_CODE.SWAP16.getValue());

//        System.out.println(EVM_OP_CODE.valueOf("SWAP1"));
    }

    @Test
    void assemblyCodeGenTest() throws IOException {
        List<AssemblyCode> ass = new ArrayList<>();
        SoAssemblyImpl s = new SoAssemblyImpl();
        ass = s.genAssembly(true, ASSEMBLY_TEST_CODE);
        for(AssemblyCode as: ass){
            System.out.println(as.toString());
        }


    }

    @Test
    void jsonGenTest() throws IOException {

        JSONObject data = new JSONObject();
//        Path path = Paths.get("src/main/resources/assembly_rule");
        InputStreamReader read = null;
        BufferedReader bufferedReader = null;
        OutputStreamWriter os = null;
        try{
            os = new OutputStreamWriter(new FileOutputStream("./src/main/resources/assembly_rule.json"));
            read = new InputStreamReader(
                    new FileInputStream("src/main/resources/assembly_rule"));
            bufferedReader = new BufferedReader(read);
            String line = null;
            while ((line = bufferedReader.readLine()) != null)
            {
                JSONObject sub = new JSONObject();
                JSONArray op_list = new JSONArray();
                JSONArray ch_list = new JSONArray();
                String [] ops = line.split("CHANGE");
                if (ops.length == 1){
                    String [] t = line.replace("DELETE", "").split(" ");
                    for(String op: t){
                        op_list.put(op);
                    }
                    sub.put("op_list", op_list);
                    sub.put("op", "DELETE");
//
                    data.accumulate("rule",sub);
                }else{
//                    System.out.println(ops[1]);
                    for(String op: ops[0].split(" ")){
                        op_list.put(op);
                    }
                    for(String nop: ops[1].trim().split(" ")){
                        ch_list.put(nop);
                    }
                    sub.put("op_list", op_list);
                    sub.put("ch_list", ch_list);

                    sub.put("op", "CHANGE");
                    data.accumulate("rule",sub);
                }


            }
            os.write(data.toString());
            os.flush();
        } catch (IOException | JSONException e){
            bufferedReader.close();
            read.close();
            os.close();
        }

        }

    @Test
    void reAssTest() throws IOException {
        SoAssemblyImpl s = new SoAssemblyImpl();
        s.reAssembly(s.genAssembly(true, ASSEMBLY_TEST_CODE));
    }


    @Test
    void optTest(){
        Compile compile = new Compile();
        AssemblyOptimize opt = new AssemblyOptimize();
        List<AssemblyCode> ass = new ArrayList<>();
        SoAssemblyImpl sc = new SoAssemblyImpl() ;
        try{
            Path p = compile.genByteCode(SOLC_COMMAND, "test.sol");
            try{
                ass = compile.genAssemblyCode(EVM_COMMAND, p);

            } catch (Exception e){
                compile.deleteTempFile(p);
            }
//            System.out.println(ass.toString());
//            System.out.println(opt.optimizeAll(ass).toString());
//            for(AssemblyCode before:opt.optimizeAll(ass).getBefore())
//                System.out.print(before.toString());
            for(AssemblyCode after:opt.optimizeAll(ass).getAfter())
                System.out.print(after.toString());

        } catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

    }

    @Test
    void listTest(){
        List<Integer> test = new ArrayList<>();
        test.add(CHANGE);
        test.add(DELETE_CHANGE);
        System.out.println(test.toString());
    }
}
