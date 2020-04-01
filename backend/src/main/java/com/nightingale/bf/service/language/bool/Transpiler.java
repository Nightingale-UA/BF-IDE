package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.service.transpile.BitTranspiler;
import org.springframework.stereotype.Service;

@Service("boolTranspiler")
public class Transpiler extends BitTranspiler {
    private final Operations boolOperations;
    private final Optimizer boolOptimizer;

    public Transpiler(Operations boolOperations, Optimizer boolOptimizer) {
        this.boolOperations = boolOperations;
        this.boolOptimizer = boolOptimizer;
    }

    @Override
    protected Operations getOperations() {
        return boolOperations;
    }

    @Override
    protected Optimizer getOptimizer() {
        return boolOptimizer;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }
}
