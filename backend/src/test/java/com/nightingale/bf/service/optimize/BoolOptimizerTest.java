package com.nightingale.bf.service.optimize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolOptimizerTest {
    private final BoolOptimizer boolOptimizer = new BoolOptimizer();

    @Test
    public void shouldOptimizeFlipping() {
        assertEquals("+>+>+", boolOptimizer.optimize("+++++>+++>+++++++"));
    }

    @Test
    public void shouldOptimizeMovement() {
        assertEquals(">>+<", boolOptimizer.optimize(">><>><<>+<<<>>"));
    }

    @Test
    public void shouldOptimizeCycles() {
        assertEquals(">>+>[+>]", boolOptimizer.optimize(">>+[[[]]]>[[][]+>]"));
    }
}
