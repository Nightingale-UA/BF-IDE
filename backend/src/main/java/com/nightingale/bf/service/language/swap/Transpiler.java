package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.transpile.BitTranspiler;
import org.springframework.stereotype.Service;

@Service("swapTranspiler")
public class Transpiler extends BitTranspiler {
    private final Operations swapOperations;

    public Transpiler(Operations swapOperations) {
        this.swapOperations = swapOperations;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }

    @Override
    protected Operations getOperations() {
        return swapOperations;
    }
}
