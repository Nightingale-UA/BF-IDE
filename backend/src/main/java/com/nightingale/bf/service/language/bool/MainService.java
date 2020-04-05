package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import com.nightingale.bf.service.SourceBuilder;
import com.nightingale.bf.service.execute.Executor;
import com.nightingale.bf.service.transpile.Transpiler;
import org.springframework.stereotype.Service;

@Service("boolService")
public class MainService extends BaseService {
    private final LangSpec boolSpec;
    private final Executor boolExecutor;
    private final SourceBuilder boolSourceBuilder;
    private final Transpiler boolTranspiler;

    public MainService(LangSpec boolSpec,
                       Executor boolExecutor,
                       SourceBuilder boolSourceBuilder,
                       Transpiler boolTranspiler) {
        this.boolSpec = boolSpec;
        this.boolExecutor = boolExecutor;
        this.boolSourceBuilder = boolSourceBuilder;
        this.boolTranspiler = boolTranspiler;
    }

    @Override
    public LangSpec getLangSpec() {
        return boolSpec;
    }

    @Override
    protected Executor getExecutor() {
        return boolExecutor;
    }

    @Override
    protected SourceBuilder getSourceBuilder() {
        return boolSourceBuilder;
    }

    @Override
    protected Transpiler getTranspiler() {
        return boolTranspiler;
    }
}
