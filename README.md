# sinn-avaliacao-java

## Pré-requisitos

Você vai precisar do Eclipse instalado na sua máquina:
https://www.eclipse.org/downloads/

Você também vai precisar da JDK do Java 1.8
http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html

  

## Instalando dependências

Clique com o boto direito no projeto, vá em "Run As" e clique em "Maven clean". Em seguida faça o mesmo processo, mas desta vez clique em "Maven install".

  

## Deploying

Pegue o .war do projeto e coloque dentro de um container da sua preferência. Suba o servidor e entre na seguinte url:
http://localhost:8080/avaliacao-entrevista-java/

Se aparecer uma mensagem na tela dizendo "O PROJETO ESTÁ RODANDO!", você já pode iniciar as atividades


## Atividades

 - Criar uma tabela de clubes no componente Clubes
 - Exibir o escudo, nome, e posição dos times
 - Ordenação padrão pela posição
 - Não exibir o time caso ele não possua posição
 - Filtrar tabela de Clubes pelo campo nome do time e posição
 - Exibir um contador na tela inicial do tempo restante para o fechamento da rodada
 - Se a rodada estiver acabada, não deixar entrar na tela de Clubes

 - **EXTRA**
 - Criar componente de Próxima Rodada exibindo o escudo + abreviacao do Time Mandante X escudo + abreviacao do Time Visitante

## APIs Necessárias

 - Para exibição dos clubes: https://api.cartolafc.globo.com/clubes
 -  Para exibição da próxima rodada: https://api.cartolafc.globo.com/partidas
