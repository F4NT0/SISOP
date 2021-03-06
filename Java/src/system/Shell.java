package system;

/**********************************************
* SHELL DE INTERAÇÃO DO USUÁRIO COM O PROGRAMA
**********************************************/

// Info das Telas
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;

// Teste
import java.lang.ProcessBuilder;
import java.lang.Process;
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.InterruptedException;

// Lendo arquivo simples
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shell implements KeyListener {

/****************************************************
 *     VARIÁVEIS GLOBAIS PARA UTILIZAR NAS FUNÇÕES
 ***************************************************/

    private JTextArea output;
    private JTextField input;
    private JFrame f;
    private List<String> allFiles = new ArrayList<String>();
    // Cpu cpu = new Cpu();

/***************************************
 *    TELA DO TERMINAL COM JAVA SWING
 **************************************/

    public void screen(){

        // Área de Texto
        output = new JTextArea();
        //output.setSize(930,430);
        output.setBounds(0,0,930,400);//(posicaoX,posicaoY,largura,altura)
        output.setBackground(Color.black);
        output.setForeground(Color.green);
        output.setText("M4TRIX > ");
        output.setFocusable(false);
        output.setLineWrap(true);
        output.setEditable(false);
        output.setFont(new Font("Courier", Font.PLAIN, 16));
        
        // Área de Entrada de texto
        input = new JTextField();
        input.setBounds(0, 406, 930, 40);
        input.setBackground(Color.black);
        input.setForeground(Color.green);
        input.setFocusable(true);
        input.addKeyListener(this);
        input.setFocusTraversalKeysEnabled(false);
        input.setFont(new Font("Courier", Font.PLAIN, 16));

        //Lendo o arquivo com nome de programas
        try{
            File filename = new File("programas/programs.txt");
            Scanner file = new Scanner(filename);
            while(file.hasNextLine()){
                allFiles.add(file.next());
            }
            file.close();
        }catch(FileNotFoundException e){
            output.setText("> Programa não encontrado");
        }

        f=new JFrame();
        f.setSize(930,496);
        f.getContentPane().setBackground(Color.gray);
        f.add(output);
        f.add(input);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

/****************************************************
 *    MÉTODOS IMPORTADOS DO KEYLISTENER PARA TECLADO
 ****************************************************/

    // Se clicar na tecla
    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            final String saida = input.getText();
            commands(saida);
            input.setText("");
        }
    }

    // Outros não foram utilizados
    public void keyReleased(final KeyEvent e) {
    }

    public void keyTyped(final KeyEvent e) {
    }

    /********************************************
     * MÉTODO DE CONTROLE DE COMANDOS ENTRADOS
     *******************************************/

    public void commands(String text){
        if(text.equals("exit")) {
            f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
        }
        if(text.equals("ls")) {
            output.setText(""); // Para limpar o terminal
            for(int i = 0 ; i < allFiles.size() ; i++){
                output.append("M4TRIX > Arquivo: " + allFiles.get(i) + "\n");
                output.append("Numero de Arquivos: " + allFiles.size() + "\n");
            }
            input.setText("");
            
        }
        if(text.equals("clear")){
            output.setText("M4TRIX > ");
        }
        if(text.substring(0,4).equals("take")){
            String nomes[] = text.split(" ");
            String arquivo = nomes[1];
            if(allFiles.contains(arquivo) == false){
                output.append("M4TRIX > Arquivo Não Encontrado! \n");
                input.setText("");
            }
            else{
                output.setText("");
                output.append("Lendo arquivo " + arquivo + ".... \n");
                output.append("");
               //cpu.loadProgram(arquivo);
               //cpu.runningProgram(cpu.getProgramSize());
               //String finalValues = cpu.finalValues();
               //output.append(finalValues);
               //cpu.testMemory();
                input.setText("");
            }

        }
			if(text.equals("teste")){
                System.out.println("\nCarregando...\n");
           	    ProcessBuilder processOne = new ProcessBuilder();
                    processOne.command("./TESTE.sh");
                    try{
                            Process process1 = processOne.start();				
                            //StringBuilder saida = new StringBuilder();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(process1.getInputStream()));
                            String line;
                            while((line = reader.readLine()) != null){
                                //output.append(line + "\n");
                                System.out.println(line + "\n");
                            }
                            int exitPro1 = process1.waitFor();
                            if(exitPro1 == 0){
                                output.append("\n Processo Finalizado!");
                                output.append("\n Todos os Arquivos Compilados. Verifique seu Terminal!");
                                    
                            }

                    }catch (IOException e){
                            e.printStackTrace();
                    }catch (InterruptedException e){
                            e.printStackTrace();
                    }
				}
    }

    /*********************
     * TESTE COM O MAIN
     ********************/

    public static void main(final String[] args) {
        final Shell shell = new Shell();
       shell.screen();
    }
}


