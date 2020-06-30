package system;
import system.cpu.*;
import system.in_out.reader.*;
import system.memory.*;
import system.process.*;


/*
 * Steps to run the application: 
 * 
 * 1. Open terminal and make sure you are inside the 'Java' folder
 *      cd Java
 * 
 * 2. Copy paste this in the terminal in order to compile the program:
 *      javac src/system/App.java -d src/compiled_program
 * 
 * 3. Copy paste this in the terminal in order to run the program:
 *      java -cp src/compiled_program system.App
 * 
 * Done! The program is now running.
*/

public class App {

    public static void main (String args[]) {
      // ÁREA DE TESTES UNITÁRIOS DA CLASSE
      System.out.println("🆗 APP COMPILANDO!");

      // Inicializando
      Memory memoria = new Memory();
      ControlUnit controlUnit = new ControlUnit(memoria);
      MemoryManager mm = new MemoryManager(memoria);

      // Criando partições da Memória
      mm.addPartition(0, 0, 39);
      mm.addPartition(1, 40, 79);

      // Salvando o Programa na Partição de Memória
      controlUnit.loadProgram("prog.txt", 0, mm);
      






    }
    
}
