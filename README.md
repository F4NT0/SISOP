# Sistema Operacional S.O.V.A.C.O

**S.O.V.A.C.O** = **S**istema **O**peracional **V**ersionado **A**o **C**ompartilhamento **O**rganizacional

* Informações para Desenvolvimento clique [AQUI](https://github.com/F4NT0/SISOP/wiki)

* Este Repositório possui o Sistema Operacional criado na Cadeira de `Sistemas Operacionais`.

### Parte 1 do Projeto

**Criar uma Máquina Virtual Simples**

* Devemos implementar uma Máquina Virtual de 32 bits.
* Temos uma Memória e uma CPU, onde:
    * **Memória**
        * Cada posição de Memória tem 4 Bytes
        * A memória possui 1024 Posições
    
    * **CPU - Central Process Unit (Unidade Central de Processamento)**
        * O processador possui um contador de Instruções (PC) que anda pelas linhas do código
        * Oito Registradores, contados de 0 á 7
        * O CPU possui as Seguintes [Funções](./info/funcoes.md)
    
    * **EXPLICAÇÃO DE COMO A VM DEVE SER MONTADA**
        * Toda a info passada pelo professor está [Aqui](./info/resolucao.md)

### Parte 2 do Projeto

**Criar o Gerente de Memória**

* Agora nosso programa pode ter mais que um programa sendo lido, por isso temos que ter um Gerente de Memória que interrompe a leitura de um programa para se poder ler outro.
