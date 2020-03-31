package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.operation.BaseOperations;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("brainOperations")
public class Operations extends BaseOperations {
    private final LangSpec brainSpec;

    public Operations(LangSpec brainSpec) {
        this.brainSpec = brainSpec;
    }

    @Override
    protected Map<OperationType, String> getOperations() {
        return brainSpec.getOperations();
    }
}
