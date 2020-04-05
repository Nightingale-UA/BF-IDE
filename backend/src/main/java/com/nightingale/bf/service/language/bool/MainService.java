package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import com.nightingale.bf.service.execute.Executor;
import org.springframework.stereotype.Service;

@Service("boolService")
public class MainService extends BaseService {
    private final LangSpec boolSpec;
    private final Executor boolExecutor;

    public MainService(LangSpec boolSpec, Executor boolExecutor) {
        this.boolSpec = boolSpec;
        this.boolExecutor = boolExecutor;
    }

    @Override
    public LangSpec getLangSpec() {
        return boolSpec;
    }

    @Override
    protected Executor getExecutor() {
        return boolExecutor;
    }
}
