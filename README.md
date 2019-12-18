# prova_sicredi
Prova técninca de automação de testes

## Pré-requisitos
[Java 8+](https://www.oracle.com/technetwork/pt/java/javase/downloads/jre8-downloads-2133155.html)
   
[Maven](https://maven.apache.org/)

[docker](https://www.docker.com/)* 

[docker-compose](https://github.com/docker/compose)*

*necessários para visualizar os Reports

## Utilizando
Para rodar os testes basta utilizar o comando Maven abaixo
```
mvn clean test
```
Para visualizar os reports é necessário utilizar docker-compose com o comando abaixo
```
docker-compose up allure
```
e acessar [localhost:4040](http://localhost:4040/index.html)
