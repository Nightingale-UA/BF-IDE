package com.nightingale.bf.service;

import com.nightingale.bf.service.execute.Executor;

import java.util.Collection;

public abstract class BaseService implements LangService {
    @Override
    public String execute(String code, Collection<Integer> input) {
        return getExecutor().execute(code, input);
    }

    protected abstract Executor getExecutor();
}
