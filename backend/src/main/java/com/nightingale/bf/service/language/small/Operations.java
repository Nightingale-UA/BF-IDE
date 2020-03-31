package com.nightingale.bf.service.language.small;

import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.operation.BaseOperations;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("smallOperations")
public class Operations extends BaseOperations {
    private final LangSpec smallSpec;

    public Operations(LangSpec smallSpec) {
        this.smallSpec = smallSpec;
    }

    @Override
    protected Map<OperationType, String> getOperations() {
        return smallSpec.getOperations();
    }
}
