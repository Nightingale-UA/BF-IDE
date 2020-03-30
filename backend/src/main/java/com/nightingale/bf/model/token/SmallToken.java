package com.nightingale.bf.model.token;

public enum SmallToken implements LangSpecificToken {
    FLIP(TokenType.FLIP, "\\*"),
    RIGHT(TokenType.RIGHT, ">+"), LEFT(TokenType.LEFT, "<+"),
    START(TokenType.START, "\\["), END(TokenType.END, "\\]");

    private final TokenType type;
    private final String value;

    SmallToken(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public TokenType getType() {
        return type;
    }

    @Override
    public String getPattern() {
        return value;
    }
}
