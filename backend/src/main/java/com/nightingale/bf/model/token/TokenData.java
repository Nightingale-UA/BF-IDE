package com.nightingale.bf.model.token;

public class TokenData {
    private final LangSpecificToken token;
    private final int length;

    public TokenData(LangSpecificToken token, int length) {
        this.token = token;
        this.length = length;
    }

    public LangSpecificToken getToken() {
        return token;
    }

    public int getLength() {
        return length;
    }
}
