package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.model.spec.LangSpec;
import com.nightingale.bf.service.BaseService;
import org.springframework.stereotype.Service;

@Service("miniStringService")
public class MainService extends BaseService {
    private final LangSpec miniStringSpec;

    public MainService(LangSpec miniStringSpec) {
        this.miniStringSpec = miniStringSpec;
    }

    @Override
    public LangSpec getLangSpec() {
        return miniStringSpec;
    }
}
