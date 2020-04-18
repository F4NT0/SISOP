# Sistema Operacional Multiprogramado

* Agora que a parte 1 está funcionando, podemos construir um sistema capaz de executar vários programas simultâneamente.
* Para isso precisamos de um Gerente de Memória, capaz de alocar e deslocar memória para programas dinâmicamente
* Também necessitaremos a representação de vários processos e seu escalonamento, com um Gerênte de Processos.

## Gerente de Memória - Fase 1

* Vamos dividir a memória em Partições Fixas, o esquema mais simples para suportar multiprogramação.
* Projete as estruturas necessárias para gerenciar a memória segundo este esquema.

## Gerente de Processos - Fase 2

* Para escalonar processos vamos implementar um sistema time-slice. Significa que cada processo escalonado usa a CPU por um tempo fixo. Os processos formam uma fila circular e usam a CPU conforme a fila.

## Observações

* Nesta Fase 1 suponha que os processos não fazem I/O.
* A "Fatia de Tempo" pode ser implementada neste momento como um número de instruções que um processo executa e depois é interrompido pra que outros processos executem
* O carregador deverá ser reescrito para carregar programas no inicio das partições fixas.
* Agora, endereços lógicos dos programas devem ser compatibilizados com os endereços físicos da memória.