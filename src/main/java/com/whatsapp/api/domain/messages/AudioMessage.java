package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Audio message.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AudioMessage extends MediaMessage<AudioMessage> {

    @JsonProperty("voice")
    private Boolean voice = Boolean.TRUE;

    /**
     * Gets voice.
     *
     * @return the voice flag
     */
    public Boolean getVoice() {
        return voice;
    }

    /**
     * Sets voice flag.
     *
     * @param voice optional flag to mark an audio as voice message
     * @return the audio message
     */
    public AudioMessage setVoice(Boolean voice) {
        this.voice = voice;
        return this;
    }
}
