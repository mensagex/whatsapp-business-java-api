package com.whatsapp.api.domain.templates.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.templates.Component;
import com.whatsapp.api.domain.templates.type.Category;

/**
 * The type Data item.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record Template(

        @JsonProperty("components") List<Component<?>> components,

        @JsonProperty("name") String name,

        @JsonProperty("language") String language,

        @JsonProperty("id") String id,

        @JsonProperty("category") Category category,
        @JsonProperty("previous_category") Category previousCategory,
        @JsonProperty("status") String status,
        @JsonProperty("sub_category") String subCategory) {
}