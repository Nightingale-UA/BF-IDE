package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.service.SourceBuilder;
import com.nightingale.bf.service.language.swap.MainService;
import org.springframework.stereotype.Service;

@Service("swapSourceBuilder")
public class SourceBuilderImpl implements SourceBuilder {
    @Override
    public String fromExecutionResult(String target) {
        return "Not implemented yet";
    }
}
