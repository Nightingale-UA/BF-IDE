package com.nightingale.bf.service.language.small;

import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.operation.BaseOperations;
import com.nightingale.bf.service.optimize.Optimizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("smallOperations")
public class Operations extends BaseOperations {
    private final LangSpec smallSpec;
    private final Optimizer smallOptimizer;

    public Operations(LangSpec smallSpec, Optimizer smallOptimizer) {
        this.smallSpec = smallSpec;
        this.smallOptimizer = smallOptimizer;
    }

    @Override
    protected Map<OperationType, String> getOperations() {
        return smallSpec.getOperations();
    }

    @Override
    protected Optimizer getOptimizer() {
        return smallOptimizer;
    }
}
