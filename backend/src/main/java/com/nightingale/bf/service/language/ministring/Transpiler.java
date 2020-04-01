package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.service.transpile.ByteTranspiler;
import org.springframework.stereotype.Service;

@Service("miniStringTranspiler")
public class Transpiler extends ByteTranspiler {
    private final Operations miniStringOperations;
    private final Optimizer miniStringOptimizer;

    public Transpiler(Operations miniStringOperations, Optimizer miniStringOptimizer) {
        this.miniStringOperations = miniStringOperations;
        this.miniStringOptimizer = miniStringOptimizer;
    }

    @Override
    protected Operations getOperations() {
        return miniStringOperations;
    }

    @Override
    protected Optimizer getOptimizer() {
        return miniStringOptimizer;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }
}
