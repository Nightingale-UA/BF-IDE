package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import com.nightingale.bf.service.SourceBuilder;
import com.nightingale.bf.service.execute.Executor;
import com.nightingale.bf.service.transpile.Transpiler;
import org.springframework.stereotype.Service;

@Service("miniStringService")
public class MainService extends BaseService {
    private final LangSpec miniStringSpec;
    private final Executor miniStringExecutor;
    private final SourceBuilder miniStringSourceBuilder;
    private final Transpiler miniStringTranspiler;

    public MainService(LangSpec miniStringSpec,
                       Executor miniStringExecutor,
                       SourceBuilder miniStringSourceBuilder,
                       Transpiler miniStringTranspiler) {
        this.miniStringSpec = miniStringSpec;
        this.miniStringExecutor = miniStringExecutor;
        this.miniStringSourceBuilder = miniStringSourceBuilder;
        this.miniStringTranspiler = miniStringTranspiler;
    }

    @Override
    public LangSpec getLangSpec() {
        return miniStringSpec;
    }

    @Override
    protected Executor getExecutor() {
        return miniStringExecutor;
    }

    @Override
    protected SourceBuilder getSourceBuilder() {
        return miniStringSourceBuilder;
    }

    @Override
    protected Transpiler getTranspiler() {
        return miniStringTranspiler;
    }
}
