package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.optimize.BaseOptimizer;
import org.springframework.stereotype.Service;

@Service("brainOptimizer")
public class Optimizer extends BaseOptimizer {
    private final LangSpec brainSpec;

    public Optimizer(LangSpec brainSpec) {
        this.brainSpec = brainSpec;
    }

    @Override
    protected String getOptimizationPattern() {
        return brainSpec.getOptimizationPattern();
    }
}
