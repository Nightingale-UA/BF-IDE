package com.nightingale.bf.model.language.swap;

import com.nightingale.bf.model.LangType;
import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.BaseSpec;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.Map.entry;

@Component("swapSpec")
public class Spec extends BaseSpec {
    private static final Map<OperationType, String> OPERATIONS =
        Map.ofEntries(
            entry(OperationType.SWAP, "@"), entry(OperationType.OUT, "\\."),
            entry(OperationType.RIGHT, ">+"), entry(OperationType.LEFT, "<+"),
            entry(OperationType.START, "\\["), entry(OperationType.END, "\\]")
        );

    @Override
    protected LangType getType() {
        return LangType.SWAP;
    }

    @Override
    public Map<OperationType, String> getOperations() {
        return OPERATIONS;
    }
}
