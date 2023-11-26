# ifg-fan-cinema-api

Backend para rede social de listagem e avaliação de filmes.

O projeto usa o framework Quarkus (https://quarkus.io/) e consome a API OMDb (http://www.omdbapi.com), banco de dados MySQL com arquitetura em Docker.

### Aplicação

Para rodar, são necessários as etapas básicas
1. Clone o projeto: ```git clone https://github.com/igorfgama/ifg-movie-fan-api.git```

2.
```
  API_KEY= -- */ Para obter a sua, crie seu login na API OMDb
  BD_PASSWORD= -- */ senha do banco de dados MySQL em arquitetura Docker
  BD_USERNAME=root
  URL_OMDB_API=http://www.omdbapi.com
```
3. Execute a classe Main() (br.com.ifg.main.Main)

### Funcionalidade

Esse projeto provê listagens das mais diversas para busca de filmes na API. É possível criar sua conta. Cadastrar filmes já assistidos. Criar lista de filmes para assistir. Além de poder dar notas.

A aplicação é executada através do aplicativo construído em Swift/Xcode para dispositivos iOS (https://github.com/igorfgama/movie-fan-app.git).

### Guias

**Related Guides**

- Security WebAuthn ([guide](https://quarkus.io/guides/security-webauthn)): Secure your applications with WebAuthn
- SmallRye JWT ([guide](https://quarkus.io/guides/security-jwt)): Secure your applications with JSON Web Token
- Security JPA ([guide](https://quarkus.io/guides/security-getting-started)): Secure your applications with
  username/password stored in a database via Jakarta Persistence
- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC
- SmallRye JWT Build ([guide](https://quarkus.io/guides/security-jwt-build)): Create JSON Web Token with SmallRye JWT
  Build API


**RSTEasy Reactive**

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

