package com.nightingale.bf.service;

import com.nightingale.bf.model.LangType;
import com.nightingale.bf.model.token.BrainToken;
import com.nightingale.bf.model.token.LangSpecificToken;

import java.util.Arrays;
import java.util.Collection;

public class BrainService extends BaseByteService {
    @Override
    protected LangType getType() {
        return LangType.BRAIN;
    }

    @Override
    public Collection<LangSpecificToken> getAvailableTokens() {
        return Arrays.asList(BrainToken.values());
    }
}
