# Java Shared Key Authentication

Exemplo de como proteger um serviço REST via **Shared Key Authentication**

## Tecnologias utilizadas

* JAX-RS 2.0 => RESTEasy
* JAX-B
* CDI
* Apache Commons Codec 1.10
* WildFly 8.1.0.Final

## Configurando

* Clone o projeto
* Importe no Eclipse
* Associe o projeto com o WildFly
* Start o WildFly

## Testando

Basta disparar uma requisição HTTP para uma das seguintes URL's da aplicação:
* http://localhost:8080/java-shared-key-authentication/rest/produtos
* http://localhost:8080/java-shared-key-authentication/rest/produtos/{id}


A Requisição deve ser feita utilizando alguma aplicação como: *cURL*, *Advanced REST client*, *SOAPUI*, etc.. 

A Requisição deve ser via método *GET*, e deve incluir dois Header's:

* login: Identificação do usuario disparando a requisição.
* assinatura: Hash gerado a partir da chave privada do usuario e combinada com dados da requisição, sendo estes dados separados por um delimitador pré definido.

### Exemplo

Existem alguns usuários cadastrados e mantidos em memória pela classe **Usuarios**.

Aqui um exemplo de requisição sendo disparada via *cURL*, pelo usuário *fulano*:

```
curl http://localhost:8080/java-shared-key-authentication/rest/produtos -H "login:fulano@fulano.com" -H "assinatura:bedf69e88e3afca0ddf37f2554d1fce3c0b6dd659167d17b7695205ec490dc6630c75cfee8684322c79f49b120aa5317c151c843b7a52cd8732776ae72146777"
```

O Algoritmo de geração da assinatura se encontra na classe **GeradorDeAssinatura**
