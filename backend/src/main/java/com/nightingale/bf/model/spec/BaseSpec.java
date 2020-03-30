package com.nightingale.bf.model.spec;

import com.nightingale.bf.model.LangType;

public abstract class BaseSpec implements LangSpec {

    protected abstract LangType getType();

    @Override
    public String getKey() {
        return getType().getKey();
    }

    @Override
    public String getOperations() {
        return getType().getOperations();
    }

    @Override
    public String getOptimizationPattern() {
        return getType().getUseless();
    }
}
