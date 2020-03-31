package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class MainService extends BaseService {
    private final LangSpec boolSpec;

    public MainService(LangSpec boolSpec) {
        this.boolSpec = boolSpec;
    }

    @Override
    public LangSpec getLangSpec() {
        return boolSpec;
    }
}
