# PROGRAM READER
javac system/in_out/reader/ProgramReader.java -d compiled_program/
java -cp compiled_program/ system.in_out.reader.ProgramReader

# FUNCTION OBJECTS
javac system/in_out/reader/FunctionObjects.java -d compiled_program/
java -cp compiled_program/ system.in_out.reader.FunctionObjects

# TESTE PROCESS
javac system/process/TestProcess.java -d compiled_program/
java -cp compiled_program/ system.process.TestProcess