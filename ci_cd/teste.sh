#!/bin/bash
cd ..
echo "Acessando Java/src/"
cd Java/src/
mkdir compiled_program/
javac system/App.java -d compiled_program/
java -cp compiled_program/ system.App



