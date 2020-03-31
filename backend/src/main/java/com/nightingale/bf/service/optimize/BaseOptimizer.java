package com.nightingale.bf.service.optimize;

public abstract class BaseOptimizer implements Optimizer {
    @Override
    public String optimize(String code) {
        var result = code;
        while (result.matches(".*(" + getOptimizationPattern() + ").*"))	{
            result = result.replaceAll(getOptimizationPattern(), "");
        }
        return result;
    }

    protected abstract String getOptimizationPattern();
}
