/**********************************************
 * SHELL DE INTERAÇÃO DO USUÁRIO COM O PROGRAMA
 **********************************************/

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;


public class Shell implements KeyListener {
    private JTextArea output;
    private JTextField input;
    private JFrame f;


    public void screen(){

        // Área de Texto
        output = new JTextArea();
        //output.setSize(930,430);
        output.setBounds(0,0,930,400);//(posicaoX,posicaoY,largura,altura)
        output.setBackground(Color.black);
        output.setForeground(Color.green);
        
        // Área de Entrada de texto
        input = new JTextField();
        input.setBounds(0, 406, 930, 40);
        input.setBackground(Color.black);
        input.setForeground(Color.green);

        f=new JFrame();
        f.setSize(930,496);
        f.getContentPane().setBackground(Color.gray);
        f.add(output);
        f.add(input);
        f.setLayout(null);
        f.addKeyListener(this);
        f.setFocusable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    // Métodos importados da classe KeyListener
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}



    public static void main(String[] args) {
       Shell shell = new Shell();
       shell.screen();
    }
}


