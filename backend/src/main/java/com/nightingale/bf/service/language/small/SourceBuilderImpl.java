package com.nightingale.bf.service.language.small;

import com.nightingale.bf.service.SourceBuilder;
import com.nightingale.bf.service.language.small.MainService;
import org.springframework.stereotype.Service;

@Service("smallSourceBuilder")
public class SourceBuilderImpl implements SourceBuilder {
    @Override
    public String fromExecutionResult(String target) {
        return "Not implemented yet";
    }
}
