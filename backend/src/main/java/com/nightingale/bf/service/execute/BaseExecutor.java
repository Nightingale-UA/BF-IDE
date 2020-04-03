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
                    in(inputIterator, tape, data);
                    break;
                case OUT:
                    out(output, tape, data);
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
                default:
                    delegateToChildren(token, tape, data);
            }
        }
        return output.toString();
    }

    protected abstract Operations getOperations();

    protected abstract void delegateToChildren(OperationToken token,
                                               List<Integer> tape,
                                               ExecutionData data);

    protected abstract void in(Iterator<Integer> input,
                               List<Integer> tape,
                               ExecutionData data);

    protected abstract void out(StringBuilder output,
                                List<Integer> tape,
                                ExecutionData data);

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
