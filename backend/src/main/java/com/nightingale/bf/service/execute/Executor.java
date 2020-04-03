package com.nightingale.bf.service.execute;

import java.util.Collection;

public interface Executor {
    /**
     * Execute provided BF code.
     * @param code String BF code
     * @param input Deque
     * @return String execution result
     */
    String execute(String code, Collection<Integer> input);
}
