package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.service.SourceBuilder;
import org.springframework.stereotype.Service;

@Service("boolSourceBuilder")
public class SourceBuilderImpl implements SourceBuilder {
    @Override
    public String fromExecutionResult(String target) {
        return "Not implemented yet";
    }
}
