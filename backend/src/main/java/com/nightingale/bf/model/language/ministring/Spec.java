package com.nightingale.bf.model.language.ministring;

import com.nightingale.bf.model.LangType;
import com.nightingale.bf.model.RegexConstants.Operation;
import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.BaseSpec;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.Map.entry;

@Component("miniStringSpec")
public class Spec extends BaseSpec {
    private static final Map<OperationType, String> OPERATIONS =
        Map.ofEntries(
            entry(OperationType.INCR, Operation.Brain.INCR),
            entry(OperationType.OUT, Operation.Brain.OUT)
        );

    @Override
    protected LangType getType() {
        return LangType.MINI_STRING;
    }

    @Override
    public Map<OperationType, String> getOperations() {
        return OPERATIONS;
    }
}
