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
- JUnit 4
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
- Escreva testes de unidade ( unit tests ), utilizando JUnit 4.

### Etapa 1

 - Elabore a modelagem das tabelas dos seguintes objetos: Empresa, Cargo, Funcionário, Adiantamento e Parcela;
 - A Empresa deve ter os seguintes campos:
    - Nome;
    - CNPJ;
    - Dono da empresa.
 - O Cargo deve ter o seguinte campo:
    - Dome do cargo.
 - O Funcionário deve ter os seguintes campos:
    - Nome;
    - CPF;
    - Cargo;
    - Salário.
 - Adiantamento deve possuir os seguintes campos:
    - Funcionário
    - Valor
    - Data Adiantamento
    - Data Devolução Total
    - Parcelado
    - Numero de Parcelas
    - Quitado
    - Valor a ser devolvido
 - Parcela deve ter os seguintes campos:
    - Adiantamento
    - Valor Parcela
    - Data Pagamento
    - Pago
    
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
 
 ### Etapa 4

 Implemente as seguintes regras e funcionalidades:
 - Possibilidade de um Funcionário solicitar um adiantamento, as seguintes regras deverão ser aplicadas:
    - Possibilidade de Parcelar um Adiantamento
    - Em caso de valores inferiores a 500,00 deverá ser aplicada uma taxa de juros de 15% a.m. para pagamentos a vista, e 20% a.m. para pagamentos parcelados.
    - Em caso de valores superiores a 500,00 deverá ser aplicada uma taxa de juros de 13% a.m. para pagamentos a vista, e 18% a.m. para pagamentos parcelados.
    - Em caso de adiantamento parcelado, gerar as parcelas com base na taxa de juros acima.
    - Calcular quanto será devolvido para a empresa.
    - Possibilitar a devolução do adiantamento para a empresa em menos de 1 mês, apenas para devoluções do valor total ( calcular o juros que serão pagos, conforme a quantidade de dias utilizados. )

 ### Extra
 
 Utilize recursos do Java como herança e polimorfismo para otimizar a implementação destes códigos. Se souber, aplique também design patterns onde julgar aplicável.
 
 ## Orientações finais
  
 - Realize as tarefas acima na sua própria máquina;
 - Pegue o script de geração das tabelas e os coloque na pasta "scripts_database" que está neste projeto;
 - Commite todo o código que você desenvolver no repositório do seu projeto.
