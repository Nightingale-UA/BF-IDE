package com.nightingale.bf.service.execute;

import com.nightingale.bf.service.MiniStringService;

import java.util.Deque;

public class MiniStringExecutor extends MiniStringService implements Executor {
    @Override
    public String execute(String code, Deque<Integer> input) {
        StringBuilder output = new StringBuilder();
        int value = 0;

        for (int i = 0; i < code.length(); i++) {
            switch (code.charAt(i)) {
                case '+':
                    value = (value + 1) % (MAX_VALUE + 1);
                    break;
                case '.':
                    output.append((char)value);
                    break;
                default:
                    break;
            }
        }
        return output.toString();
    }
}
