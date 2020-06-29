#-------------------------------- 
# ARQUIVO PARA TESTAR O PROGRAMA
#--------------------------------

# App
javac system/App.java -d compiled_program/
java -cp compiled_program/ system.App

# CPU
javac system/cpu/Cpu.java -d compiled_program/
java -cp compiled_program/ system.cpu.Cpu

# PROCESS
javac system/process/Process.java -d compiled_program/
java -cp compiled_program/ system.process.Process

# PROCESS MANAGER
javac system/process/ProcessManager.java -d compiled_program/
java -cp compiled_program/ system.process.ProcessManager

# PROCESS CONTROL BLOCK
javac system/process/ProcessControlBlock.java -d compiled_program/
java -cp compiled_program/ system.process.ProcessControlBlock

# PROGRAM STATE
javac system/process/ProgramState.java -d compiled_program/
java -cp compiled_program/ system.process.ProgramState

# SCHEDULER
javac system/process/Scheduler.java -d compiled_program/
java -cp compiled_program/ system.process.Scheduler

# MEMORY ACCESS
javac system/memory/MemoryAccess.java -d compiled_program/
java -cp compiled_program/ system.memory.MemoryAccess

# MEMORY
javac system/memory/Memory.java -d compiled_program/
java -cp compiled_program/ system.memory.Memory

# MEMORY MANAGER
javac system/memory/MemoryManager.java -d compiled_program/
java -cp compiled_program/ system.memory.MemoryManager

# PROGRAM READER
javac system/in_out/reader/ProgramReader.java -d compiled_program/
java -cp compiled_program/ system.in_out.reader.ProgramReader

# FUNCTION OBJECTS
javac system/in_out/reader/FunctionObjects.java -d compiled_program/
java -cp compiled_program/ system.in_out.reader.FunctionObjects

# CONTROL UNIT 
javac system/cpu/ControlUnit.java -d compiled_program/
java -cp compiled_program/ system.cpu.ControlUnit

# ASSEMBLY
javac system/cpu/Assembly.java -d compiled_program/
java -cp compiled_program/ system.cpu.Assembly


# Finalização
echo "✅ TODOS PROGRAMAS COMPILADOS!"
