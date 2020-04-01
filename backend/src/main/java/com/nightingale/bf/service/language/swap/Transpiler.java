package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.service.transpile.BitTranspiler;
import org.springframework.stereotype.Service;

@Service("swapTranspiler")
public class Transpiler extends BitTranspiler {
    private final Operations swapOperations;
    private final Optimizer swapOptimizer;

    public Transpiler(Operations swapOperations, Optimizer swapOptimizer) {
        this.swapOperations = swapOperations;
        this.swapOptimizer = swapOptimizer;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }

    @Override
    protected Operations getOperations() {
        return swapOperations;
    }

    @Override
    protected Optimizer getOptimizer() {
        return swapOptimizer;
    }
}
