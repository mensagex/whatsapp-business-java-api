package com.whatsapp.api.domain.templates;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.templates.type.ButtonType;

/**
 * The type Quick reply button.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CopyCodeButton extends Button {
	
    @JsonProperty("example")
    private List<String> urlExample;
    
    /**
     * Instantiates a new Copy code button.
     */
    protected CopyCodeButton() {
        super(ButtonType.COPY_CODE);
    }

    /**
     * Instantiates a new Copy code button.
     *
     * @param text the text
     */
    public CopyCodeButton(String text) {
        super(ButtonType.COPY_CODE, text);
    }

	public List<String> getUrlExample() {
		return urlExample;
	}

	public void setUrlExample(List<String> urlExample) {
		this.urlExample = urlExample;
	}

}
