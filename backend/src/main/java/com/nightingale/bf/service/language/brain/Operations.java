package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.operation.BaseOperations;
import com.nightingale.bf.service.optimize.Optimizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("brainOperations")
public class Operations extends BaseOperations {
    private final LangSpec brainSpec;
    private final Optimizer brainOptimizer;

    public Operations(LangSpec brainSpec, Optimizer brainOptimizer) {
        this.brainSpec = brainSpec;
        this.brainOptimizer = brainOptimizer;
    }

    @Override
    protected Map<OperationType, String> getOperations() {
        return brainSpec.getOperations();
    }

    @Override
    protected Optimizer getOptimizer() {
        return brainOptimizer;
    }
}
