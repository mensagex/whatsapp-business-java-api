package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.templates.type.ButtonType;

/**
 * The type MPM button.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MpmButton extends Button {

    /**
     * Instantiates a new MPM button.
     */
    protected MpmButton() {
        super(ButtonType.MPM);
    }

    /**
     * Instantiates a new MPM button.
     *
     * @param text the text
     */
    public MpmButton(String text) {
        super(ButtonType.MPM, text);
    }

}
