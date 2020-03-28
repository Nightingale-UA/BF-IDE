package com.nightingale.bf.service.source;

import com.nightingale.bf.model.spec.LangSpec;

public interface SourceBuilder extends LangSpec {
    /**
     * Get BF source code, executions of which results in provided string.
     * @param target String BF execution result
     * @return String possible BF source
     */
    String fromExecutionResult(String target);
}
