package com.nightingale.bf.service.language.small;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.service.transpile.BitTranspiler;
import org.springframework.stereotype.Service;

@Service("smallTranspiler")
public class Transpiler extends BitTranspiler {
    private final com.nightingale.bf.service.operation.Operations smallOperations;
    private final Optimizer smallOptimizer;

    public Transpiler(Operations smallOperations, Optimizer smallOptimizer) {
        this.smallOperations = smallOperations;
        this.smallOptimizer = smallOptimizer;
    }

    @Override
    protected Operations getOperations() {
        return smallOperations;
    }

    @Override
    protected Optimizer getOptimizer() {
        return smallOptimizer;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }
}
