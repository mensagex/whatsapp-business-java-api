package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Interactive.
 *
 * @param listReply   Used on Webhooks related to List Messages                    Contains a list {@link ListReply} object.
 * @param type        Contains the type of interactive object. Supported options are:<ul>                    <li>button_reply: for responses of Reply Buttons.</li>                    <li>list_reply: for responses to List Messages and other interactive objects.</li></ul>
 * @param buttonReply Used on Webhooks related to Reply Buttons.                    Contains a {@link ButtonReply} reply object.
 */
public record Interactive(

        @JsonProperty("list_reply") ListReply listReply,

        @JsonProperty("type") String type,

        @JsonProperty("button_reply") ButtonReply buttonReply) {

    /**
     * Checks if the interactive payload contains a list reply.
     *
     * @return {@code true} if a list reply is present; otherwise {@code false}
     */
    public boolean hasListReply() {
        return listReply != null;
    }

    /**
     * Safely returns the title from the list reply.
     *
     * @return the title when available or {@code null}
     */
    public String getListReplyTitle() {
        return listReply != null ? listReply.title() : null;
    }
}