package com.whatsapp.api.domain.webhook.type;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Message status.
 */
public enum MessageStatus {
    /**
     * Message received by WhatsApp server. (One checkmark)
     */
    SENT("sent"),
    /**
     * Message delivered to the recipient. (Two checkmarks)
     */
    DELIVERED("delivered"),
    /**
     * Message read by recipient. (Two blue checkmarks)
     */
    READ("read"),

    /**
     * Audio message played by recipient.
     */
    PLAYED("played"),

    /**
     * Message failed to send.(Red error triangle)
     */
    FAILED("failed"),
    /**
     * Message deleted by the user. (	Message is replaced in WhatsApp mobile with the note "This message was deleted".)
     */
    DELETED("deleted"),

    /**
     * Message status not recognized by the SDK.
     */
    UNKNOWN("unknown");

    private final String value;

    MessageStatus(String value) {
        this.value = value;
    }

    /**
     * Parses message status safely, mapping unknown values to {@link #UNKNOWN}.
     *
     * @param value raw value from payload
     * @return mapped message status
     */
    @JsonCreator
    public static MessageStatus fromValue(String value) {
        if (value == null) {
            return UNKNOWN;
        }

        for (var status : values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }

        return UNKNOWN;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
