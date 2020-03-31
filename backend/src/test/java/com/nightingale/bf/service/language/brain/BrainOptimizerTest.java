package com.nightingale.bf.service.language.brain;
import com.nightingale.bf.model.language.brain.Spec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrainOptimizerTest {
    private final Optimizer optimizer = new Optimizer(new Spec());

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
