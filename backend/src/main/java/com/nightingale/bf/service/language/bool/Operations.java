package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.operation.BaseOperations;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("boolOperations")
public class Operations extends BaseOperations {
    private final LangSpec boolSpec;

    public Operations(LangSpec boolSpec) {
        this.boolSpec = boolSpec;
    }

    @Override
    protected Map<OperationType, String> getOperations() {
        return boolSpec.getOperations();
    }
}
