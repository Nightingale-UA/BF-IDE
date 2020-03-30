package com.nightingale.bf.service;

import com.nightingale.bf.model.LangType;

public class BrainService extends BaseByteService {
    @Override
    protected LangType getType() {
        return LangType.BRAIN;
    }
}
