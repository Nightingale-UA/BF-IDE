package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.language.bool.Spec;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolExecutorTest {
    private final Executor executor = new Executor(new Operations(new Spec()));

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

    @Test
    public void shouldReadInputInLittleEndianStyle() {
        // H -> W
        assertEquals("W", executor.execute(
            ",,>,,;;;<;>>,,>,;>,;<;>;",
            Collections.singletonList(0x48)));
    }
}
