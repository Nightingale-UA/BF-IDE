package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.operation.BaseOperations;
import com.nightingale.bf.service.optimize.Optimizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("swapOperations")
public class Operations extends BaseOperations {
    private final LangSpec swapSpec;
    private final Optimizer swapOptimizer;

    public Operations(LangSpec swapSpec, Optimizer swapOptimizer) {
        this.swapSpec = swapSpec;
        this.swapOptimizer = swapOptimizer;
    }

    @Override
    protected Map<OperationType, String> getOperations() {
        return swapSpec.getOperations();
    }

    @Override
    protected Optimizer getOptimizer() {
        return swapOptimizer;
    }
}
