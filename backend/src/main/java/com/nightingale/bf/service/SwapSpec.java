package com.nightingale.bf.service;

import com.nightingale.bf.model.LangType;

public abstract class SwapSpec implements LangSpec {
    @Override
    public LangType getType() {
        return LangType.SWAP;
    }
}
