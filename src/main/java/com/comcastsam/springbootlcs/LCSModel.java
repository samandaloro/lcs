package com.comcastsam.springbootlcs;

import java.util.ArrayList;

public class LCSModel {

    private ArrayList<Value> lcs;

    public LCSModel() {

    }
    public LCSModel(ArrayList<Value> lcs) {
        this.lcs = lcs;
    }

    public ArrayList<Value> getLcs() {
        return this.lcs;
    }

    public void setSetOfStrings(ArrayList<Value> lcs) {
        this.lcs = lcs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("lcs: {");
        for(Value v : lcs) {
            sb.append(v.toString() + ",\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
