package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.service.execute.BaseExecutor;
import org.springframework.stereotype.Service;

import java.util.Deque;

@Service("miniStringExecutor")
public class Executor extends BaseExecutor {
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
