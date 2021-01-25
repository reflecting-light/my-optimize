package com.gw.opt;


public class AssemblyCode {
    private int position;
    private EVM_OP_CODE op;
    private String arg;
    private int instruction;
    public AssemblyCode() {
        this.arg = "";
    }

    public AssemblyCode(int position, EVM_OP_CODE op, String arg, int instruction) {
        this.position = position;
        this.op = op;
        this.arg = arg;
        this.instruction = instruction;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public EVM_OP_CODE getOp() {
        return op;
    }

    public void setOp(EVM_OP_CODE op) {
        this.op = op;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public int getInstruction() {
        return instruction;
    }

    public void setInstruction(int instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
//        return "AssemblyCode{" +
//                "position=" + position +
//                ", op=" + op +
//                ", value=" + op.getValue() +
//                ", arg='" + arg + '\'' +
//                ", instruction=" + instruction +
//                '}';
        if(arg == "")
            return Integer.toHexString(position) + ": " + op + " " + arg + "\n";
        else
            return Integer.toHexString(position) + ": " + op + " 0x" + arg + "\n";

    }
}
