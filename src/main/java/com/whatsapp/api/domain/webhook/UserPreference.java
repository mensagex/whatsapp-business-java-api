package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Representa a preferência do usuário (ex.: parar de receber marketing).
 *
 * @param waId      Número do usuário no WhatsApp
 * @param detail    Descrição do motivo da preferência
 * @param category  Categoria da preferência (ex.: marketing_messages)
 * @param value     Valor da preferência (ex.: "stop")
 * @param timestamp Timestamp UNIX em segundos
 */
public record UserPreference(
        @JsonProperty("wa_id") String waId,
        @JsonProperty("detail") String detail,
        @JsonProperty("category") String category,
        @JsonProperty("value") String value,
        @JsonProperty("timestamp") Long timestamp
) {}
