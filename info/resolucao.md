# Como fazer a Maquina Virtual definido em Aula

1) Estrutura de Armazenamento
    * Turma definiu que cada palavra da memória é um objeto com os atributos necessários para codificar
    * Os Atributos são:
        * **OPCODE** (anda pelas linhas de código)
        * Registrador1 que pode ser de 1 á 8
        * Registrador2 que pode ser de 1 á 8
        * Parametro **k** ou **A** (k é um valor e A é pos. do vetor)

2) O Programa
    * O programa pode ser escrito em .txt
    * A VM irá ler esse arquivo e ler cada linha e transformar em um Objeto.

3) O que será retirado da VM
    * Não iremos manipular a Nível de Bit, entãos as seguintes funções não serão mais necessárias:
        * AND
        * OR
        * NOT
        * SHIFT

4) A Máquina Virtual é um grande Loop
    * Em cada interação ele deve:
        * Carrega-se a instrução apontada por OPCODE
        * Executa a instrução dos dados do objeto chamado
        * Modifica os registradores e posições de memória necessários
        * Quando encontra o STOP ele para
    * A operação de STORE em uma posição de memória adota a definição que armazena o valor em um "Parâmetro" do Objeto "Palavra" que está naquela posição de memória.
    * Adota-se um OPCODE novo, chamado de Dado, que indica que naquela posição tem um dado e não uma instrução.

5) Um carregador, quando invocado tendo como parâmetro um programa, lê o programa sequencialmente e carrega a partir da posição 0 da memória.

6) Um Shell, que é um programa que espera um entrada do usuário(que nesse caso é o nome do programa)
    * Invoca o carregador, passando o nome do programa como parâmetro e libera a máquina virtual para executar a partir da posição 0.

