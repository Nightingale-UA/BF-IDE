package com.nightingale.bf.service.optimize;

public interface Optimizer {
    /**
     * Try to optimize provided BF source as much as possible.
     * @param code String BF source code
     * @return String optimized version of input
     */
    String optimize(String code);
}
