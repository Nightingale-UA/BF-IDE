package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.service.SourceBuilder;
import com.nightingale.bf.service.language.ministring.MainService;
import org.springframework.stereotype.Service;

@Service("miniStringSourceBuilder")
public class SourceBuilderImpl implements SourceBuilder {
    @Override
    public String fromExecutionResult(String target) {
        return "Not implemented yet";
    }
}
