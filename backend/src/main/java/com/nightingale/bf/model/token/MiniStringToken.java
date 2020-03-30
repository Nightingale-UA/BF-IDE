package com.nightingale.bf.model.token;

public enum MiniStringToken implements LangSpecificToken {
    INCR(TokenType.INCR, "\\++"),
    OUT(TokenType.OUT, "\\.");

    private final TokenType type;
    private final String pattern;

    MiniStringToken(TokenType type, String pattern) {
        this.type = type;
        this.pattern = pattern;
    }

    @Override
    public TokenType getType() {
        return type;
    }

    @Override
    public String getPattern() {
        return pattern;
    }
}
