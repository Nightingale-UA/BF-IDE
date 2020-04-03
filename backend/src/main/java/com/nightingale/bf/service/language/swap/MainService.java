package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import org.springframework.stereotype.Service;

@Service("swapService")
public class MainService extends BaseService {
    private final LangSpec swapSpec;

    public MainService(LangSpec swapSpec) {
        this.swapSpec = swapSpec;
    }

    @Override
    public LangSpec getLangSpec() {
        return swapSpec;
    }
}
