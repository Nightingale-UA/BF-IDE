package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import com.nightingale.bf.service.SourceBuilder;
import com.nightingale.bf.service.execute.Executor;
import com.nightingale.bf.service.transpile.Transpiler;
import org.springframework.stereotype.Service;

@Service("swapService")
public class MainService extends BaseService {
    private final LangSpec swapSpec;
    private final Executor swapExecutor;
    private final SourceBuilder swapSourceBuilder;
    private final Transpiler swapTranspiler;

    public MainService(LangSpec swapSpec,
                       Executor swapExecutor,
                       SourceBuilder swapSourceBuilder,
                       Transpiler swapTranspiler) {
        this.swapSpec = swapSpec;
        this.swapExecutor = swapExecutor;
        this.swapSourceBuilder = swapSourceBuilder;
        this.swapTranspiler = swapTranspiler;
    }

    @Override
    public LangSpec getLangSpec() {
        return swapSpec;
    }

    @Override
    protected Executor getExecutor() {
        return swapExecutor;
    }

    @Override
    protected SourceBuilder getSourceBuilder() {
        return swapSourceBuilder;
    }

    @Override
    protected Transpiler getTranspiler() {
        return swapTranspiler;
    }
}
