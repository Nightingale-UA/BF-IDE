package com.nightingale.bf.service.executor;

import com.nightingale.bf.service.execute.BoolExecutor;
import com.nightingale.bf.service.execute.Executor;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolExecutorTest {
    private final Executor executor = new BoolExecutor();
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
