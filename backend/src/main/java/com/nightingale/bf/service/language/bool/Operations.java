package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.operation.BaseOperations;
import com.nightingale.bf.service.optimize.Optimizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("boolOperations")
public class Operations extends BaseOperations {
    private final LangSpec boolSpec;
    private final Optimizer boolOptimizer;

    public Operations(LangSpec boolSpec, Optimizer boolOptimizer) {
        this.boolSpec = boolSpec;
        this.boolOptimizer = boolOptimizer;
    }

    @Override
    protected Map<OperationType, String> getOperations() {
        return boolSpec.getOperations();
    }

    @Override
    protected Optimizer getOptimizer() {
        return boolOptimizer;
    }
}
