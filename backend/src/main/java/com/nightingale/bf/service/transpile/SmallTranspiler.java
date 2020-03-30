package com.nightingale.bf.service.transpile;

import com.nightingale.bf.service.SmallService;

public class SmallTranspiler extends SmallService implements Transpiler {
    @Override
    public String toHighLevel(String code) {
        return null;
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }
}
