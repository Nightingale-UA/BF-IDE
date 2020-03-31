package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.language.bool.Spec;
import com.nightingale.bf.service.Executor;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolExecutorTest {
    private final Executor executor = new ExecutorImpl(new Optimizer(new Spec()));
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
