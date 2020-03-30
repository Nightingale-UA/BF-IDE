package com.nightingale.bf.service.transpile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolTranspilerTest {
    private final Transpiler transpiler = new BoolTranspiler();

    @Test
    public void shouldTranspileToHighLevel() {
        assertEquals("printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n",
            transpiler.toHighLevel(";;;+;+;;+;+;\n" +
                "+;+;+;+;;+;;+;\n" +
                ";;+;;+;+;;+;\n" +
                ";;+;;+;+;;+;\n" +
                "+;;;;+;+;;+;\n" +
                ";;+;;+;+;+;;\n" +
                ";;;;;+;+;;\n" +
                "+;;;+;+;;;+;\n" +
                "+;;;;+;+;;+;\n" +
                ";+;+;;+;;;+;\n" +
                ";;+;;+;+;;+;\n" +
                ";;+;+;;+;;+;\n" +
                "+;+;;;;+;+;;\n" +
                ";+;+;+;")
        );
    }
}
