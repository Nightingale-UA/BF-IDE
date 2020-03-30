package com.nightingale.bf.service.executor;

import com.nightingale.bf.service.execute.Executor;
import com.nightingale.bf.service.execute.SwapExecutor;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapExecutorTest {
    private final Executor executor = new SwapExecutor();

    @Test
    public void shouldExecuteCorrectly() {
        assertEquals("Hello, World!", executor.execute(
                "@>.@.@<..@.@>... // H .@..@<..@.@>.@. // e" +
                        "@<.@..@>.@..@<.. // l .@..@>.@..@<.. // l " +
                        ".@..@>.@.... // o @<..@.@>.@..@<.. // , " +
                        "..@.@>..... //  .@.@<.@.@>.@... // W " +
                        "@<.@..@>.@.... // o @<.@...@>..@.@<. // r " +
                        ".@..@>.@..@<.. // l .@..@>..@.@<.. // d " +
                        "..@.@>....@. // !",
                new ArrayDeque<>(Collections.singletonList(0x80))));
    }
}
