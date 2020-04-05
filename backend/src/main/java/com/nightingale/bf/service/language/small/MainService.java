package com.nightingale.bf.service.language.small;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import com.nightingale.bf.service.execute.Executor;
import org.springframework.stereotype.Service;

@Service("smallService")
public class MainService extends BaseService {
    private final LangSpec smallSpec;
    private final Executor smallExecutor;

    public MainService(LangSpec smallSpec, Executor smallExecutor) {
        this.smallSpec = smallSpec;
        this.smallExecutor = smallExecutor;
    }

    @Override
    public LangSpec getLangSpec() {
        return smallSpec;
    }

    @Override
    protected Executor getExecutor() {
        return smallExecutor;
    }
}
