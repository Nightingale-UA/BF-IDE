package com.nightingale.bf.service;

import com.nightingale.bf.model.LangType;

public abstract class MiniStringSpec implements LangSpec {
    @Override
    public LangType getType() {
        return LangType.MINI_STRING;
    }
}
