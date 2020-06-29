# MEMORY
javac system/memory/Memory.java -d compiled_program/
java -cp compiled_program/ system.memory.Memory

# CONTROL UNIT
javac system/cpu/ControlUnit.java -d compiled_program/
java -cp compiled_program/ system.cpu.ControlUnit

# TESTE DO CONTROL UNIT
javac system/cpu/TestControlUnit.java -d compiled_program/
java -cp compiled_program/ system.cpu.TestControlUnit