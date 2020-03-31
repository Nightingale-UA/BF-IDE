package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.optimize.BaseOptimizer;
import org.springframework.stereotype.Service;

@Service("boolOptimizer")
public class Optimizer extends BaseOptimizer {
    private final LangSpec boolSpec;

    public Optimizer(LangSpec boolSpec) {
        this.boolSpec = boolSpec;
    }

    @Override
    protected String getOptimizationPattern() {
        return boolSpec.getOptimizationPattern();
    }
}
