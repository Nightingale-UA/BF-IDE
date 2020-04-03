package com.nightingale.bf.service.execute;

import com.nightingale.bf.model.ExecutionData;
import com.nightingale.bf.model.operation.OperationToken;
import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.service.operation.Operations;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public abstract class BaseExecutor implements Executor {
    @Override
    public String execute(String code, Collection<Integer> input) {
        var output = new StringBuilder();
        var tape = createTape(input);
        var tokens = getOperations().tokenize(code).listIterator();
        var inputIterator = input.iterator();
        var data = new ExecutionData();

        while (tokens.hasNext()) {
            var token = tokens.next();
            switch (token.getType()) {
                case FLIP:
                    tape.set(data.getPointer(), (tape.get(data.getPointer()) ^ 1));
                    break;
                case SWAP:
                    if (data.getSwapReg() == -1) {
                        data.setSwapReg(data.getPointer());
                    } else {
                        int temp = tape.get(data.getSwapReg());
                        tape.set(data.getSwapReg(), tape.get(data.getPointer()));
                        tape.set(data.getPointer(), temp);
                        data.setSwapReg(-1);
                    }
                    break;
                case RIGHT:
                    data.setPointer(data.getPointer() + token.getLength());
                    while (data.getPointer() >= tape.size()) {
                        tape.add(0);
                    }
                    break;
                case LEFT:
                    int pointer = data.getPointer() - token.getLength();
                    for ( ; pointer < 0; pointer++) {
                        tape.add(0, 0);
                    }
                    data.setPointer(pointer);
                    break;
                case IN:
                    if (data.getNextIn() == -1) {
                        data.setNextIn(inputIterator.next());
                    }
                    tape.set(data.getPointer(), data.getNextIn() & 1);
                    data.setNextIn(data.getNextIn() >> 1);
                    data.setCountIn(data.getCountIn() + 1);
                    if (data.getCountIn() == BITS_NUM) {
                        data.setCountIn(0);
                        data.setNextIn(-1);
                    }
                    break;
                case OUT:
                    var nextOut = data.getNextOut();
                    var countOut = data.getCountOut();
                    nextOut |= tape.get(data.getPointer()) << countOut;
                    if (++countOut == BITS_NUM) {
                        output.append((char) nextOut);
                        countOut = 0;
                        nextOut = 0;
                    }
                    data.setNextOut(nextOut);
                    data.setCountOut(countOut);
                    break;
                case START:
                    if (tape.get(data.getPointer()) == 0) {
                        closingBracket(tokens);
                    }
                    break;
                case END:
                    if (tape.get(data.getPointer()) != 0) {
                        openingBracket(tokens);
                    }
                    break;
            }
        }
        return output.toString();
    }

    protected abstract Operations getOperations();

    protected List<Integer> createTape(Collection<Integer> input) {
        return new LinkedList<>(Collections.singletonList(0));
    }

    protected Iterator<Integer> inputIterator(Collection<Integer> input) {
        return input.iterator();
    }

    private void closingBracket(Iterator<OperationToken> tokens) {
        var counter = 1;
        while (counter != 0) {
            var token = tokens.next();
            if (token.getType().equals(OperationType.START)) {
                counter++;
            }
            if (token.getType().equals(OperationType.END)) {
                counter--;
            }
        }
    }

    private void openingBracket(ListIterator<OperationToken> tokens) {
        tokens.previous();
        var counter = 1;
        while (counter != 0) {
            var token = tokens.previous();
            if (token.getType().equals(OperationType.START)) {
                counter--;
            }
            if (token.getType().equals(OperationType.END)) {
                counter++;
            }
        }
    }
}
