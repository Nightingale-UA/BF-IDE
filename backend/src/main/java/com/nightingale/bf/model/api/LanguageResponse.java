package com.nightingale.bf.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageResponse {
    private final String result;

    public LanguageResponse(@JsonProperty("result") String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
