package com.nightingale.bf.service.language.small;

import com.nightingale.bf.service.Executor;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.utils.Helper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service("smallExecutor")
public class ExecutorImpl implements Executor {
    private final com.nightingale.bf.service.optimize.Optimizer smallOptimizer;

    public ExecutorImpl(Optimizer smallOptimizer) {
        this.smallOptimizer = smallOptimizer;
    }

    @Override
    public String execute(String code, Deque<Integer> input) {
        List<Integer> tape = new LinkedList<>(Collections.singletonList(0));
        String optimized = smallOptimizer.optimize(code);
        int pointer = 0;

        for (int i = 0; i < optimized.length(); i++) {
            switch (optimized.charAt(i)) {
                case '>':
                    pointer++;
                    if (pointer == tape.size()) {
                        tape.add(0);
                    }
                    break;
                case '<':
                    pointer--;
                    if (pointer == -1) {
                        tape.add(0,0);
                        pointer = 0;
                    }
                    break;
                case '*':
                    tape.set(pointer, (tape.get(pointer) ^ 1));
                    break;
                case '[':
                    if (tape.get(pointer) == 0) {
                        i = Helper.closingBracket(optimized, i);
                    }
                    break;
                case ']':
                    if (tape.get(pointer) != 0) {
                        i = Helper.openingBracket(optimized, i);
                    }
                    break;
                default:
                    break;
            }
        }
        return "Tape:\n" + tape.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
