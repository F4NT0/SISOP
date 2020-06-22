#!/bin/bash
cd ..
echo "Acessando Java/src/"
cd Java/src/
mkdir compiled_program/

# TESTES DEFINIDOS INTERNOS
echo "${tput setaf 2}"
chmod +x TESTE.sh && ./TESTE.sh
echo "${tput sgr0}"

