package com.nightingale.bf.service.optimize;

import com.nightingale.bf.service.LangSpec;

public interface Optimizer extends LangSpec {
    /**
     * Try to optimize provided BF source as much as possible.
     * @param code String BF source code
     * @return String optimized version of input
     */
    String optimize(String code);
}
