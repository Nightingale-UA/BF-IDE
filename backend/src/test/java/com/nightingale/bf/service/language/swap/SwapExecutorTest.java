package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.model.language.swap.Spec;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapExecutorTest {
    private final Executor executor = new Executor(new Operations(new Spec()));

    @Test
    public void shouldExecuteCorrectly() {
        assertEquals("Hello, World!", executor.execute(
                "@>...@.@<..@.@>. // H @.@<.@.@>..@..@>. // e" +
                        "..@..@<.@..@>. // l ..@..@<.@..@>. // l " +
                        "@....@<.@..@>. // o ..@..@<.@.@>.. // , " +
                        ".....@.@<.. //  @...@>.@.@<.@.@>. // W " +
                        "@....@<.@..@>. // o .@.@<..@...@>. // r " +
                        "..@..@<.@..@>. // l ..@.@<..@..@>. // d " +
                        "@.@<....@.@>.. // !",
                new ArrayDeque<>(Collections.singletonList(0x80))));
    }

    @Test
    public void shouldExecuteCycle() {
        assertEquals("?", executor.execute(
            "[.>]<[.<]..", new ArrayDeque<>(Collections.singletonList(0xE0))));
    }
}
