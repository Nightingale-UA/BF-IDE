package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.service.execute.BaseExecutor;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.utils.Helper;
import org.springframework.stereotype.Service;

import java.util.Deque;
import java.util.LinkedList;

@Service("swapExecutor")
public class Executor extends BaseExecutor {
    private final Optimizer swapOptimizer;

    public Executor(Optimizer swapOptimizer) {
        this.swapOptimizer = swapOptimizer;
    }

    @Override
    public String execute(String code, Deque<Integer> input) {
        StringBuilder output = new StringBuilder();
        int size = input.size() * BITS_NUM;
        LinkedList<Integer> tape = new LinkedList<>();

        int count = 0;
        int next = 0;
        for (int i = 0; i < size; i++) {
            if (count == 0) {
                next = input.getLast();
            }
            tape.addFirst(next & 1);
            next >>= 1;
            count++;
            if (count == BITS_NUM) {
                count = 0;
                next = 0;
            }
        }

        String opt = swapOptimizer.optimize(code);
        int swapReg = -1;
        int pointer = 0;
        int length = opt.length();

        for (int i = 0; i < length; i++) {
            switch (opt.charAt(i)) {
                case '@':
                    if (swapReg == -1) swapReg = pointer;
                    else {
                        int temp = tape.get(swapReg);
                        tape.set(swapReg, tape.get(pointer));
                        tape.set(pointer, temp);
                        swapReg = -1;
                    }
                    break;
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
                case '.':
                    next <<= 1;
                    next += tape.get(pointer);
                    if (++count == BITS_NUM) {
                        output.append((char) next);
                        count = 0;
                        next = 0;
                    }
                    break;
                case '[':
                    if (tape.get(pointer) == 0) {
                        i = Helper.closingBracket(opt,i);
                    }
                    break;
                case ']':
                    if (tape.get(pointer) != 0) {
                        i = Helper.openingBracket(opt,i);
                    }
                    break;
                default:
                    break;
            }
        }
        return output.toString();
    }
}
