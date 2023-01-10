<h1 align="center">
  <p align="center">G1Bet</p>
</h1>

![Badge versão](https://img.shields.io/badge/version-v1.0-green)
![Badge status](https://img.shields.io/badge/status-em%20desenvolvimento-green)
![Badge líguagem](https://img.shields.io/badge/l%C3%ADnguagem-Java-green)
![Badge framework](https://img.shields.io/badge/framework-Spring-green)
![Badge IDE](https://img.shields.io/badge/IDE-Intellij-green)

## **Sobre** 

O G1Bet é uma API desenvolvida para o projeto integrador da Digital House em parceria com a Empiricus.

## **Funcionalidades**

* Cadastrar usuário
* Excluir usuário
* Atualizar usuário
* Autenticar usuário
* Realizar aposta
* Exibir histórico de apostas

## **Documentação**


Conheça  nossa documentação: 

* [**G1Bet-Doc**](https://pi-dh-grupo01.github.io/G1Bet-Doc/)
* [**Swagger**](http://localhost:8080/swagger-ui/index.html)

Para acessar a documentação no Swagger é nescessário seguir os seguintes passos:

1. Rodar a aplicação.
2. Cadastrar um usuário na rota: localhost:8080/usuarios usando como método HTTP um post, no Postman ou outra ferramenta similar.
~~~json

{
  "nome": "string",
  "cpf": 0,
  "dataDeNascimento": "11/02/2022",
  "email": "string",
  "senha": "string",
  "chavePix": "string",
  "saldoUsuario": 0
}

~~~
3. Após isso é só logar na documentação com o email e senha criada.

## **Desenvolvedores**

| [<img src="https://avatars.githubusercontent.com/u/107211940?s=421&v=4" width=115><br><sub>Carla</sub>](https://github.com/Carla-Vitoria) | [<img src="https://avatars.githubusercontent.com/u/61991357?v=4" width=115><br><sub>Gabriel</sub>](https://github.com/GabrielMR360) | [<img src="https://avatars.githubusercontent.com/u/104176853?v=4" width=115><br><sub>Amanda</sub>](https://github.com/amandailg) | [<img src="https://avatars.githubusercontent.com/u/95377180?v=4" width=115><br><sub>Júlio</sub>](https://github.com/iamjuliobatista) |
| :---------------------------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------------------: | :------------------------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------------------------------: |
