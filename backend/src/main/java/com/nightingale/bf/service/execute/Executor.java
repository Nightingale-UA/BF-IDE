package com.nightingale.bf.service.execute;

import java.util.Collection;

public interface Executor {
    //TODO: move constants somewhere
    /**
     * Assumed length of bit input.
     */
    int BITS_NUM = 8;
    /**
     * Max allowed value on tape.
     */
    int MAX_VALUE = 0xFF;

    /**
     * Execute provided BF code.
     * @param code String BF code
     * @param input Deque
     * @return String execution result
     */
    String execute(String code, Collection<Integer> input);
}
