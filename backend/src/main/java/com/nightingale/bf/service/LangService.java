package com.nightingale.bf.service;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.execute.Executor;
import com.nightingale.bf.service.transpile.Transpiler;

public interface LangService extends Executor, Transpiler, SourceBuilder {
    LangSpec getLangSpec();
}
