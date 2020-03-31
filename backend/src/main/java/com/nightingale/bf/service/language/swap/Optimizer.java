package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.optimize.BaseOptimizer;
import org.springframework.stereotype.Service;

@Service("swapOptimizer")
public class Optimizer extends BaseOptimizer {
    private final LangSpec swapSpec;

    public Optimizer(LangSpec swapSpec) {
        this.swapSpec = swapSpec;
    }

    @Override
    protected String getOptimizationPattern() {
        return swapSpec.getOptimizationPattern();
    }
}
