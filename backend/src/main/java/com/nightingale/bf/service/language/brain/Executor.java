package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.service.execute.ByteExecutor;
import com.nightingale.bf.service.operation.Operations;
import org.springframework.stereotype.Service;

@Service("brainExecutor")
public class Executor extends ByteExecutor {
    private final Operations brainOperations;

    public Executor(Operations brainOperations) {
        this.brainOperations = brainOperations;
    }

    @Override
    protected Operations getOperations() {
        return brainOperations;
    }
}
