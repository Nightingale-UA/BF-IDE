package com.nightingale.bf.service;

import com.nightingale.bf.model.LangType;

public class SwapService extends BaseBitService {
    @Override
    protected LangType getType() {
        return LangType.SWAP;
    }
}
