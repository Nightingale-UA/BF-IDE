package com.nightingale.bf.model.api;

import java.util.Collection;

public class LanguageRequest {
    private final String code;
    private final Collection<Integer> input;

    public LanguageRequest(String code, Collection<Integer> input) {
        this.code = code;
        this.input = input;
    }

    public String getCode() {
        return code;
    }

    public Collection<Integer> getInput() {
        return input;
    }
}
