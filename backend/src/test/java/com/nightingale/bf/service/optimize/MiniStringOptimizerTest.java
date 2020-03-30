package com.nightingale.bf.service.optimize;

import com.nightingale.bf.model.spec.MiniStringSpec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniStringOptimizerTest {
    private final Optimizer optimizer = new MiniStringSpec();

    @Test
    public void shouldReturnInput() {
        assertEquals("+++++.++++.+.", optimizer.optimize("+++++.++++.+."));
    }
}
