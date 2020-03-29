package com.nightingale.bf.service.optimize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniStringOptimizerTest {
    private final MiniStringOptimizer optimizer = new MiniStringOptimizer();

    @Test
    public void shouldReturnInput() {
        assertEquals("+++++.++++.+.", optimizer.optimize("+++++.++++.+."));
    }
}
