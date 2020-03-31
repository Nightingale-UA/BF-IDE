package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.model.language.brain.Spec;
import com.nightingale.bf.service.Executor;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrainExecutorTest {
    private final Executor executor = new ExecutorImpl(new Optimizer(new Spec()));

    @Test
    public void shouldExecuteCorrectly() {
        assertEquals("Hello, World!", executor.execute(
                "+[-->-[>>+>-----<<]<--<---]>-.>>>+.>>..+++[.>]<<<<.+++.------.<<-.>>>>+.",
                new ArrayDeque<>()));
    }
}
