/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class Jogo extends JFrame{
    JFrame frame = new JFrame("FrameDemo");
    JPanel inicio = new Inicio();
    Tabuleiro tabuleiro = new Tabuleiro();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Opçoes");
    JMenuItem menuItemInicio = new JMenuItem("Menu");
    JMenuItem menuItemReiniciar = new JMenuItem("Reiniciar");
    
    public Jogo(){
        initComponents();
    }
    public static void main(String[] args) {   
       new Jogo().setVisible(true);
      
    }
    
    private  void initComponents(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        menuBar.setVisible(false);
        menuItemInicio.addActionListener(this::voltarInicionAction);
        menuItemReiniciar.addActionListener(this::reinciarAction);
        menu.add(menuItemInicio);
        menu.add(menuItemReiniciar);
        menuBar.add(menu);
        setJMenuBar(menuBar);
 
        remove(tabuleiro);
        add(inicio);
        pack();
        repaint();
        revalidate();
    }

    private void voltarInicionAction(ActionEvent evt) {
        initComponents();
    }
    
    private void reinciarAction(ActionEvent evt) {
       Reiniciar();
    }
    
    public void IniciarJogo(){
        remove(inicio);
        add(tabuleiro);
        menuBar.setVisible(true);
        revalidate();
        repaint();
    }

    private void Reiniciar() {
        remove(tabuleiro);
        tabuleiro = new Tabuleiro();
        add(tabuleiro);
        revalidate();
        repaint();
    }
    
}
