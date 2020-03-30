package com.nightingale.bf.service;

import com.nightingale.bf.model.LangType;

public class MiniStringService extends BaseByteService {
    @Override
    protected LangType getType() {
        return LangType.MINI_STRING;
    }
}
