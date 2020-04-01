package com.nightingale.bf.service.transpile;

import com.nightingale.bf.model.operation.OperationToken;
import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class BaseTranspiler implements Transpiler {
    /**
     * Tab length.
     */
    private static final int TAB = 4;

    static final String CELL = "*p";
    static final String CLOSING_BRACKET = ")";

    private static final String POINTER = "p";
    private static final String END_LINE = "\n";
    private static final String ADD = " += ";
    private static final String SUBTRACT = " -= ";
    private static final String FLIP = " ^= 1";
    private static final String OPENING_CURVY_BRACKET = " {";
    private static final String CLOSING_CURVY_BRACKET = "}";
    private static final String WHILE = "while (";
    private static final String STORE_BIT = "storeBit(";
    private static final String GET_STORED_BIT = " = getStoredBit()";

    @Override
    public String toHighLevel(String code) {
        return internalToHighLevel(
            "",
            getOperations().tokenize(getOptimizer().optimize(code)).iterator(),
            0, false);
    }

    protected abstract Operations getOperations();

    protected abstract Optimizer getOptimizer();

    private String internalToHighLevel(String result, Iterator<OperationToken> iterator,
                                       int spaces, boolean swap) {
        if (!iterator.hasNext()) {
            return result;
        }
        var token = iterator.next();
        return internalToHighLevel(
            nextResult(result, token, spaces, swap),
            iterator,
            nextSpaces(token.getType(), spaces),
            nextSwap(token.getType(), swap));
    }

    private String nextResult(String result, OperationToken token,
                              int spaces, boolean swap) {
        return result
            + spacesAsString(token.getType(), spaces)
            + stepResult(token, swap)
            + END_LINE;
    }

    private String spacesAsString(OperationType type, int spaces) {
        return Stream.generate(() -> " ")
            .limit(type.equals(OperationType.END) ? spaces - TAB : spaces)
            .collect(Collectors.joining());
    }

    private String stepResult(OperationToken token, boolean swap) {
        switch (token.getType()) {
            case INCR:
                return CELL + ADD + token.getLength();
            case DECR:
                return CELL + SUBTRACT + token.getLength();
            case FLIP:
                return CELL + FLIP;
            case SWAP:
                return swap
                    ? CELL + GET_STORED_BIT
                    : STORE_BIT + CELL + CLOSING_BRACKET;
            case RIGHT:
                return POINTER + ADD + token.getLength();
            case LEFT:
                return POINTER + SUBTRACT + token.getLength();
            case IN:
                return in();
            case OUT:
                return out();
            case START:
                return WHILE + CELL + CLOSING_BRACKET + OPENING_CURVY_BRACKET;
            case END:
                return CLOSING_CURVY_BRACKET;
        }
        throw new IllegalStateException("All possible operation types should be covered!");
    }

    protected abstract String in();

    protected abstract String out();

    private int nextSpaces(OperationType type, int spaces) {
        return type.equals(OperationType.START)
            ? spaces + TAB
            : type.equals(OperationType.END)
                ? spaces - TAB
                : spaces;
    }

    private boolean nextSwap(OperationType type, boolean swap) {
        return type.equals(OperationType.SWAP) != swap;
    }
}
