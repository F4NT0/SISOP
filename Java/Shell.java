/**********************************************
* SHELL DE INTERAÇÃO DO USUÁRIO COM O PROGRAMA
**********************************************/

import javax.swing.*;
import java.awt.Color;

public class Shell {  
    public static void main(String[] args) {  
        
        // Área de Texto
        JTextArea output = new JTextArea();
        output.setSize(920,407);
        output.setBackground(Color.black);
        output.setForeground(Color.green);


        JFrame f=new JFrame();
        f.setSize(930,496); 
        f.add(output);
        f.setLayout(null); 
        f.setVisible(true); 
    }  
} 


