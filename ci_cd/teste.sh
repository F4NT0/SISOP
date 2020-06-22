#!/bin/bash
cd ..
echo "Acessando Java/src/"
cd Java/src/
javac system/App.java -d compiled_program/
java -cp compiled_program/ system.App



