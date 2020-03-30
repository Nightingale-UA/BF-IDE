package com.nightingale.bf.service.optimize;

import com.nightingale.bf.service.SwapService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapOptimizerTest {
    private final Optimizer optimizer = new SwapService();

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
