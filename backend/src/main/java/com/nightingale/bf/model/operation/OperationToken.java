package com.nightingale.bf.model.operation;

public class OperationToken {
    private final OperationType token;
    private final int length;

    public OperationToken(OperationType token, int length) {
        this.token = token;
        this.length = length;
    }

    public OperationType getType() {
        return token;
    }

    public int getLength() {
        return length;
    }
}
