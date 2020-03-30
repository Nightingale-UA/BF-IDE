package com.nightingale.bf.service;

import com.nightingale.bf.model.LangType;

public class SmallService extends BaseBitService {
    @Override
    protected LangType getType() {
        return LangType.SMALL;
    }
}
