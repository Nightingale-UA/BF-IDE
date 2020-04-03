package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.transpile.ByteTranspiler;
import org.springframework.stereotype.Service;

@Service("brainTranspiler")
public class Transpiler extends ByteTranspiler {
    private final Operations brainOperations;

    public Transpiler(Operations brainOperations) {
        this.brainOperations = brainOperations;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }

    @Override
    protected Operations getOperations() {
        return brainOperations;
    }
}
