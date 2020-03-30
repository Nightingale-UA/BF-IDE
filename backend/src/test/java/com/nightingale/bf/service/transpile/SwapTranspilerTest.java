package com.nightingale.bf.service.transpile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapTranspilerTest {
    private final Transpiler transpiler = new SwapTranspiler();

    @Test
    public void shouldTranspileToHighLevel() {
        assertEquals(
            "p += 2\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "storeBit(*p)\n" +
                "printBit(*p)\n" +
                "*p = getStoredBit()\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "storeBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p = getStoredBit()\n" +
                "printBit(*p)\n" +
                "while (*p) {\n" +
                "    storeBit(*p)\n" +
                "    p -= 2\n" +
                "    printBit(*p)\n" +
                "    printBit(*p)\n" +
                "    *p = getStoredBit()\n" +
                "}\n",
            transpiler.toHighLevel(">>..@.@...@..@.[@<<..@]")
        );
    }
}
