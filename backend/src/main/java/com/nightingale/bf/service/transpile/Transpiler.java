package com.nightingale.bf.service.transpile;

public interface Transpiler {
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
