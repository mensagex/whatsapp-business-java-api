package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Typing indicator object used in TypingMessage.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/typing-indicators">API documentation - typing indicators</a>
 */
public class TypingIndicator {
    @JsonProperty("type")
    private String type;

    public TypingIndicator() {
    }

    public TypingIndicator(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public TypingIndicator setType(String type) {
        this.type = type;
        return this;
    }
}
