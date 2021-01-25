package com.gw.opt.rule;

import com.gw.opt.AssemblyCode;

import java.util.List;

public class AssemblyReturn {
    private List<AssemblyCode> after;
    private List<AssemblyCode> before;
    private List<Integer> editLine;
    private boolean isEdit;

    public AssemblyReturn(){}

    public AssemblyReturn(List<AssemblyCode> before, List<AssemblyCode> after, List<Integer> editLine, boolean isEdit){
        this.before = before;
        this.after = after;
        this.editLine = editLine;
        this.isEdit = isEdit;
    }

    public List<AssemblyCode> getAfter() {
        return after;
    }

    public void setAfter(List<AssemblyCode> after) {
        this.after = after;
    }

    public List<AssemblyCode> getBefore() {
        return before;
    }

    public void setBefore(List<AssemblyCode> before) {
        this.before = before;
    }

    public List<Integer> getEditLine() {
        return editLine;
    }

    public void setEditLine(List<Integer> editLine) {
        this.editLine = editLine;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }


}
