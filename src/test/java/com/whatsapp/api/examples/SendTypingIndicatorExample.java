package com.whatsapp.api.examples;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;
import static com.whatsapp.api.TestConstants.TOKEN;

import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.TypingIndicator;
import com.whatsapp.api.domain.messages.TypingMessage;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

public class SendTypingIndicatorExample {

    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TOKEN);
        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        TypingMessage typingMessage = new TypingMessage("<WHATSAPP_MESSAGE_ID>", new TypingIndicator("text"));

        var response = whatsappBusinessCloudApi.sendTypingIndicator(PHONE_NUMBER_ID, typingMessage);

        System.out.println(response);
    }
}
