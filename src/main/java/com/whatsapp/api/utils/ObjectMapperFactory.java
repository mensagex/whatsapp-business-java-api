package com.whatsapp.api.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Provides configured {@link ObjectMapper} instances for the project.
 */
public final class ObjectMapperFactory {

    private static final ObjectMapper defaultObjectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private ObjectMapperFactory() {
    }

    /**
     * Returns the shared {@link ObjectMapper} configured to ignore unknown properties.
     *
     * @return configured {@link ObjectMapper}
     */
    public static ObjectMapper getDefaultObjectMapper() {
        return defaultObjectMapper;
    }
}
