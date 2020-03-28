package com.nightingale.bf.service.execute;

import com.nightingale.bf.service.LangSpec;

import java.util.Deque;

public interface Executor extends LangSpec {
    /**
     * Execute provided BF code.
     * @param code String BF code
     * @param input Deque
     * @return String execution result
     */
    String execute(String code, Deque<Integer> input);
}
