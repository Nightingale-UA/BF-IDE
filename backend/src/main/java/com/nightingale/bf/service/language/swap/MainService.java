package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import com.nightingale.bf.service.execute.Executor;
import org.springframework.stereotype.Service;

@Service("swapService")
public class MainService extends BaseService {
    private final LangSpec swapSpec;
    private final Executor swapExecutor;

    public MainService(LangSpec swapSpec, Executor swapExecutor) {
        this.swapSpec = swapSpec;
        this.swapExecutor = swapExecutor;
    }

    @Override
    public LangSpec getLangSpec() {
        return swapSpec;
    }

    @Override
    protected Executor getExecutor() {
        return swapExecutor;
    }
}
