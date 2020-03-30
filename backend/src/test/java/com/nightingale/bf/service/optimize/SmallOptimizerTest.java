package com.nightingale.bf.service.optimize;

import com.nightingale.bf.service.SmallService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallOptimizerTest {
    private final Optimizer optimizer = new SmallService();

    @Test
    public void shouldOptimizeFlipping() {
        assertEquals("*>*>*", optimizer.optimize("*****>***>*******"));
    }

    @Test
    public void shouldOptimizeMovement() {
        assertEquals(">>*<", optimizer.optimize(">><>><<>*<<<>>"));
    }

    @Test
    public void shouldOptimizeCycles() {
        assertEquals(">>*>[*>]", optimizer.optimize(">>*[[[]]]>[[][]*>]"));
    }
}
