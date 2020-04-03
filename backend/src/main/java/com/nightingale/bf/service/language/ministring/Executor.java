package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.service.execute.ByteExecutor;
import com.nightingale.bf.service.operation.Operations;
import org.springframework.stereotype.Service;

@Service("miniStringExecutor")
public class Executor extends ByteExecutor {
    private final Operations miniStringOperations;

    public Executor(Operations miniStringOperations) {
        this.miniStringOperations = miniStringOperations;
    }


    @Override
    protected Operations getOperations() {
        return miniStringOperations;
    }
}
