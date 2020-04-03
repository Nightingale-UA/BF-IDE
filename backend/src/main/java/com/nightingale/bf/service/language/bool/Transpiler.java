package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.transpile.BitTranspiler;
import org.springframework.stereotype.Service;

@Service("boolTranspiler")
public class Transpiler extends BitTranspiler {
    private final Operations boolOperations;

    public Transpiler(Operations boolOperations) {
        this.boolOperations = boolOperations;
    }

    @Override
    protected Operations getOperations() {
        return boolOperations;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }
}
