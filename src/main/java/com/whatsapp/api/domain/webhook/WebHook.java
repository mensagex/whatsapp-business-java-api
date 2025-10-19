package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.utils.ObjectMapperFactory;

/**
 * The type Webhook.
 * Use this class to deserialize webhook events
 */
public final class WebHook {
    private static final ObjectMapper mapper = ObjectMapperFactory.getDefaultObjectMapper();

    /**
     * Construct WebHookEvent object
     *
     * @param payload the webhook payload json sent by Whatsapp
     * @return an  WebHookEvent instance
     * @throws JsonProcessingException JsonProcessingException if deserialization fails.
     */
    public static WebHookEvent constructEvent(String payload) throws JsonProcessingException {

        return mapper.readValue(payload, WebHookEvent.class);

    }

}
