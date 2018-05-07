# sinn-avaliacao-java

## Pré-requisitos

Você vai precisar do Eclipse instalado na sua máquina ou outra IDE de sua preferência:

https://www.eclipse.org/downloads/

Você também vai precisar da JDK do Java 1.8:

http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html

Instale o PostgreSQL como banco de dados a ser usado:

https://www.postgresql.org/download/


Você pode utilizar uma interface de gerenciamento de banco de dados(PgAdmin, por exemplo).
  

## Tecnologias utilizadas

- Java 8
- Maven
- Spring Framework
- JPA, Hibernate
- Spring Data
- PostgreSQL
  

## Deploying

Ajuste as configurações do banco de dados em: /src/main/resources/application.properties

Pegue o .war do projeto e coloque dentro de um servidor de aplicação(tomcat, jetty, wildfly) de sua preferência. Suba o servidor e entre na seguinte url:

http://localhost:8080/avaliacao-entrevista-java/

Se aparecer uma mensagem na tela dizendo "O PROJETO ESTÁ RODANDO!", você já pode iniciar as atividades.


## Exercícios

- Na Etapa 2, as Controllers devem ser REST API. Você pode testar as api's utilizando o Restlet Client do Chrome.

### Etapa 1

 - Elabore a modelagem das tabelas dos seguintes objetos: Empresa, Cargo e Pessoa;
 - A Empresa deve ter os seguintes campos:
    - nome da empresa;
    - cnpj;
    - dono da empresa.
 - O Cargo deve ter o seguinte campo:
    - nome do cargo.
 - A Pessoa deve ter os seguintes campos:
    - nome da pessoa;
    - cpf;
    - cargo;
    - salário.
    
 Importante: 
 - A tabela Cargo deve ter, obrigatoriamente, os seguintes valores:
    - Estagiário;
    - Gerente;
    - Diretor.
 
 ### Etapa 2

 - Crie POJOs para mapear as tabelas criadas anteriormente; 
 - Implemente um serviço para cada um destes objetos que os insira na base;
 - Implemente um serviço para cada um destes objetos que faça uma delete lógico deles;
 - Implemente um serviço para cada um destes objetos que busque e retorne uma lista deles, sem os deletados;
 - Crie as Controllers de acesso aos recursos de cada um destes objetos.
 
 Dica: você pode alterar a estrutura da tabela criada anteriormente se julgar necessário, com base nas tarefas da etapa 2.
 
 ### Etapa 3
 
 Implemente as seguintes regras de negócios para este sistema:
 - Faça um serviço(REST API) que atualize o salários das pessoas, aumentando o salário do: 
    - estagiário em 10%; 
    - gerente em 20%;
    - diretor em 35%.
 E que retorne o novo e o antigo.
 
 ### Extra
 
 Utilize recursos do Java como herança e polimorfismo para otimizar a implementação destes códigos. Se souber, aplique também design patterns onde julgar aplicável.
 
 ## Orientações finais
  
 - Realize as tarefas acima na sua própria máquina;
 - Pegue o script de geração das tabelas e os coloque na pasta "scripts_database" que está neste projeto;
 - Commite todo o código que você desenvolver no repositório do seu projeto.
