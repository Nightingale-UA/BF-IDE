package com.nightingale.bf.model.spec;

import com.nightingale.bf.model.LangType;

public class BoolSpec extends BaseSpec {
    @Override
    protected LangType getType() {
        return LangType.BOOL;
    }
}
