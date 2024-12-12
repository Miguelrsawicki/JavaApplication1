/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import br.com.views.TelaCliente;
import br.com.views.TelaLogin;
import javax.swing.JFrame;

/**
 *
 * @author MiguelAspire5
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Cria uma nova instância do JFrame
        JFrame frame = new JFrame("Tela de Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Cria uma nova instância da TelaLogin
        TelaCliente telaCliente = new TelaCliente();
        
        // Adiciona a TelaLogin ao JFrame
        frame.add(telaCliente);
        
        // Ajusta o tamanho do frame para caber o conteúdo
        frame.pack();
        
        // Centraliza o frame na tela
        frame.setLocationRelativeTo(null);
        
        // Torna o frame visível
        frame.setVisible(true);
    }
    
}
