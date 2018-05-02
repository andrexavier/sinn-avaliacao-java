# sinn-avaliacao-java

## Pré-requisitos

Você vai precisar do Eclipse instalado na sua máquina:

https://www.eclipse.org/downloads/

Você também vai precisar da JDK do Java 1.8:

http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html

Instale o PostgreSQL como banco de dados a ser usado:

https://www.postgresql.org/download/


Você pode utilizar tanto uma interface de gerenciamento (PgAdmin, por exemplo) como o próprio terminal para realizar as operaçes na base.

  

## Instalando dependências

Clique com o boto direito no projeto, vá em "Run As" e clique em "Maven clean". Em seguida faça quase o mesmo processo, mas desta vez clique em "Maven install".

  

## Deploying

Pegue o .war do projeto e coloque dentro de um container de sua preferência. Suba o servidor e entre na seguinte url:

http://localhost:8080/avaliacao-entrevista-java/

Se aparecer uma mensagem na tela dizendo "O PROJETO ESTÁ RODANDO!", você já pode iniciar as atividades.


## Exercícios

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
 - Importante: a tabela Cargo deve ter, obrigatóriamente, os seguintes valores:
    - Estagiário;
    - Gerente;
    - Diretor.
 
 ### Etapa 2

 - Crie POJOs para mapear as tabelas criadas anteriormente;
 - Implemente um serviço para cada um destes objetos que busque e retorne uma lista deles;
 - Implemente um serviço para cada um destes objetos que os insira na base;
 - Implemente um serviço para cada um destes objetos que faça uma deleção lógica deles;
 - Crie as Controllers de acesso aos recursos de cada um destes objetos.
 
 Dica: você pode alterar a estrutura da tabela criada anteriormente se julgar necessário, com base nas tarefas da etapa 2.
 
 ### Etapa 3
 
 - Implemente as seguintes regras de negócios para este sistema:
    - Faça um serviço que atualize o salários das pessoas, multiplicando

 - **EXTRA**
 - Criar componente de Próxima Rodada exibindo o escudo + abreviacao do Time Mandante X escudo + abreviacao do Time Visitante
 
 Realize as tarefas acima na sua própria máquina. Pegue o script de geração das tabelas e os coloque na pasta "scripts_database" que está neste projeto.
