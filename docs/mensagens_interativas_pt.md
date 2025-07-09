# Enviando mensagens interativas

Este documento descreve como enviar mensagens interativas (com botões e com listas) usando a biblioteca *whatsapp-business-java-api* e como marcar mensagens como lidas. Também comenta sobre a ausência do recurso de "typing indicator".

## Pré-requisitos

- Java 17 ou superior
- Dependência da biblioteca conforme especificado no `pom.xml` (versão 0.3.3)

## Mensagens interativas com botões

A biblioteca permite construir uma mensagem do tipo **interactive** e definir o tipo como `button`. O trecho de exemplo abaixo, retirado do README, mostra como montar a estrutura da mensagem:

```java
var message = MessageBuilder.builder()
        .setTo(PHONE_NUMBER_1)
        .buildInteractiveMessage(InteractiveMessage.build()
                .setAction(new Action()
                        .addButton(new Button()
                                .setType(ButtonType.REPLY)
                                .setReply(new Reply()
                                        .setId("UNIQUE_BUTTON_ID_1")
                                        .setTitle("BUTTON_TITLE_1")))
                        .addButton(new Button()
                                .setType(ButtonType.REPLY)
                                .setReply(new Reply()
                                        .setId("UNIQUE_BUTTON_ID_2")
                                        .setTitle("BUTTON_TITLE_2")))
                )
                .setType(InteractiveMessageType.BUTTON)
                .setBody(new Body()
                        .setText("Body message"))
        );
```

Fonte: README linhas 234 a 259.

Após construir a mensagem, envie-a utilizando:

```java
MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
```

## Mensagens interativas com listas

O README também apresenta um exemplo completo para mensagens com listas. É possível definir seções e linhas dentro de cada seção:

```java
var message = MessageBuilder.builder()
        .setTo(PHONE_NUMBER_1)
        .buildInteractiveMessage(InteractiveMessage.build()
                .setAction(new Action()
                        .setButtonText("BUTTON_TEXT")
                        .addSection(new Section()
                                .setTitle("Title 1")
                                .addRow(new Row()
                                        .setId("SECTION_1_ROW_1_ID")
                                        .setTitle("Title 1")
                                        .setDescription("SECTION_1_ROW_1_DESCRIPTION"))
                                // outras linhas
                        )
                        // outras seções
                )
                .setType(InteractiveMessageType.LIST)
                .setHeader(new Header()
                        .setType(HeaderType.TEXT)
                        .setText("Header Text"))
                .setBody(new Body()
                        .setText("Body message"))
                .setFooter(new Footer()
                        .setText("Footer Text"))
        );
```

Fonte: README linhas 274 a 325.

A chamada de envio é a mesma utilizada para outros tipos de mensagem.

## Marcar mensagens como lidas

O projeto implementa o recurso de marcar mensagens como lidas utilizando a classe `ReadMessage` e o método `markMessageAsRead` da classe `WhatsappBusinessCloudApi`:

```java
ReadMessage message = new ReadMessage("123456");
var response = whatsappBusinessCloudApi.markMessageAsRead(PHONE_NUMBER_ID, message);
```

Esse método está definido conforme mostrado no código-fonte:

```java
public Response markMessageAsRead(String phoneNumberId, ReadMessage message) {
    return executeSync(whatsappBusinessCloudApiService.markMessageAsRead(phoneNumberId, message));
}
```

Fonte: `WhatsappBusinessCloudApi.java` linhas 126 a 136.

## Indicador de digitação

O repositório agora possui suporte ao envio do campo `typing_indicator` por meio da classe `TypingMessage` e do método `sendTypingIndicator` de `WhatsappBusinessCloudApi`.
Para exibir o indicador, monte um `TypingMessage` informando o `message_id` recebido no webhook e envie-o:

```java
TypingMessage typingMessage = new TypingMessage("<WHATSAPP_MESSAGE_ID>", new TypingIndicator("text"));
whatsappBusinessCloudApi.sendTypingIndicator(PHONE_NUMBER_ID, typingMessage);
```

## Conclusão

Com os exemplos acima é possível enviar mensagens interativas comuns (não-template) utilizando botões ou listas, marcar mensagens como lidas e exibir o indicador de digitação quando necessário. A biblioteca contém classes e builders para montar todas essas mensagens de forma simples.

