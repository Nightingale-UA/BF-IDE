package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.language.bool.Spec;
import com.nightingale.bf.model.spec.LangSpec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolTranspilerTest {
    private final LangSpec spec = new Spec();
    private final Transpiler transpiler = new Transpiler(
        new Operations(spec, new Optimizer(spec)));

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
