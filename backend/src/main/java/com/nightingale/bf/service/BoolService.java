package com.nightingale.bf.service;

import com.nightingale.bf.model.LangType;

public class BoolService extends BaseBitService {
    @Override
    protected LangType getType() {
        return LangType.BOOL;
    }
}
