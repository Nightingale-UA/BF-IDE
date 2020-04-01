package com.nightingale.bf.service.transpile;

public abstract class ByteTranspiler extends BaseTranspiler {
    private static final String PRINT_CHAR = "printChar(";
    private static final String READ_CHAR = " = readChar()";

    @Override
    protected String in() {
        return CELL + READ_CHAR;
    }

    @Override
    protected String out() {
        return PRINT_CHAR + CELL + CLOSING_BRACKET;
    }
}
