package com.nightingale.bf.service;

import com.nightingale.bf.model.LangType;
import com.nightingale.bf.model.token.LangSpecificToken;
import com.nightingale.bf.model.token.MiniStringToken;

import java.util.Arrays;
import java.util.Collection;

public class MiniStringService extends BaseByteService {
    @Override
    protected LangType getType() {
        return LangType.MINI_STRING;
    }

    @Override
    public Collection<LangSpecificToken> getAvailableTokens() {
        return Arrays.asList(MiniStringToken.values());
    }
}
