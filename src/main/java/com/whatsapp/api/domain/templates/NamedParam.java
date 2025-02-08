package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NamedParam {
    @JsonProperty("param_name")
    private String paramName;

    @JsonProperty("example")
    private String example;

    // Getters e Setters
    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
