package com.nightingale.bf.service.optimize;

import com.nightingale.bf.model.spec.BrainSpec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrainOptimizerTest {
    private final Optimizer optimizer = new BrainSpec();

    @Test
    public void shouldOptimizeAddSubtract() {
        assertEquals("+>->+", optimizer.optimize("++---++>---++>+--++"));
    }

    @Test
    public void shouldOptimizeMovement() {
        assertEquals(">>+<", optimizer.optimize(">><>><<>+<<<>>"));
    }

    @Test
    public void shouldOptimizeCycles() {
        assertEquals(">>++>-[+>-]", optimizer.optimize(">>+[[[]]]+>-[[][]+>-]"));
    }
}
