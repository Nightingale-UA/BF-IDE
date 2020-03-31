package com.nightingale.bf.service;

public interface SourceBuilder {
    /**
     * Get BF source code, executions of which results in provided string.
     * @param target String BF execution result
     * @return String possible BF source
     */
    String fromExecutionResult(String target);
}
