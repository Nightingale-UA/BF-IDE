package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.language.bool.Spec;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolExecutorTest {
    private final com.nightingale.bf.service.execute.Executor executor = new Executor(new Optimizer(new Spec()));
    @Test
    public void shouldExecuteCorrectly() {
        assertEquals("Hello, world!", executor.execute(
                ";;;+;+;;+;+;\n" +
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
                        ";+;+;+;",
                new ArrayDeque<>()));
    }
}
