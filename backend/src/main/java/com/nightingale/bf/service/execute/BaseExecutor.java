package com.nightingale.bf.service.execute;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public abstract class BaseExecutor implements Executor {
    protected LinkedList<Integer> createTape(Collection<Integer> input) {
        return new LinkedList<>(Collections.singletonList(0));
    }
}
