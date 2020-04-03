package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import org.springframework.stereotype.Service;

@Service("brainService")
public class MainService extends BaseService {
    private final LangSpec brainSpec;

    public MainService(LangSpec brainSpec) {
        this.brainSpec = brainSpec;
    }

    @Override
    public LangSpec getLangSpec() {
        return brainSpec;
    }
}
