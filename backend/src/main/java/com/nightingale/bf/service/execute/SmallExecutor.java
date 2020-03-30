package com.nightingale.bf.service.execute;

import com.nightingale.bf.utils.Helper;
import com.nightingale.bf.service.SmallService;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SmallExecutor extends SmallService implements Executor {
    @Override
    public String execute(String code, Deque<Integer> input) {
        List<Integer> tape = new LinkedList<>(Collections.singletonList(0));
        int pointer = 0;
        String optimized = optimize(code);

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
