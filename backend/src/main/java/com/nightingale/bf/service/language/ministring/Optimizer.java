package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.optimize.BaseOptimizer;
import org.springframework.stereotype.Service;

@Service("miniStringOptimizer")
public class Optimizer extends BaseOptimizer {
    private final LangSpec miniStringSpec;

    public Optimizer(LangSpec miniStringSpec) {
        this.miniStringSpec = miniStringSpec;
    }

    @Override
    protected String getOptimizationPattern() {
        return miniStringSpec.getOptimizationPattern();
    }
}
