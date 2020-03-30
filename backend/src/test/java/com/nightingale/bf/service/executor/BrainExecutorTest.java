package com.nightingale.bf.service.executor;

import com.nightingale.bf.service.execute.BrainExecutor;
import com.nightingale.bf.service.execute.Executor;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrainExecutorTest {
    private final Executor executor = new BrainExecutor();

    @Test
    public void shouldExecuteCorrectly() {
        assertEquals("Hello, World!", executor.execute(
                "+[-->-[>>+>-----<<]<--<---]>-.>>>+.>>..+++[.>]<<<<.+++.------.<<-.>>>>+.",
                new ArrayDeque<>()));
    }
}
