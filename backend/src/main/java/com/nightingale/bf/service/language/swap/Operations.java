package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.operation.BaseOperations;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("swapOperations")
public class Operations extends BaseOperations {
    private final LangSpec swapSpec;

    public Operations(LangSpec swapSpec) {
        this.swapSpec = swapSpec;
    }

    @Override
    protected Map<OperationType, String> getOperations() {
        return swapSpec.getOperations();
    }
}
