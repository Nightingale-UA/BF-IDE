package com.nightingale.bf.service.executor;

import com.nightingale.bf.service.execute.BrainExecutor;
import com.nightingale.bf.service.execute.Executor;
import com.nightingale.bf.service.optimize.BrainOptimizer;
import com.nightingale.bf.service.optimize.Optimizer;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrainExecutorTest {
    private final Optimizer optimizer = new BrainOptimizer();
    private final Executor executor = new BrainExecutor(optimizer);

    @Test
    public void shouldExecuteCorrectly() {
        assertEquals("Hello, World!", executor.execute(
                "+[-->-[>>+>-----<<]<--<---]>-.>>>+.>>..+++[.>]<<<<.+++.------.<<-.>>>>+.",
                new ArrayDeque<>()));
    }
}
