package com.nightingale.bf.service;

import com.nightingale.bf.model.LangType;
import com.nightingale.bf.model.token.LangSpecificToken;
import com.nightingale.bf.model.token.SwapToken;

import java.util.Arrays;
import java.util.Collection;

public class SwapService extends BaseBitService {
    @Override
    protected LangType getType() {
        return LangType.SWAP;
    }

    @Override
    public Collection<LangSpecificToken> getAvailableTokens() {
        return Arrays.asList(SwapToken.values());
    }
}
