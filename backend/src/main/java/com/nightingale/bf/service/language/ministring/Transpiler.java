package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.transpile.ByteTranspiler;
import org.springframework.stereotype.Service;

@Service("miniStringTranspiler")
public class Transpiler extends ByteTranspiler {
    private final Operations miniStringOperations;

    public Transpiler(Operations miniStringOperations) {
        this.miniStringOperations = miniStringOperations;
    }

    @Override
    protected Operations getOperations() {
        return miniStringOperations;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }
}
