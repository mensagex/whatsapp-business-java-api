package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.whatsapp.api.domain.messages.type.ParameterType;

@JsonInclude(Include.NON_NULL)
public class CopyCodeButtonParameter extends Parameter {

	@JsonProperty("coupon_code")
	private String couponCode;
	
	protected CopyCodeButtonParameter(String couponCode) {
		super(ParameterType.COUPON_CODE);
		this.couponCode = couponCode;

	}

	public String getCouponCode() {
		return couponCode;
	}

	public CopyCodeButtonParameter setCouponCode(String couponCode) {
		this.couponCode = couponCode;
		return this;
	}
}
