package com.nightingale.bf.service.optimize;

import com.nightingale.bf.model.spec.LangSpec;

public interface Optimizer extends LangSpec {
    /**
     * Try to optimize provided BF source as much as possible.
     * @param code String BF source code
     * @return String optimized version of input
     */
    default String optimize(String code) {
        var result = code;
        while (result.matches(".*(" + getOptimizationPattern() + ").*"))	{
            result = result.replaceAll(getOptimizationPattern(), "");
        }
        return result;
    }
}
