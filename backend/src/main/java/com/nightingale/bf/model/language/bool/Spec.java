package com.nightingale.bf.model.language.bool;

import com.nightingale.bf.model.LangType;
import com.nightingale.bf.model.RegexConstants.Operation;
import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.BaseSpec;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.Map.entry;

@Component("boolSpec")
public class Spec extends BaseSpec {
    private static final Map<OperationType, String> OPERATIONS =
        Map.ofEntries(
            entry(OperationType.FLIP, Operation.Bool.FLIP),
            entry(OperationType.IN, Operation.Brain.IN),
            entry(OperationType.OUT, Operation.Bool.OUT),
            entry(OperationType.RIGHT, Operation.Brain.RIGHT),
            entry(OperationType.LEFT, Operation.Brain.LEFT),
            entry(OperationType.START, Operation.Brain.START),
            entry(OperationType.END, Operation.Brain.END)
        );

    @Override
    protected LangType getType() {
        return LangType.BOOL;
    }

    @Override
    public Map<OperationType, String> getOperations() {
        return OPERATIONS;
    }
}
