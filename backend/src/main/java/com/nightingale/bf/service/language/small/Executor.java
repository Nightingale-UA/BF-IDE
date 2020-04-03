package com.nightingale.bf.service.language.small;

import com.nightingale.bf.service.execute.BitExecutor;
import com.nightingale.bf.service.operation.Operations;
import org.springframework.stereotype.Service;

@Service("smallExecutor")
public class Executor extends BitExecutor {
    private final Operations smallOperations;

    public Executor(Operations smallOperations) {
        this.smallOperations = smallOperations;
    }

    @Override
    protected Operations getOperations() {
        return smallOperations;
    }
}
