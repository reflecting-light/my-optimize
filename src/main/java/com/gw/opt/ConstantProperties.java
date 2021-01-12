package com.gw.opt;

public final class ConstantProperties {
    private ConstantProperties(){
    }
    public static final String EVM_COMMAND = "./src/main/resources/evm disasm ";
    public static final String SOLC_COMMAND = "./src/main/resources/solc --bin-runtime ";
    public static final String ASSEMBLY_TEST_CODE = "608060405234801561001057600080fd5b50600436106100365760003560e01c80636803cba91461003b578063dd18987814610059575b600080fd5b610043610077565b6040516100509190610107565b60405180910390f35b6100616100bb565b60405161006e9190610107565b60405180910390f35b600080600090505b60038110156100b25760008081548092919061009a9061012c565b919050555080806100aa9061012c565b91505061007f565b50600054905090565b600080600054905060005b60038110156100f05781806100da9061012c565b92505080806100e89061012c565b9150506100c6565b508091505090565b61010181610122565b82525050565b600060208201905061011c60008301846100f8565b92915050565b6000819050919050565b600061013782610122565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82141561016a57610169610175565b5b600182019050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fdfea2646970667358221220e321b3657355c2dd9725d46cb4e988a7627c529decb42a77349874f0773c225264736f6c63430008000033\n" +
            "00000: PUSH1 0x80\n" +
            "00002: PUSH1 0x40\n" +
            "00004: MSTORE\n" +
            "00005: CALLVALUE\n" +
            "00006: DUP1\n" +
            "00007: ISZERO\n" +
            "00008: PUSH2 0x0010\n" +
            "0000b: JUMPI\n" +
            "0000c: PUSH1 0x00\n" +
            "0000e: DUP1\n" +
            "0000f: REVERT\n" +
            "00010: JUMPDEST\n" +
            "00011: POP\n" +
            "00012: PUSH1 0x04\n" +
            "00014: CALLDATASIZE\n" +
            "00015: LT\n" +
            "00016: PUSH2 0x0036\n" +
            "00019: JUMPI\n" +
            "0001a: PUSH1 0x00\n" +
            "0001c: CALLDATALOAD\n" +
            "0001d: PUSH1 0xe0\n" +
            "0001f: SHR\n" +
            "00020: DUP1\n" +
            "00021: PUSH4 0x6803cba9\n" +
            "00026: EQ\n" +
            "00027: PUSH2 0x003b\n" +
            "0002a: JUMPI\n" +
            "0002b: DUP1\n" +
            "0002c: PUSH4 0xdd189878\n" +
            "00031: EQ\n" +
            "00032: PUSH2 0x0059\n" +
            "00035: JUMPI\n" +
            "00036: JUMPDEST\n" +
            "00037: PUSH1 0x00\n" +
            "00039: DUP1\n" +
            "0003a: REVERT\n" +
            "0003b: JUMPDEST\n" +
            "0003c: PUSH2 0x0043\n" +
            "0003f: PUSH2 0x0077\n" +
            "00042: JUMP\n" +
            "00043: JUMPDEST\n" +
            "00044: PUSH1 0x40\n" +
            "00046: MLOAD\n" +
            "00047: PUSH2 0x0050\n" +
            "0004a: SWAP2\n" +
            "0004b: SWAP1\n" +
            "0004c: PUSH2 0x0107\n" +
            "0004f: JUMP\n" +
            "00050: JUMPDEST\n" +
            "00051: PUSH1 0x40\n" +
            "00053: MLOAD\n" +
            "00054: DUP1\n" +
            "00055: SWAP2\n" +
            "00056: SUB\n" +
            "00057: SWAP1\n" +
            "00058: RETURN\n" +
            "00059: JUMPDEST\n" +
            "0005a: PUSH2 0x0061\n" +
            "0005d: PUSH2 0x00bb\n" +
            "00060: JUMP\n" +
            "00061: JUMPDEST\n" +
            "00062: PUSH1 0x40\n" +
            "00064: MLOAD\n" +
            "00065: PUSH2 0x006e\n" +
            "00068: SWAP2\n" +
            "00069: SWAP1\n" +
            "0006a: PUSH2 0x0107\n" +
            "0006d: JUMP\n" +
            "0006e: JUMPDEST\n" +
            "0006f: PUSH1 0x40\n" +
            "00071: MLOAD\n" +
            "00072: DUP1\n" +
            "00073: SWAP2\n" +
            "00074: SUB\n" +
            "00075: SWAP1\n" +
            "00076: RETURN\n" +
            "00077: JUMPDEST\n" +
            "00078: PUSH1 0x00\n" +
            "0007a: DUP1\n" +
            "0007b: PUSH1 0x00\n" +
            "0007d: SWAP1\n" +
            "0007e: POP\n" +
            "0007f: JUMPDEST\n" +
            "00080: PUSH1 0x03\n" +
            "00082: DUP2\n" +
            "00083: LT\n" +
            "00084: ISZERO\n" +
            "00085: PUSH2 0x00b2\n" +
            "00088: JUMPI\n" +
            "00089: PUSH1 0x00\n" +
            "0008b: DUP1\n" +
            "0008c: DUP2\n" +
            "0008d: SLOAD\n" +
            "0008e: DUP1\n" +
            "0008f: SWAP3\n" +
            "00090: SWAP2\n" +
            "00091: SWAP1\n" +
            "00092: PUSH2 0x009a\n" +
            "00095: SWAP1\n" +
            "00096: PUSH2 0x012c\n" +
            "00099: JUMP\n" +
            "0009a: JUMPDEST\n" +
            "0009b: SWAP2\n" +
            "0009c: SWAP1\n" +
            "0009d: POP\n" +
            "0009e: SSTORE\n" +
            "0009f: POP\n" +
            "000a0: DUP1\n" +
            "000a1: DUP1\n" +
            "000a2: PUSH2 0x00aa\n" +
            "000a5: SWAP1\n" +
            "000a6: PUSH2 0x012c\n" +
            "000a9: JUMP\n" +
            "000aa: JUMPDEST\n" +
            "000ab: SWAP2\n" +
            "000ac: POP\n" +
            "000ad: POP\n" +
            "000ae: PUSH2 0x007f\n" +
            "000b1: JUMP\n" +
            "000b2: JUMPDEST\n" +
            "000b3: POP\n" +
            "000b4: PUSH1 0x00\n" +
            "000b6: SLOAD\n" +
            "000b7: SWAP1\n" +
            "000b8: POP\n" +
            "000b9: SWAP1\n" +
            "000ba: JUMP\n" +
            "000bb: JUMPDEST\n" +
            "000bc: PUSH1 0x00\n" +
            "000be: DUP1\n" +
            "000bf: PUSH1 0x00\n" +
            "000c1: SLOAD\n" +
            "000c2: SWAP1\n" +
            "000c3: POP\n" +
            "000c4: PUSH1 0x00\n" +
            "000c6: JUMPDEST\n" +
            "000c7: PUSH1 0x03\n" +
            "000c9: DUP2\n" +
            "000ca: LT\n" +
            "000cb: ISZERO\n" +
            "000cc: PUSH2 0x00f0\n" +
            "000cf: JUMPI\n" +
            "000d0: DUP2\n" +
            "000d1: DUP1\n" +
            "000d2: PUSH2 0x00da\n" +
            "000d5: SWAP1\n" +
            "000d6: PUSH2 0x012c\n" +
            "000d9: JUMP\n" +
            "000da: JUMPDEST\n" +
            "000db: SWAP3\n" +
            "000dc: POP\n" +
            "000dd: POP\n" +
            "000de: DUP1\n" +
            "000df: DUP1\n" +
            "000e0: PUSH2 0x00e8\n" +
            "000e3: SWAP1\n" +
            "000e4: PUSH2 0x012c\n" +
            "000e7: JUMP\n" +
            "000e8: JUMPDEST\n" +
            "000e9: SWAP2\n" +
            "000ea: POP\n" +
            "000eb: POP\n" +
            "000ec: PUSH2 0x00c6\n" +
            "000ef: JUMP\n" +
            "000f0: JUMPDEST\n" +
            "000f1: POP\n" +
            "000f2: DUP1\n" +
            "000f3: SWAP2\n" +
            "000f4: POP\n" +
            "000f5: POP\n" +
            "000f6: SWAP1\n" +
            "000f7: JUMP\n" +
            "000f8: JUMPDEST\n" +
            "000f9: PUSH2 0x0101\n" +
            "000fc: DUP2\n" +
            "000fd: PUSH2 0x0122\n" +
            "00100: JUMP\n" +
            "00101: JUMPDEST\n" +
            "00102: DUP3\n" +
            "00103: MSTORE\n" +
            "00104: POP\n" +
            "00105: POP\n" +
            "00106: JUMP\n" +
            "00107: JUMPDEST\n" +
            "00108: PUSH1 0x00\n" +
            "0010a: PUSH1 0x20\n" +
            "0010c: DUP3\n" +
            "0010d: ADD\n" +
            "0010e: SWAP1\n" +
            "0010f: POP\n" +
            "00110: PUSH2 0x011c\n" +
            "00113: PUSH1 0x00\n" +
            "00115: DUP4\n" +
            "00116: ADD\n" +
            "00117: DUP5\n" +
            "00118: PUSH2 0x00f8\n" +
            "0011b: JUMP\n" +
            "0011c: JUMPDEST\n" +
            "0011d: SWAP3\n" +
            "0011e: SWAP2\n" +
            "0011f: POP\n" +
            "00120: POP\n" +
            "00121: JUMP\n" +
            "00122: JUMPDEST\n" +
            "00123: PUSH1 0x00\n" +
            "00125: DUP2\n" +
            "00126: SWAP1\n" +
            "00127: POP\n" +
            "00128: SWAP2\n" +
            "00129: SWAP1\n" +
            "0012a: POP\n" +
            "0012b: JUMP\n" +
            "0012c: JUMPDEST\n" +
            "0012d: PUSH1 0x00\n" +
            "0012f: PUSH2 0x0137\n" +
            "00132: DUP3\n" +
            "00133: PUSH2 0x0122\n" +
            "00136: JUMP\n" +
            "00137: JUMPDEST\n" +
            "00138: SWAP2\n" +
            "00139: POP\n" +
            "0013a: PUSH32 0xffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff\n" +
            "0015b: DUP3\n" +
            "0015c: EQ\n" +
            "0015d: ISZERO\n" +
            "0015e: PUSH2 0x016a\n" +
            "00161: JUMPI\n" +
            "00162: PUSH2 0x0169\n" +
            "00165: PUSH2 0x0175\n" +
            "00168: JUMP\n" +
            "00169: JUMPDEST\n" +
            "0016a: JUMPDEST\n" +
            "0016b: PUSH1 0x01\n" +
            "0016d: DUP3\n" +
            "0016e: ADD\n" +
            "0016f: SWAP1\n" +
            "00170: POP\n" +
            "00171: SWAP2\n" +
            "00172: SWAP1\n" +
            "00173: POP\n" +
            "00174: JUMP\n" +
            "00175: JUMPDEST\n" +
            "00176: PUSH32 0x4e487b7100000000000000000000000000000000000000000000000000000000\n" +
            "00197: PUSH1 0x00\n" +
            "00199: MSTORE\n" +
            "0019a: PUSH1 0x11\n" +
            "0019c: PUSH1 0x04\n" +
            "0019e: MSTORE\n" +
            "0019f: PUSH1 0x24\n" +
            "001a1: PUSH1 0x00\n" +
            "001a3: REVERT\n" +
            "001a4: opcode 0xfe not defined\n" +
            "001a5: LOG2\n" +
            "001a6: PUSH5 0x6970667358\n" +
            "001ac: opcode 0x22 not defined\n" +
            "001ad: SLT\n" +
            "001ae: SHA3\n" +
            "001af: opcode 0xe3 not defined\n" +
            "001b0: opcode 0x21 not defined\n" +
            "001b1: opcode 0xb3 not defined\n" +
            "001b2: PUSH6 0x7355c2dd9725\n" +
            "001b9: opcode 0xd4 not defined\n" +
            "001ba: PUSH13 0xb4e988a7627c529decb42a7734\n" +
            "001c8: SWAP9\n" +
            "\n";
}

