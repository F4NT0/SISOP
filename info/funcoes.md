# Lista de Funções do CPU

**Glossário**

* Nome da Função = É o nome que damos á Função que queremos.
* Descrição = O que a Função faz.
* Sintaxe = Como a Função vai aparecer no arquivo
* Operação = O que a Função vai fazer
    * `<-` = significa que o operador a direita é enviado ao operador da esquerda
        * Ex: `PC <- k` = o valor de _k_ vai para o Registrador _PC_
    * `PC` = _Program Counter_ anda pelas linhas do programa, onde ele vai andando pelo programa desde a linha 0 até a linha _n_ que para quando chega no _STOP_
    * `k` = é um valor absoluto, sendo um inteiro
    * `[A]` = pega a posição _A_ de um Vetor
    * `Rd` = Registrador Destino, onde vai ser enviado o valor
    * `Rs` = Registrador Fonte(Source), é um Registrador que pegamos o valor dele e enviamos para outro lugar
    * `Rc` = Registrador de Comparação, é um Registrador que o iremos comparar com um valor  

**Lista de Funções**


### Operações de JUMP
Nome da Função|Descrição|Sintaxe|Operação
|---|---|---|---|
JMP|Envia o PC para uma posição específica|JMP k|PC <- k
JMPI|Envia o PC para uma posição armazenada em um Registrador|JMPI Rs|PC <- Rs
JMPIG|Verifica se um valor de um Registrador é maior que Zero, se for, ele vai pegar o valor de outro Registrador e enviar o PC para o valor, senão ele somente vai para a proxima linha do programa| JMPIG Rs,Rc| if Rs > 0 <br> then <br> PC <- Rs <br> Else <br> PC <- PC+1
JMPIL|Verifica se um valor de um Registrador é menor que Zero, se for, ele vai pegar o valor de outro Registrador e enviar o PC para o valor, senão ele somente vai para a proxima linha do programa| JMPIL Rs,Rc| if Rs < 0 <br> then <br> PC -< Rs <br> Else <br> PC <- PC+1
JMPIE|Verifica se um valor de um Registrador é igual que Zero, se for, ele vai pegar o valor de outro Registrador e enviar o PC para o valor, senão ele somente vai para a proxima linha do programa| JMPIE Rs,Rc| if Rs = 0 <br> then <br> PC <- Rs <br> Else <br> PC <- PC+1

### Operações com valores Diretos
Nome da Função|Descrição|Sintaxe|Operação
|---|---|---|---|
ADDI| Imediatamente soma um valor dentro de um Registrador com um valor entrado|ADDI Rd,k|Rd <- <br> Rd + k
SUBI| Imediatamente subtrai um valor dentro de um Registrador com um valor entrado|SUBI Rd,k|Rd <- <br> Rd - k
ANDI| Imediatamente faz uma Operação de AND com um valor entrado, armazenando o resultado booleano(0 ou 1) no Registrador|ANDI Rd,k| Rd <- <br> Rd AND k
ORI | Imediatamente faz uma Operação de OR com um valor entrado, armazenando o Resultado Booleano(0 ou 1) no Registrador| ORI Rd,k|Rd <- <br> Rd OR k
LDI | Imediatamente Carrega um valor entrado para dentro de um Registrador|LDI Rd,k|Rd <- k
LDD | Imediatamente Carregamos um valor vindo de uma Posição de Memória Específica| LDD Rd,[A]|Rd <- [A]
STD | Imediatamente Colocamos um valor de um Registrador dentro de uma Posição da Memória|STD [A],Rs|[A] <- Rs

### Operações entre dois Registradores 
Nome da Função|Descrição|Sintaxe|Operação
|---|---|---|---|
ADD | Somamos o valor armazenado entre dois Registradores no primeiro Registrador inserido|ADD Rd,Rs|Rd <- <br> Rd + Rs
SUB | Subtraimos o valor armazenado entre dois Registradores no primeiro Registrador inserido|SUB Rd,Rs| Rd <- <br> Rd - Rs
MULT| Multiplica o valor armazenado entre dois Registradores no primeiro Registrador inserido|MULT Rd,Rs| Rd <- <br> Rd * Rs
AND | Faz a Operação Lógica AND|AND Rd,Rs|Rd <- <br> Rd AND Rs
OR  | Faz a Operação Lógica OR|OR Rd,Rs| Rd <- <br> Rd OR Rs
LDX | Pega uma Posição do vetor por um valor de um Registrador e salva o valor em outro Registrador|LDX Rd,[Rs]|Rd <- [Rs]
STX | Adiciona o valor do Registrador em uma Posição da Memória|STX [Rd],Rs|[Rd] <- Rs

### Operações em um Registrador
Nome da Função|Descrição|Sintaxe|Operação
|---|---|---|---|
NOT | Operação Lógica NOT | NOT Rd | Rd <- NOT Rd
SHL | Movimenta o valor de um Registrador para a Esquerda| SHL Rd | Rd(n+1) <- Rd(n), Rd(0) <- 0