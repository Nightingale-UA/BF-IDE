package com.nightingale.bf.service.transpile;

public abstract class BitTranspiler extends BaseTranspiler {
    private static final String PRINT_BIT = "printBit(";
    private static final String READ_BIT = " = readBit()";

    @Override
    protected String in() {
        return CELL + READ_BIT;
    }

    @Override
    protected String out() {
        return PRINT_BIT + CELL + CLOSING_BRACKET;
    }
}
