package com.nightingale.bf.model.spec;

import com.nightingale.bf.model.LangType;
import com.nightingale.bf.service.optimize.Optimizer;

public abstract class BaseSpec implements Optimizer {

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
