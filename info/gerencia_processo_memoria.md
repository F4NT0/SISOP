# Matéria sobre Gerência de Processos

## Processo

* Um processo é Fundamental na Estrutura do Sistema Operacional, onde um processo pode ser:
  * Um programa em Execução
  * Uma instância de um programa em Execução
  * A entidade que pode ser atribuida e executada em um Processador
  * Uma unidade de atividade caracterizada por um único encadeamento sequencial de execução, um estado atual e um conjunto associado de recursos do sistema

## Componentes de um Processo

* Um processo contém 3 componentes:
  * Um programa executável
  * Os Dados Associados necessários ao programa(variáveis, espaço de trabalho, buffers, etc..)
  * O contexto de execução(ou "estado do processo") do programa
    * O contexto de execução é essencial
    * São os Dados Internos pelos quais o S.O é capaz de supervisionar e controlar o processo.
    * Inclui o conteúdo dos vários registros do processo
    * Inclui informações como a prioridade do processo e se o processo está aguardando a conclusão de um determinado evento de E/S

## Como funciona um Gerente de Processo

* De vez de carregar o programa direto na Memória, ele deve ser guardado em uma Estrutura chamado **Process Controll Block**.
* **Process Controll Block** é uma estrutura que guarda o estado da leitura de um Programa, para que possamos ter vários Processos acontecendo rodando em nosso CPU.
* Dentro de um **Process Controll Block(PCB)** deve ser armazenado:
  * Ter espaço para os Registradores(ObjectRegister)
  * O estado dos Registradores da ultima vez que rodou o programa
  * deve possuir um ID, onde cada PCB tem um ID único.
  * Deve ser guardado o baseRegister e o boundRegister (valor incial e final da Partição onde está alocado o Processo).
  * O Estado do Processo, onde possui dois tipos de Estados Possíveis, ou o programa está rodando ou ele está parado.
  * O Registrador Base, que guarda a Posição inicial da Partição do Processo.
  * O Registrador Limite, que guarda a Posição final da Partição do Processo.
* Deve existir uma Pilha de processos, onde os processos são feitos em uma ordem.
* Cada Processo é ativado em um tempo determinado, onde pode ser um número de intruções lidas ou um temporizador que quando acaba o tempo de leitura ele vai salvar os dados, colocar o processo no final da pilha remove o processo atual e chama o próximo processo.
* No final de tudo, chamando um comando especifico deve ser apresentado no Shell os Status de cada Processo.

## Como funciona um Gerente de Memória

* Agora como temos mais de um Processo na CPU, devemos fazer partições de Memória Fixa
* Uma **Partição de Memória** possui um tamanho fixo que depende do Número de Processos que devem ser rodados.
* Como possui um tamanho fixo, se o processo for maior que o tamanho máximo da Partição esse processo não vai ativar.
* Quando Criado um Número de Partições, elas devem ter um Status onde a Partição está livre para ser alocada e um processo acontecer nela.
* Quando precisa iniciar um Processo, ele vai ser salvo na primeira Partição Livre, mas no nosso Projeto agora nós iremos dizer quais Partições o Processo vai ser salvo.
* Quando adicionarmos um processo em uma Partição, a primeira Posição da Partição deve ser salva em uma Variável chamada **baseRegister**(Registrador Base) que nos ajuda a sabe onde nossa Partição inicia.
* A ultima Posição da Partição deve ser salva em **boundRegister**(Registrador Limite) que nos ajuda a saber quando nossa Partição finaliza.
* As posições de cada Partição depende de quantos processos irão rodar na memória(1024 posições), então dividimos as partições pelo numero de processos.
* A ultima Posição de cada Partição funciona da seguinte forma:
  * a Primeira Partição começa na primeira Posição da memória e vai até o resultado da divisão - 1.
  * a Segunda Partição começa na Posição que é o resultado da divisão e a ultima Posição é a soma do resultado da divisão por si mesma e subtraindo 1.
  * As Partições seguintes vão pegando o resultado das somas anteriores como primeira Posição e ultima Posição é a nova soma subtraindo 1.
  * Exemplo: queremos dividir a memória em 4 Partições:
    * **Partição 1:** Primeira Posição é _0_ e vai até a Posição _255_ (1024/4 = 256 -1 = 255)
    * **Partição 2:** Primeira Posição é _256_ e vai até a Posição _511_ (256 + 256 = 512 = -1 = 511)
    * **Partição 3:** Primeira Posição é _512_ e vai até a Posição _767_ (512 + 256 = 768 - 1 = 767)
    * **Partição 4:** Primeira Posição é _768_ e vai até a Posição _1023_ (768 + 256 = 1024 - 1 = 1023)
  * Quando for lido um valor de Posição do programa, deve se verificar qual a primeira Posição da Partição e com a ultima da seguinte forma:
    * Pegamos o valor de Posição entrado e somamos com a primeira Posição da Partição, dessa forma quando formos colocar um dado na memória ela seja colocada na Partição desejada.
    * Depois que fizer a soma, veja se o valor está dentro do intervalo da Partição, verificando se o valor da soma não é maior que o ultimo valor da Partição.
      * Exemplo: 
        * Partição n : Posição inicial = 256/ Posição final = 511
        * Programa deseja salvar valor 15 na Posição 50 = 256 + 50 = 306 (Posição 50 nessa Partição)
        * 306 > 511? Não, portanto o valor 15 pode ser armazenado na Posição 306 dessa Partição.
  * Tem que se criar um Sistema que proteja cada partição, um processo não pode invadir outra partição além da que ele está trabalhando.
  * Na CPU devem possuir o Registrador Base e o Registrador Limite, assim como as Funções de Alocar e Desalocar os Processos dentro das Partições.
  * Somente é retirado um Processo de uma Partição quando o Processo tiver sido encerrado(chegado no STOP)  