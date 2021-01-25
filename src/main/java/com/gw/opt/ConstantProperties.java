package com.gw.opt;

import java.util.HashMap;
import java.util.Map;

public final class ConstantProperties {
    private ConstantProperties(){
    }
    public static final String EVM_COMMAND = "./src/main/resources/evm disasm ";
    public static final String SOLC_COMMAND = "./src/main/resources/solc --bin-runtime ";

    public static final int NOT_CHANGE = 0;
    public static final int CHANGE = 1;
    public static final int ADD_CHANGE = 2;
    public static final int DELETE_CHANGE = 3;

    public static final String ASSEMBLY_TEST_CODE = "608060405260043610603e5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631003e2d281146043575b600080fd5b348015604e57600080fd5b5060586004356073565b60408051921515835260208301919091528051918290030190f35b6000805482018082558190831115608657fe5b9150915600\n" +
            "00000: PUSH1 0x80\n" +
            "00002: PUSH1 0x40\n" +
            "00004: MSTORE\n" +
            "00005: PUSH1 0x04\n" +
            "00007: CALLDATASIZE\n" +
            "00008: LT\n" +
            "00009: PUSH1 0x3e\n" +
            "0000b: JUMPI\n" +
            "0000c: PUSH4 0xffffffff\n" +
            "00011: PUSH29 0x0100000000000000000000000000000000000000000000000000000000\n" +
            "0002f: PUSH1 0x00\n" +
            "00031: CALLDATALOAD\n" +
            "00032: DIV\n" +
            "00033: AND\n" +
            "00034: PUSH4 0x1003e2d2\n" +
            "00039: DUP2\n" +
            "0003a: EQ\n" +
            "0003b: PUSH1 0x43\n" +
            "0003d: JUMPI\n" +
            "0003e: JUMPDEST\n" +
            "0003f: PUSH1 0x00\n" +
            "00041: DUP1\n" +
            "00042: REVERT\n" +
            "00043: JUMPDEST\n" +
            "00044: CALLVALUE\n" +
            "00045: DUP1\n" +
            "00046: ISZERO\n" +
            "00047: PUSH1 0x4e\n" +
            "00049: JUMPI\n" +
            "0004a: PUSH1 0x00\n" +
            "0004c: DUP1\n" +
            "0004d: REVERT\n" +
            "0004e: JUMPDEST\n" +
            "0004f: POP\n" +
            "00050: PUSH1 0x58\n" +
            "00052: PUSH1 0x04\n" +
            "00054: CALLDATALOAD\n" +
            "00055: PUSH1 0x73\n" +
            "00057: JUMP\n" +
            "00058: JUMPDEST\n" +
            "00059: PUSH1 0x40\n" +
            "0005b: DUP1\n" +
            "0005c: MLOAD\n" +
            "0005d: SWAP3\n" +
            "0005e: ISZERO\n" +
            "0005f: ISZERO\n" +
            "00060: DUP4\n" +
            "00061: MSTORE\n" +
            "00062: PUSH1 0x20\n" +
            "00064: DUP4\n" +
            "00065: ADD\n" +
            "00066: SWAP2\n" +
            "00067: SWAP1\n" +
            "00068: SWAP2\n" +
            "00069: MSTORE\n" +
            "0006a: DUP1\n" +
            "0006b: MLOAD\n" +
            "0006c: SWAP2\n" +
            "0006d: DUP3\n" +
            "0006e: SWAP1\n" +
            "0006f: SUB\n" +
            "00070: ADD\n" +
            "00071: SWAP1\n" +
            "00072: RETURN\n" +
            "00073: JUMPDEST\n" +
            "00074: PUSH1 0x00\n" +
            "00076: DUP1\n" +
            "00077: SLOAD\n" +
            "00078: DUP3\n" +
            "00079: ADD\n" +
            "0007a: DUP1\n" +
            "0007b: DUP3\n" +
            "0007c: SSTORE\n" +
            "0007d: DUP2\n" +
            "0007e: SWAP1\n" +
            "0007f: DUP4\n" +
            "00080: GT\n" +
            "00081: ISZERO\n" +
            "00082: PUSH" +
            "1 0x86\n" +
            "00084: JUMPI\n" +
            "00085: opcode 0xfe not defined\n" +
            "00086: JUMPDEST\n" +
            "00087: SWAP2\n" +
            "00088: POP\n" +
            "00089: SWAP2\n" +
            "0008a: JUMP\n" +
            "0008b: STOP\n";
}

