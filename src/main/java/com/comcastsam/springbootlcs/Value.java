package com.comcastsam.springbootlcs;

public class Value {

    private String value;

    public Value() {

    }
    public Value(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "\"value\": \"" + value + "\"";
    }
}
