# Guia de Replicação da Biblioteca WhatsApp Business Java API

A seguir apresentamos um resumo detalhado da estrutura do projeto e das principais classes da biblioteca **whatsapp-business-java-api**. O objetivo é fornecer um panorama claro para que o sistema possa ser reimplementado em outro contexto, mesmo com abordagens ou tecnologias diferentes.

## Visão Geral

A biblioteca provê um SDK em Java para utilização das APIs oficiais da Meta:
- **WhatsApp Business Cloud API** – envio de mensagens, upload/gerenciamento de mídias e interação direta com o WhatsApp.
- **WhatsApp Business Management API** – administração de contas, modelos de mensagem e números de telefone.

A autenticação é feita via token Bearer enviado nos cabeçalhos HTTP. Internamente é utilizado **Retrofit** com **OkHttp** para comunicação e **Jackson** para serialização JSON.

### Principais Classes de Entrada
- `WhatsappApiFactory` – ponto de criação dos clientes de API. Possui métodos para instanciar `WhatsappBusinessCloudApi` e `WhatsappBusinessManagementApi` a partir de um token.
- `WhatsappBusinessCloudApi` – implementação síncrona dos endpoints da Cloud API (envio de mensagens, upload de mídia, download, marcação de mensagens como lidas, indicador de digitação, etc.).
- `WhatsappBusinessManagementApi` – implementa operações de gerenciamento (criação de templates, consulta de números, verificação de códigos, configuração de commerce settings, etc.).

## Estrutura de Pacotes

```
com.whatsapp.api
├── configuration
├── domain
│   ├── config
│   ├── errors
│   ├── media
│   ├── messages
│   ├── phone
│   ├── response
│   ├── templates
│   └── webhook
├── exception
├── interceptor
├── impl
└── service
```

A seguir descrevemos brevemente a responsabilidade de cada subpacote e classes relevantes.

### configuration
- **WhatsappApiConfig** – define constantes como a versão da API (`v23.0`) e o domínio base (`https://graph.facebook.com/`). Possui método para alterar esse domínio se necessário.

### interceptor
- **AuthenticationInterceptor** – intercepta requisições HTTP adicionando o cabeçalho `Authorization: Bearer <token>`.

### service
Contém interfaces Retrofit que descrevem os endpoints REST:
- **WhatsappBusinessCloudApiService** – define chamadas de envio de mensagens, upload/download de mídias, marcação de mensagens como lidas e verificação em duas etapas.
- **WhatsappBusinessManagementApiService** – operações para templates, números de telefone e configurações de commerce.

### impl
Implementações de alto nível que utilizam as interfaces do pacote `service` e o gerador de serviços.
- **WhatsappBusinessCloudApi** – métodos síncronos que invocam os serviços Retrofit. Cada método converte diretamente para objetos de domínio (ex.: `sendMessage`, `uploadMedia`, `retrieveMediaUrl`, `downloadMediaFile`, `markMessageAsRead`, `sendTypingIndicator`, `twoStepVerification`).
- **WhatsappBusinessManagementApi** – disponibiliza métodos como `createMessageTemplate`, `updateMessageTemplate`, `retrieveTemplates`, `retrievePhoneNumber`, `requestCode`, `verifyCode`, `getWhatsappCommerceSettings`, etc.

### domain
Modelos de dados que representam tanto as requisições quanto as respostas da API. Os objetos são serializados/deserializados pelo Jackson. Alguns destaques:

- **config** – estruturas de configuração do commerce (`CommerceDataItem`, `GraphCommerceSettings`).
- **errors** – classes de erro retornadas pela API (`Error`, `ErrorData`, `WhatsappApiError`).
- **media** – representação de arquivos e tipos (`Media`, `MediaFile`, `FileType`, `UploadResponse`).
- **messages** – conjunto extenso de classes para todos os tipos de mensagens suportadas (texto, mídia, localização, interativas, templates etc.). Inclui builders para facilitar a criação das mensagens.
- **phone** – modelos relacionados a números de telefone e verificação (`PhoneNumber`, `PhoneNumbers`, `RequestCode`, `VerifyCode`, `TwoStepCode`, além de enums para tipos de código ou status).
- **response** – objetos auxiliares de paginação e resposta padrão (`Response`, `Paging`, `Cursors`).
- **templates** – componentes e estrutura das mensagens template (corpo, cabeçalho, botões, etc.).
- **webhook** – modelos de eventos recebidos via webhook (mensagens, status, conversas, etc.).

### exception
- **WhatsappApiException** – exceção de runtime que encapsula `WhatsappApiError`. Utilizada para sinalizar falhas nas chamadas REST.

### utils
- **Formatter** – classe utilitária para aplicar formatação Markdown simples em textos (negrito, itálico, tachado, bloco de código). Há uma versão antiga no pacote `exception.utils` marcada como obsoleta.

## Processo de Comunicação (Service Generator)
A classe `WhatsappApiServiceGenerator` cria instâncias Retrofit configuradas com o `AuthenticationInterceptor`. Também possui métodos utilitários para executar chamadas síncronas (`executeSync`) e downloads (`executeDownloadSync`), convertendo eventuais erros HTTP em `WhatsappApiException`.

## Exemplo de Uso Básico
```java
WhatsappApiFactory factory = WhatsappApiFactory.newInstance("SEU_TOKEN");
WhatsappBusinessCloudApi cloudApi = factory.newBusinessCloudApi();

var message = MessageBuilder.builder()
        .setTo("NUMERO_DESTINO")
        .buildTextMessage(new TextMessage().setBody("Olá!"));

MessageResponse resp = cloudApi.sendMessage("PHONE_NUMBER_ID", message);
```
O README do projeto (arquivo `README.md`) contém diversos exemplos adicionais para envio de texto, mídia, mensagens interativas e uso da API de gerenciamento.

## Build e Dependências
O projeto utiliza Maven. As dependências principais são:
- **Retrofit 2.9**
- **OkHttp 5**
- **Jackson** para JSON
- **JUnit 5** e **Mockito** para testes

Para compilar basta executar:
```bash
mvn clean package
```

## Considerações para Replicação
1. **Modelagem de Dados** – As classes em `domain` são mapeamentos diretos das estruturas da API do WhatsApp. É recomendável manter modelos semelhantes ou criar mapeamentos equivalentes em outra linguagem.
2. **Camada de Serviço** – Utilize um cliente HTTP que permita interceptar chamadas (ex.: para adicionar o token). A lógica de cada método é essencialmente encaminhar requisições REST e tratar respostas/erros.
3. **Factories e Inicialização** – A fábrica centraliza a criação das instâncias e facilita a troca do token. Essa abordagem ajuda na organização do código.
4. **Exceções** – Converta mensagens de erro da API em exceções significativas para facilitar o tratamento na aplicação.
5. **Exemplos e Documentação** – Consulte o README e os arquivos em `docs/` para ver exemplos de uso dos principais recursos (envio de mensagens, verificação de códigos, etc.).

Ao seguir esta visão geral e explorar os códigos de cada pacote, é possível reimplementar a biblioteca em outro projeto ou linguagem, mantendo as mesmas funcionalidades oferecidas pela `whatsapp-business-java-api`.
