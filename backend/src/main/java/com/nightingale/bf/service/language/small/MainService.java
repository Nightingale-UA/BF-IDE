package com.nightingale.bf.service.language.small;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import com.nightingale.bf.service.SourceBuilder;
import com.nightingale.bf.service.execute.Executor;
import com.nightingale.bf.service.transpile.Transpiler;
import org.springframework.stereotype.Service;

@Service("smallService")
public class MainService extends BaseService {
    private final LangSpec smallSpec;
    private final Executor smallExecutor;
    private final SourceBuilder smallSourceBuilder;
    private final Transpiler smallTranspiler;

    public MainService(LangSpec smallSpec,
                       Executor smallExecutor,
                       SourceBuilder smallSourceBuilder,
                       Transpiler smallTranspiler) {
        this.smallSpec = smallSpec;
        this.smallExecutor = smallExecutor;
        this.smallSourceBuilder = smallSourceBuilder;
        this.smallTranspiler = smallTranspiler;
    }

    @Override
    public LangSpec getLangSpec() {
        return smallSpec;
    }

    @Override
    protected Executor getExecutor() {
        return smallExecutor;
    }

    @Override
    protected SourceBuilder getSourceBuilder() {
        return smallSourceBuilder;
    }

    @Override
    protected Transpiler getTranspiler() {
        return smallTranspiler;
    }
}
