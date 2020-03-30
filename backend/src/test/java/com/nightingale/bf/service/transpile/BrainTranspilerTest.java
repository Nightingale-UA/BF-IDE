package com.nightingale.bf.service.transpile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrainTranspilerTest {
    private final Transpiler transpiler = new BrainTranspiler();

    @Test
    public void shouldTranspileToHighLevel() {
        assertEquals(
            "*p += 1\n" +
                "while (*p) {\n" +
                "    *p -= 2\n" +
                "    p += 1\n" +
                "    *p -= 1\n" +
                "    while (*p) {\n" +
                "        p += 2\n" +
                "        *p += 1\n" +
                "        p += 1\n" +
                "        *p -= 5\n" +
                "        p -= 2\n" +
                "    }\n" +
                "    p -= 1\n" +
                "    *p -= 2\n" +
                "    p -= 1\n" +
                "    *p -= 3\n" +
                "}\n" +
                "p += 1\n" +
                "*p -= 1\n" +
                "putchar(*p)\n" +
                "p += 3\n" +
                "*p += 1\n" +
                "putchar(*p)\n" +
                "p += 2\n" +
                "putchar(*p)\n" +
                "putchar(*p)\n" +
                "*p += 3\n" +
                "while (*p) {\n" +
                "    putchar(*p)\n" +
                "    p += 1\n" +
                "}\n" +
                "p -= 4\n" +
                "putchar(*p)\n" +
                "*p += 3\n" +
                "putchar(*p)\n" +
                "*p -= 6\n" +
                "putchar(*p)\n" +
                "p -= 2\n" +
                "*p -= 1\n" +
                "putchar(*p)\n" +
                "p += 4\n" +
                "*p += 1\n" +
                "putchar(*p)\n",
            transpiler.toHighLevel("+[-->-[>>+>-----<<]<--<---]>-.>>>+.>>..+++[.>]<<<<.+++.------.<<-.>>>>+.")
        );
    }
}
