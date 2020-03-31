package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.service.Executor;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.utils.Helper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Service("brainExecutor")
public class ExecutorImpl implements Executor {
    private final Optimizer brainOptimizer;

    public ExecutorImpl(Optimizer brainOptimizer) {
        this.brainOptimizer = brainOptimizer;
    }

    @Override
    public String execute(String code, Deque<Integer> input) {
        StringBuilder output = new StringBuilder();
        List<Integer> tape = new LinkedList<>(Collections.singletonList(0));
        String optimized = brainOptimizer.optimize(code);
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
                case '+':
                    int temp = (tape.get(pointer) + 1) % (MAX_VALUE + 1);
                    tape.set(pointer,temp);
                    break;
                case '-':
                    temp = tape.get(pointer) - 1;
                    tape.set(pointer, (temp < 0) ? MAX_VALUE : temp);
                    break;
                case ',':
                    tape.set(pointer, input.pop());
                    break;
                case '.':
                    output.append((char) tape.get(pointer).intValue());
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
        return output.toString();
    }
}
