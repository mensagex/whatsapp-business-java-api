package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.templates.type.ButtonType;

/**
 * The type Voice call button.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoiceCallButton extends Button {

    @JsonProperty("phone_number")
    private String phoneNumber;

    /**
     * Instantiates a new Voice call button.
     */
    protected VoiceCallButton() {
        super(ButtonType.VOICE_CALL);
    }

    /**
     * Instantiates a new Voice call button.
     *
     * @param text        the text
     * @param phoneNumber the phone number
     */
    public VoiceCallButton(String text, String phoneNumber) {
        super(ButtonType.VOICE_CALL, text);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     * @return the voice call button
     */
    public VoiceCallButton setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
