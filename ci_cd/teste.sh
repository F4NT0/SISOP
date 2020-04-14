#!/bin/bash
$ docker build -f Dockerfile -t demo/oracle-java:8 .
cd ..
cd Java/src/
docker run --rm -v $PWD:/app -w /app demo/oracle-java:8 javac *.java
docker run --rm -v $PWD:/app -w /app demo/oracle-java:8 java Teste_Functions
