package com.nightingale.bf.service;

import com.nightingale.bf.service.execute.Executor;
import com.nightingale.bf.service.transpile.Transpiler;

import java.util.Collection;

public abstract class BaseService implements LangService {
    @Override
    public String execute(String code, Collection<Integer> input) {
        return getExecutor().execute(code, input);
    }

    @Override
    public String fromExecutionResult(String target) {
        return getSourceBuilder().fromExecutionResult(target);
    }

    @Override
    public String toHighLevel(String code) {
        return getTranspiler().toHighLevel(code);
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return getTranspiler().fromHighLevel(highLevelCode);
    }

    protected abstract Executor getExecutor();

    protected abstract SourceBuilder getSourceBuilder();

    protected abstract Transpiler getTranspiler();
}
