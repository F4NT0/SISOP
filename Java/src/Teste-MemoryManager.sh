# MEMORY
javac system/memory/Memory.java -d compiled_program/
java -cp compiled_program/ system.memory.Memory

# MEMORY MANAGER
javac system/memory/MemoryManager.java -d compiled_program/
java -cp compiled_program/ system.memory.MemoryManager

# TESTE MEMORY MANAGER
javac system/tests/TestMemoryManager.java -d compiled_program/
java -cp compiled_program/ system.tests.TestMemoryManager