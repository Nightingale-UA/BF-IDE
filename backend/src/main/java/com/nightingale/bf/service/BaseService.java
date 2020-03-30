package com.nightingale.bf.service;

import com.nightingale.bf.ctrl.Helper;
import com.nightingale.bf.model.spec.BaseSpec;
import com.nightingale.bf.model.token.LangSpecificToken;
import com.nightingale.bf.model.token.TokenData;
import com.nightingale.bf.service.optimize.Optimizer;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.stream.Collectors;

public abstract class BaseService extends BaseSpec implements Optimizer {
    protected Deque<TokenData> tokenize(String code) {
        return Helper.tokenize(code,
            getAvailableTokens().stream()
                .map(LangSpecificToken::getPattern)
                .collect(Collectors.joining("|"))).stream()
            .map(s -> new TokenData(
                determineType(s, getAvailableTokens()),
                s.length()))
            .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private LangSpecificToken determineType(
        String s, Collection<LangSpecificToken> availableTokens) {
        return availableTokens.stream()
            .filter(type -> s.matches(type.getPattern()))
            .findFirst().orElseThrow();
    }
}
