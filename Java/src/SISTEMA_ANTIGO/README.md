# Arquivos dentro do Diretório src

## Arquivos do Sistema

Nome do Arquivo|Para que serve
|---|---|
**Shell.java**| É o terminal do nosso S.O, onde possui os comandos que irão gerenciar tudo
**Reader.java** | É onde se encontra o Leitor dos Programas criados em .txt
**Funcao.java** | São as Funções para gerenciar os Objetos lidos dos arquivos .txt
**ObjectCreator.java**| Transforma cada linha lida do Arquivo em Objetos
**Memory.java**| Onde se encontra todas as Funções de Gerênciamento da Memória
**Cpu.java**| Onde se encontram os Registradores e faz a interação entre as Funções Lidas com as Funções nos Objetos criados
**ObjectRegister.java**| Os objetos salvos na memória são a String do Registrador e o seu valor, podendo ser Integer ou Char
**SystemFunctions.java**| Todas as Verificações das Funções do nosso programa e a implementação delas se encontra nessa Classe  

## Arquivos de Testes

Nome do Arquivo|Para que serve
|---|---|
**Teste_ObjectCreator.java**| Para testar as Funções que leem o arquivo do programa e salva dentro de um ArrayList com os dados separados.
**Teste_Memory.java**| Para testar as Funções que mexem na memória do nosso Sistema Operacional
**Teste_CPU.java**| Para testar as Funções que interagem com a memória para fazer as Funções que serão ativadas sendo lidas das Funções
**Teste_Functions.java**| Para testar as Funções em Assembly e como elas se interagem com as Funções do CPU