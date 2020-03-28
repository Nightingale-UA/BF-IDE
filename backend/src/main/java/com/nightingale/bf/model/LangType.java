package com.nightingale.bf.model;

public enum LangType {
    BRAIN("brain", "><+-,.[]"),
    BOOL("bool", "><+,;[]"),
    MINI_STRING("mini-string", "+."),
    SMALL("small", "><*[]"),
    SWAP("swap", "@><[].");

    private final String key;
    private final String operations;

    LangType(String key, String operations) {
        this.key = key;
        this.operations = operations;
    }

    public String getKey() {
        return key;
    }

    public String getOperations() {
        return operations;
    }
}
