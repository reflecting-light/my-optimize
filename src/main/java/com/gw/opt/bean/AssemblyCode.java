package com.gw.opt.bean;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class AssemblyCode {
    private String position;
    private String instruction;
    private String arg;

    public AssemblyCode() {

    }

    public AssemblyCode(String position, String instruction, String arg) {
        this.position = position;
        this.instruction = instruction;
        this.arg = arg;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    @Override
    public String toString() {
        return "AssemblyCode{" +
                "position='" + position + '\'' +
                ", instruction='" + instruction + '\'' +
                ", arg='" + arg + '\'' +
                '}';
    }
}
