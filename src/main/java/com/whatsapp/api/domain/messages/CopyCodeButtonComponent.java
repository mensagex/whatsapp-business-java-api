package com.whatsapp.api.domain.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ButtonSubType;

/**
 * The type Button component.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CopyCodeButtonComponent extends ButtonComponent {
	
	@JsonProperty("index")
    private int index;
	
    @JsonProperty("parameters")
    private List<CopyCodeButtonParameter> parameters;

	public CopyCodeButtonComponent(int index) {
		super(index, ButtonSubType.COPY_CODE);
	}
}
