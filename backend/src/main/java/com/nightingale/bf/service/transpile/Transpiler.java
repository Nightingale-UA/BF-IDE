package com.nightingale.bf.service.transpile;

import com.nightingale.bf.model.spec.LangSpec;

public interface Transpiler extends LangSpec {
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
    String PRINT_CHAR = "putchar(";
    String READ_CHAR = " = getchar()";
    String CLOSING_BRACKET = ")";
    String OPENING_CURVY_BRACKET = " {";
    String CLOSING_CURVY_BRACKET = "}";
    String WHILE = "while (";

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
