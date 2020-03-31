package com.nightingale.bf.model;

public enum LangType {
    BRAIN("brain", "-\\+|\\+-|<>|><|\\[]"),
    BOOL("bool", "(\\+\\+)+|<>|><|\\[]"),
    MINI_STRING("mini-string", "Not optimizable"),
    SMALL("small", "(\\*\\*)+|<>|><|\\[]"),
    SWAP("swap", "(?<=@)(@@)+|<>|><|\\[]");

    private final String key;
    private final String useless;

    LangType(String key, String useless) {
        this.key = key;
        this.useless = useless;
    }

    public String getKey() {
        return key;
    }

    public String getUseless() {
        return useless;
    }
}
