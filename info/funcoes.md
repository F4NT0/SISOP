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

Nome da Função|Descrição|Sintaxe|Operação
|---|---|---|---|
JMP|Envia o PC para uma posição específica|JMP k|PC <- k
JMPI|Envia o PC para uma posição armazenada em um Registrador|JMPI Rs|PC <- Rs
JMPIG|Verifica se um valor de um Registrador é maior que Zero, se for, ele vai pegar o valor de outro Registrador e enviar o PC para a o valor, senão ele somente vai para a proxima linha do programa| JMPIG Rs,Rc| if Rs > 0 <br> then <br> PC <- Rs Else <br> PC <- PC+1
