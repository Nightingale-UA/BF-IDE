package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.service.execute.BaseExecutor;
import com.nightingale.bf.service.operation.Operations;
import org.springframework.stereotype.Service;

@Service("boolExecutor")
public class Executor extends BaseExecutor {
    private final Operations boolOperations;

    public Executor(Operations boolOperations) {
        this.boolOperations = boolOperations;
    }

    @Override
    protected Operations getOperations() {
        return boolOperations;
    }
}
