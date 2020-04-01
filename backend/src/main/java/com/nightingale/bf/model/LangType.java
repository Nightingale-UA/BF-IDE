package com.nightingale.bf.model;

import com.nightingale.bf.model.RegexConstants.Optimization;

public enum LangType {
    BRAIN("brain", Optimization.BRAIN),
    BOOL("bool", Optimization.BOOL),
    MINI_STRING("mini-string", Optimization.MINI_STRING),
    SMALL("small", Optimization.SMALL),
    SWAP("swap", Optimization.SWAP);

    private final String key;
    private final String optimizationPattern;

    LangType(String key, String optimizationPattern) {
        this.key = key;
        this.optimizationPattern = optimizationPattern;
    }

    public String getKey() {
        return key;
    }

    public String getOptimizationPattern() {
        return optimizationPattern;
    }
}
