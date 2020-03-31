package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.model.language.brain.Spec;
import com.nightingale.bf.service.Transpiler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrainTranspilerTest {
    private final Transpiler transpiler = new TranspilerImpl(
        new Operations(new Spec()), new Optimizer(new Spec()));

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
                "printChar(*p)\n" +
                "p += 3\n" +
                "*p += 1\n" +
                "printChar(*p)\n" +
                "p += 2\n" +
                "printChar(*p)\n" +
                "printChar(*p)\n" +
                "*p += 3\n" +
                "while (*p) {\n" +
                "    printChar(*p)\n" +
                "    p += 1\n" +
                "}\n" +
                "p -= 4\n" +
                "printChar(*p)\n" +
                "*p += 3\n" +
                "printChar(*p)\n" +
                "*p -= 6\n" +
                "printChar(*p)\n" +
                "p -= 2\n" +
                "*p -= 1\n" +
                "printChar(*p)\n" +
                "p += 4\n" +
                "*p += 1\n" +
                "printChar(*p)\n",
            transpiler.toHighLevel("+[-->-[>>+>-----<<]<--<---]>-.>>>+.>>..+++[.>]<<<<.+++.------.<<-.>>>>+.")
        );
    }
}
