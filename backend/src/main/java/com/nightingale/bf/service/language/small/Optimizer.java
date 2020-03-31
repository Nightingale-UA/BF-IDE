package com.nightingale.bf.service.language.small;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.optimize.BaseOptimizer;
import org.springframework.stereotype.Service;

@Service("smallOptimizer")
public class Optimizer extends BaseOptimizer {
    private final LangSpec smallSpec;

    public Optimizer(LangSpec smallSpec) {
        this.smallSpec = smallSpec;
    }

    @Override
    protected String getOptimizationPattern() {
        return smallSpec.getOptimizationPattern();
    }
}
