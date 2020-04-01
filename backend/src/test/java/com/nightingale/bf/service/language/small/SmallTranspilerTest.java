package com.nightingale.bf.service.language.small;

import com.nightingale.bf.model.language.small.Spec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallTranspilerTest {
    private final com.nightingale.bf.service.transpile.Transpiler transpiler = new Transpiler(
        new Operations(new Spec()), new Optimizer(new Spec()));

    @Test
    public void shouldTranspileToHighLevel() {
        assertEquals(
            "p += 1\n" +
                "*p ^= 1\n" +
                "p += 4\n" +
                "*p ^= 1\n" +
                "while (*p) {\n" +
                "    p += 1\n" +
                "    *p ^= 1\n" +
                "    p += 2\n" +
                "    *p ^= 1\n" +
                "}\n",
            transpiler.toHighLevel(">>**<*>>>>*[>*>>*]")
        );
    }
}
