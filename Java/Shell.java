/**********************************************
 * SHELL DE INTERAÇÃO DO USUÁRIO COM O PROGRAMA
 **********************************************/

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;


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
        
        // Área de Entrada de texto
        input = new JTextField();
        input.setBounds(0, 406, 930, 40);
        input.setBackground(Color.black);
        input.setForeground(Color.green);
        input.setFocusable(true);
        input.addKeyListener(this);
        input.setFocusTraversalKeysEnabled(false);

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
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            String saida = input.getText();
            commands(saida);
        }
    }
    // Outros não foram utilizados
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

/********************************************
 *  MÉTODO DE CONTROLE DE COMANDOS ENTRADOS
 *******************************************/

    public void commands(String text){
        if(text.equals("exit")){
            f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
        }
    }



/*********************
 *  TESTE COM O MAIN
 ********************/

    public static void main(String[] args) {
       Shell shell = new Shell();
       shell.screen();
    }
}


