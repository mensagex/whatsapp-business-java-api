package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Text parameter.
 * Required for URL buttons.
 * Developer-provided suffix that is appended to the predefined prefix URL in the template.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextParameter extends Parameter {
    @JsonProperty("text")
    private final String text;

    @JsonProperty("parameter_name")
    private final String parameterName;


    /**
     * Instantiates a new Text parameter.
     *
     * @param text the text
     */
    public TextParameter(String text) {
        super(ParameterType.TEXT);
        this.parameterName = null;
        this.text = text;
    }
    public TextParameter(String text, String parameterName) {
        super(ParameterType.TEXT);
        this.parameterName = parameterName;
        this.text = text;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    public String getParameterName() {
        return parameterName;
    }

}
