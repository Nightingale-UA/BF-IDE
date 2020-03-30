package com.nightingale.bf.model.token;

public interface LangSpecificToken {
    TokenType getType();
    String getPattern();
}
