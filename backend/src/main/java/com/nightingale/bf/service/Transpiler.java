package com.nightingale.bf.service;

public interface Transpiler {
    //TODO: move these constants to some proper place
    /**
     * Tab length.
     */
    int TAB = 4;

    String CELL = "*p";
    String POINTER = "p";
    String END_LINE = "\n";
    String ADD = " += ";
    String SUBTRACT = " -= ";
    String FLIP = " ^= 1";
    String PRINT_CHAR = "printChar(";
    String PRINT_BIT = "printBit(";
    String READ_CHAR = " = readChar()";
    String READ_BIT = " = readBit()";
    String CLOSING_BRACKET = ")";
    String OPENING_CURVY_BRACKET = " {";
    String CLOSING_CURVY_BRACKET = "}";
    String WHILE = "while (";
    String STORE_BIT = "storeBit(";
    String GET_STORED_BIT = " = getStoredBit()";

    /**
     * Transpiles provided BF code to higher level language.
     * @param code String BF input
     * @return String higher level output
     */
    String toHighLevel(String code);

    /**
     * Transpiles provided higher level code to BF.
     * @param highLevelCode String
     * @return String BF result
     */
    String fromHighLevel(String highLevelCode);
}
