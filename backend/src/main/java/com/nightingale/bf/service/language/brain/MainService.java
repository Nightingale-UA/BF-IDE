package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import com.nightingale.bf.service.execute.Executor;
import org.springframework.stereotype.Service;

@Service("brainService")
public class MainService extends BaseService {
    private final LangSpec brainSpec;
    private final Executor brainExecutor;

    public MainService(LangSpec brainSpec, Executor brainExecutor) {
        this.brainSpec = brainSpec;
        this.brainExecutor = brainExecutor;
    }

    @Override
    public LangSpec getLangSpec() {
        return brainSpec;
    }

    @Override
    protected Executor getExecutor() {
        return brainExecutor;
    }
}
