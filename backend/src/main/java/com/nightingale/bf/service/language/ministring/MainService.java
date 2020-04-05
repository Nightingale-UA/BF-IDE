package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import com.nightingale.bf.service.execute.Executor;
import org.springframework.stereotype.Service;

@Service("miniStringService")
public class MainService extends BaseService {
    private final LangSpec miniStringSpec;
    private final Executor miniStringExecutor;

    public MainService(LangSpec miniStringSpec, Executor miniStringExecutor) {
        this.miniStringSpec = miniStringSpec;
        this.miniStringExecutor = miniStringExecutor;
    }

    @Override
    public LangSpec getLangSpec() {
        return miniStringSpec;
    }

    @Override
    protected Executor getExecutor() {
        return miniStringExecutor;
    }
}
