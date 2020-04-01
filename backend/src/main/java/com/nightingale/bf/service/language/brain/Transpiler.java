package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.service.transpile.ByteTranspiler;
import org.springframework.stereotype.Service;

@Service("brainTranspiler")
public class Transpiler extends ByteTranspiler {
    private final Operations brainOperations;
    private final Optimizer brainOptimizer;

    public Transpiler(Operations brainOperations, Optimizer brainOptimizer) {
        this.brainOperations = brainOperations;
        this.brainOptimizer = brainOptimizer;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }

    @Override
    protected Operations getOperations() {
        return brainOperations;
    }

    @Override
    protected Optimizer getOptimizer() {
        return brainOptimizer;
    }
}
