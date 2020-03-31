package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.model.language.ministring.Spec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniStringOptimizerTest {
    private final Optimizer optimizer = new Optimizer(new Spec());

    @Test
    public void shouldReturnInput() {
        assertEquals("+++++.++++.+.", optimizer.optimize("+++++.++++.+."));
    }
}
