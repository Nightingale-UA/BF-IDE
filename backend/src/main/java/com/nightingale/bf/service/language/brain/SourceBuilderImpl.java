package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.service.SourceBuilder;
import org.springframework.stereotype.Service;

@Service("brainSourceBuilder")
public class SourceBuilderImpl implements SourceBuilder {
    @Override
    public String fromExecutionResult(String target) {
        return "Not implemented yet";
    }
}
