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