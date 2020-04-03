package com.nightingale.bf.service.language.small;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.transpile.BitTranspiler;
import org.springframework.stereotype.Service;

@Service("smallTranspiler")
public class Transpiler extends BitTranspiler {
    private final com.nightingale.bf.service.operation.Operations smallOperations;

    public Transpiler(Operations smallOperations) {
        this.smallOperations = smallOperations;
    }

    @Override
    protected Operations getOperations() {
        return smallOperations;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }
}
