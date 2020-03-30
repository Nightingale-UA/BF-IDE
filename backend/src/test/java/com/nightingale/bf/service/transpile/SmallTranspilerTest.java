package com.nightingale.bf.service.transpile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallTranspilerTest {
    private final Transpiler transpiler = new SmallTranspiler();

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
