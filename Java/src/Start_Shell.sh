#!/bin/bash

# ┌──────────────────────┐
# ׀ RUNNING SHELL SCRIPT ׀
# └──────────────────────┘

javac system/Shell.java -d compiled_program/
java -cp compiled_program/ system.Shell
