package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import com.nightingale.bf.service.SourceBuilder;
import com.nightingale.bf.service.execute.Executor;
import com.nightingale.bf.service.transpile.Transpiler;
import org.springframework.stereotype.Service;

@Service("brainService")
public class MainService extends BaseService {
    private final LangSpec brainSpec;
    private final Executor brainExecutor;
    private final SourceBuilder brainSourceBuilder;
    private final Transpiler brainTranspiler;

    public MainService(LangSpec brainSpec,
                       Executor brainExecutor,
                       SourceBuilder brainSourceBuilder,
                       Transpiler brainTranspiler) {
        this.brainSpec = brainSpec;
        this.brainExecutor = brainExecutor;
        this.brainSourceBuilder = brainSourceBuilder;
        this.brainTranspiler = brainTranspiler;
    }

    @Override
    public LangSpec getLangSpec() {
        return brainSpec;
    }

    @Override
    protected Executor getExecutor() {
        return brainExecutor;
    }

    @Override
    protected SourceBuilder getSourceBuilder() {
        return brainSourceBuilder;
    }

    @Override
    protected Transpiler getTranspiler() {
        return brainTranspiler;
    }
}
