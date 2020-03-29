package com.nightingale.bf.service.optimize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapOptimizerTest {
    private final SwapOptimizer optimizer = new SwapOptimizer();

    @Test
    public void shouldOptimizeSwapping() {
        assertEquals("@", optimizer.optimize("@@@@@"));
        assertEquals("@@", optimizer.optimize("@@@@@@"));
    }

    @Test
    public void shouldOptimizeMovement() {
        assertEquals(">>@<", optimizer.optimize(">><>><<>@<<<>>"));
    }

    @Test
    public void shouldOptimizeCycles() {
        assertEquals(">>@>[@>]", optimizer.optimize(">>@[[[]]]>[[][]@>]"));
    }
}
