# sinn-avaliacao-java

## Pré-requisitos

Você vai precisar do Eclipse instalado na sua máquina:

https://www.eclipse.org/downloads/

Você também vai precisar da JDK do Java 1.8:

http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html

  

## Instalando dependências

Clique com o boto direito no projeto, vá em "Run As" e clique em "Maven clean". Em seguida faça quase o mesmo processo, mas desta vez clique em "Maven install".

  

## Deploying

Pegue o .war do projeto e coloque dentro de um container de sua preferência. Suba o servidor e entre na seguinte url:

http://localhost:8080/avaliacao-entrevista-java/

Se aparecer uma mensagem na tela dizendo "O PROJETO ESTÁ RODANDO!", você já pode iniciar as atividades.


## Exercícios

### Etapa 1

 - Crie POJOs para mapear as tabelas "empresas", "cargos" e "pessoas";
 - Implemente um serviço para buscar uma lista destes objetos;
 - Implemente um serviço para inserir cada um desses objetos;
 - Crie Controllers
 - Não exibir o time caso ele não possua posição
 - Filtrar tabela de Clubes pelo campo nome do time e posição
 - Exibir um contador na tela inicial do tempo restante para o fechamento da rodada
 - Se a rodada estiver acabada, não deixar entrar na tela de Clubes

 - **EXTRA**
 - Criar componente de Próxima Rodada exibindo o escudo + abreviacao do Time Mandante X escudo + abreviacao do Time Visitante
