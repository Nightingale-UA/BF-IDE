package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.service.execute.BaseExecutor;
import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.utils.Helper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service("brainExecutor")
public class Executor extends BaseExecutor {
    private final Optimizer brainOptimizer;

    public Executor(Optimizer brainOptimizer) {
        this.brainOptimizer = brainOptimizer;
    }

    @Override
    public String execute(String code, Collection<Integer> input) {
        StringBuilder output = new StringBuilder();
        List<Integer> tape = createTape(input);
        Iterator<Integer> inputIterator = inputIterator(input);
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
                    tape.set(pointer, inputIterator.next());
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

    @Override
    protected Operations getOperations() {
        return null;
    }
}
