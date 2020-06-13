#-------------------------------- 
# ARQUIVO PARA TESTAR O PROGRAMA
#--------------------------------

# App
javac system/App.java -d compiled_program/
java -cp compiled_program/ system.App

# CPU
javac system/cpu/Cpu.java -d compiled_program/
java -cp compiled_program/ system.cpu.Cpu

# PROCESS MANAGER
javac system/cpu/ProcessManager.java -d compiled_program/
java -cp compiled_program/ system.cpu.ProcessManager

# MEMORY ACCESS
javac system/memory/MemoryAccess.java -d compiled_program/
java -cp compiled_program/ system.memory.MemoryAccess

# MEMORY
javac system/memory/Memory.java -d compiled_program/
java -cp compiled_program/ system.memory.Memory

# MEMORY MANAGER
javac system/memory/MemoryManager.java -d compiled_program/
java -cp compiled_program/ system.memory.MemoryManager
