package com.nightingale.bf.service;

import com.nightingale.bf.model.spec.LangSpec;

import java.util.Collection;

public interface LangService {
    LangSpec getLangSpec();

    String execute(String code, Collection<Integer> input);
}
