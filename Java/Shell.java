/**********************************************
 * SHELL DE INTERAÇÃO DO USUÁRIO COM O PROGRAMA
 **********************************************/

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class Shell implements KeyListener {

    // Construção da Tela
    public static void screen(){
    }


    // Métodos importados da classe KeyListener
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ENTER){

        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    // Método de Ações do Programa
    // public void actionPerformed(ActionEvent e){
    //     if(e.getKeyCode() == KeyEvent.VK_ENTER){
            
    //     }
    // }

    public static void main(String[] args) {
        //TODO: colocar keylistener no programa
            // Área de Texto
            JTextArea output = new JTextArea();
            //output.setSize(930,430);
            output.setBounds(0,0,930,400);//(posicaoX,posicaoY,largura,altura)
            output.setBackground(Color.black);
            output.setForeground(Color.green);
            
            // Área de Entrada de texto
            JTextField input = new JTextField();
            input.setBounds(0, 406, 930, 40);
            input.setBackground(Color.black);
            input.setForeground(Color.green);


    
            JFrame f=new JFrame();
            f.setSize(930,496);
            f.getContentPane().setBackground(Color.gray);
            f.add(output);
            f.add(input);
            f.setLayout(null);
            f.setVisible(true);
        
    }
}


