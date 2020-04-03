package com.nightingale.bf.service.language.small;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import org.springframework.stereotype.Service;

@Service("smallService")
public class MainService extends BaseService {
    private final LangSpec smallSpec;

    public MainService(LangSpec smallSpec) {
        this.smallSpec = smallSpec;
    }

    @Override
    public LangSpec getLangSpec() {
        return smallSpec;
    }
}
