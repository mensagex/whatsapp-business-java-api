package com.whatsapp.api.domain.messages;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.messages.type.ButtonSubType;

/**
 * The type Button component.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CopyCodeButtonComponent extends ButtonComponent {

	public CopyCodeButtonComponent(int index, String couponCode) {
		super(index, ButtonSubType.COPY_CODE);		
		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new CopyCodeButtonParameter(couponCode));
		setParameters(parameters);
	}
}
