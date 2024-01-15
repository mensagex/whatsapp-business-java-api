package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.templates.type.ButtonType;

/**
 * The type Catalog button.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogButton extends Button {

    /**
     * Instantiates a new MPM button.
     */
    protected CatalogButton() {
        super(ButtonType.CATALOG);
    }

    /**
     * Instantiates a new MPM button.
     *
     * @param text the text
     */
    public CatalogButton(String text) {
        super(ButtonType.CATALOG, text);
    }

}
