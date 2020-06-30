JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
CI_CD.java\
Cpu.java\
Funcao.java\
Memory.java\
ObjectRegister.java\
ObjectCreator.java\
Reader.java\
Shell.java\
Teste_CPU.java\
Teste_Functions.java\
Teste_Memory.java\
Teste_ObjectCreator.java\
Teste_makefile.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class