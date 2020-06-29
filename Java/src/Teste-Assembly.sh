# MEMORY
javac system/memory/Memory.java -d compiled_program/
java -cp compiled_program/ system.memory.Memory

# CONTROL UNIT 
javac system/cpu/ControlUnit.java -d compiled_program/
java -cp compiled_program/ system.cpu.ControlUnit

# ASSEMBLY
javac system/cpu/Assembly.java -d compiled_program/
java -cp compiled_program/ system.cpu.Assembly

javac system/tests/TestAssembly.java -d compiled_program/
java -cp compiled_program/ system.tests.TestAssembly