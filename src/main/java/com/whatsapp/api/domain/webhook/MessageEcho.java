package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.MessageType;

import java.util.List;

/**
 * Igual ao {@link Message}, mas incluindo o campo "to" e marcando para ignorar
 * propriedades desconhecidas, permitindo qualquer tipo de mídia em echoes.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MessageEcho(

        @JsonProperty("reaction")    Reaction reaction,
        @JsonProperty("image")       Image image,
        @JsonProperty("sticker")     Sticker sticker,
        @JsonProperty("location")    Location location,
        @JsonProperty("contacts")    List<Contact> contacts,
        @JsonProperty("button")      Button button,
        @JsonProperty("context")     Context context,

        @JsonProperty("from")        String from,
        @JsonProperty("to")          String to,

        @JsonProperty("id")          String id,
        @JsonProperty("text")        Text text,
        @JsonProperty("errors")      List<Error> errors,
        @JsonProperty("type")        MessageType type,
        @JsonProperty("interactive") Interactive interactive,
        @JsonProperty("timestamp")   String timestamp,
        @JsonProperty("referral")    Referral referral,
        @JsonProperty("order")       Order order,
        @JsonProperty("system")      System system,
        @JsonProperty("video")       Video video,
        @JsonProperty("audio")       Audio audio,
        @JsonProperty("document")    Document document

) {}
