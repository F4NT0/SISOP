# PROGRAM READER
javac system/in_out/reader/ProgramReader.java -d compiled_program/
java -cp compiled_program/ system.in_out.reader.ProgramReader

# PROCESS
javac system/process/Process.java -d compiled_program/
java -cp compiled_program/ system.process.Process

# PROCESS MANAGER
javac system/process/ProcessManager.java -d compiled_program/
java -cp compiled_program/ system.process.ProcessManager

# TESTE PROCESS MANAGER
javac system/tests/TestProcessManager.java -d compiled_program/
java -cp compiled_program/ system.tests.TestProcessManager