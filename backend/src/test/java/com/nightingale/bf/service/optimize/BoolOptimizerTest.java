package com.nightingale.bf.service.optimize;

import com.nightingale.bf.model.spec.BoolSpec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolOptimizerTest {
    private final Optimizer optimizer = new BoolSpec();

    @Test
    public void shouldOptimizeFlipping() {
        assertEquals("+>+>+", optimizer.optimize("+++++>+++>+++++++"));
    }

    @Test
    public void shouldOptimizeMovement() {
        assertEquals(">>+<", optimizer.optimize(">><>><<>+<<<>>"));
    }

    @Test
    public void shouldOptimizeCycles() {
        assertEquals(">>+>[+>]", optimizer.optimize(">>+[[[]]]>[[][]+>]"));
    }
}
