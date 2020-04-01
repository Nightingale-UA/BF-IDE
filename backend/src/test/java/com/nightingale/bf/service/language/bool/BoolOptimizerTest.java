package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.language.bool.Spec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolOptimizerTest {
    private final Optimizer optimizer = new Optimizer(new Spec());

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