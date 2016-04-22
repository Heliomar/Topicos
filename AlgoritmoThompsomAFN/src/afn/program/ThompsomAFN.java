/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn.program;

import javax.swing.*;

/**
 *
 * @author Lucas
 */
public class ThompsomAFN {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        String showInputDialog = JOptionPane.showInputDialog(frame, "Regex");
        Contexto contexto = new Contexto();
        String afn = contexto.gerarAFN(showInputDialog);
        JOptionPane.showMessageDialog(frame, afn);
        frame.dispose();
    }
}
