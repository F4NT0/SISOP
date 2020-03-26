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
        output.setFocusable(false);
        output.setLineWrap(true);
        output.setEditable(false);
        output.setFont(new Font("Serif", Font.ITALIC, 14));
        
        // Área de Entrada de texto
        input = new JTextField();
        input.setBounds(0, 406, 930, 40);
        input.setBackground(Color.black);
        input.setForeground(Color.green);
        input.setFocusable(true);
        input.addKeyListener(this);
        input.setFocusTraversalKeysEnabled(false);
        input.setFont(new Font("Serif", Font.BOLD, 14));

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
        if (text.equals("exit")) {
            f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
        }
        if (text.equals("ls")) {
            List<String> allFiles = new ArrayList<String>();
            try{
                File filename = new File("programs.txt");
                Scanner file = new Scanner(filename);
                while(file.hasNextLine()){
                    allFiles.add(file.next());
                }
                file.close();
            }catch(FileNotFoundException e){
                output.setText("> Programa não encontrado");
            }
            for(int i = 0 ; i < allFiles.size() ; i++){
                output.append("> Arquivo: " + allFiles.get(i) + "\n");
            }
            
        }
        if(text.equals("clear")){
            output.setText("> ");
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


