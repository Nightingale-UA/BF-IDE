package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.operation.BaseOperations;
import com.nightingale.bf.service.optimize.Optimizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("miniStringOperations")
public class Operations extends BaseOperations {
    private final LangSpec miniStringSpec;
    private final Optimizer miniStringOptimizer;

    public Operations(LangSpec miniStringSpec, Optimizer miniStringOptimizer) {
        this.miniStringSpec = miniStringSpec;
        this.miniStringOptimizer = miniStringOptimizer;
    }

    @Override
    protected Map<OperationType, String> getOperations() {
        return miniStringSpec.getOperations();
    }

    @Override
    protected Optimizer getOptimizer() {
        return miniStringOptimizer;
    }
}
