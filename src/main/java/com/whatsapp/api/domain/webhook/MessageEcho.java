package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.MessageType;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MessageEcho(

        @JsonProperty("from") String from,
        @JsonProperty("to") String to,
        @JsonProperty("id") String id,
        @JsonProperty("timestamp") String timestamp,
        @JsonProperty("text") Text text,
        @JsonProperty("type") MessageType type

) { }
