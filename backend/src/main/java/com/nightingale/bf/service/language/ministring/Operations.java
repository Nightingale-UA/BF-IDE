package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.model.operation.OperationType;
import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.operation.BaseOperations;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("miniStringOperations")
public class Operations extends BaseOperations {
    private final LangSpec miniStringSpec;

    public Operations(LangSpec miniStringSpec) {
        this.miniStringSpec = miniStringSpec;
    }

    @Override
    protected Map<OperationType, String> getOperations() {
        return miniStringSpec.getOperations();
    }
}
