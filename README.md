# Aplicação de Arquitetura Hexagonal
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.5-brightgreen)
![Gradle](https://img.shields.io/badge/Gradle-7.5.1-green)
![MongoDB](https://img.shields.io/badge/MongoDB-4.4.10-green)
![Docker](https://img.shields.io/badge/Docker-20.10.8-blue)
![Kafka](https://img.shields.io/badge/Kafka-2.8.0-blue)

Este projeto é uma aplicação Java que segue o padrão de Arquitetura Hexagonal. Utiliza Spring Boot e Gradle para construção e gerenciamento de dependências.

## Índice

- [Introdução](#introdução)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Executando a Aplicação](#executando-a-aplicação)
- [Estrutura do Projeto](#estrutura-do-projeto)

## Introdução

Estas instruções ajudarão você a configurar e executar o projeto em sua máquina local para desenvolvimento e testes.

## Pré-requisitos

- Java 17
- Gradle
- MongoDB (para operações de banco de dados)
- Docker (para conteinerização)
- Kafka (para mensageria)

## Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/ThiagoMSousa/hexagonal-architecture.git
    cd hexagonal-architecture
    ```

2. Construa o projeto:
    ```sh
    ./gradlew build
    ```

## Executando a Aplicação

Para executar a aplicação, use o seguinte comando:
```sh
./gradlew bootRun
```

## Estrutura do Projeto

O projeto segue o padrão de Arquitetura Hexagonal e está organizado da seguinte forma:


* src/main/java/br/com/dev/thiagomds/hexagonal

  * adapters: Contém os adaptadores de entrada e saída.
    * in: Adaptadores de entrada (ex.: controllers).
    * out: Adaptadores de saída (ex.: repositories, clients).
    
  * application: Contém a lógica de negócio principal.
    * core: Lógica de negócio principal (ex.: use cases).
    * ports: Portas de entrada e saída.
    
  * config: Classes de configuração.
  
* src/test/java/br/com/dev/thiagomds/hexagonal

* arquitetura: Contém os testes de arquitetura usando ArchUnit.
