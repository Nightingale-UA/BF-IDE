package com.nightingale.bf.service.optimize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrainOptimizerTest {
    private final BrainOptimizer brainOptimizer = new BrainOptimizer();

    @Test
    public void shouldOptimizeAddSubtract() {
        assertEquals("+>->+", brainOptimizer.optimize("++---++>---++>+--++"));
    }

    @Test
    public void shouldOptimizeMovement() {
        assertEquals(">>+<", brainOptimizer.optimize(">><>><<>+<<<>>"));
    }

    @Test
    public void shouldOptimizeCycles() {
        assertEquals(">>++>-[+>-]", brainOptimizer.optimize(">>+[[[]]]+>-[[][]+>-]"));
    }
}
