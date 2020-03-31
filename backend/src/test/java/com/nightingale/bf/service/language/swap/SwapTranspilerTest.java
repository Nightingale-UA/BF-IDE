package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.model.language.swap.Spec;
import com.nightingale.bf.service.Transpiler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapTranspilerTest {
    private final Transpiler transpiler = new TranspilerImpl(
        new Operations(new Spec()), new Optimizer(new Spec()));

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
