/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Button;
import java.awt.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author Lucas
 */
public class Tabuleiro extends JPanel {

    JButton[][] Botoes;
    JButton jButtonX;
    JButton jButtonY;
    String jogada;
    String idJogada;

    public Tabuleiro() {
        this.setLayout(new GridBagLayout());
        init();
        addBotoes();
    }

    private void init() {
        jButtonX = new JButton("X");
        jButtonX.setName("0");
        jButtonX.addActionListener(this::setJogada);
        jButtonY = new JButton("O");
        jButtonY.setName("1");
        jButtonY.addActionListener(this::setJogada);
    }

    private void addBotoes() {
        GridBagConstraints c = new GridBagConstraints();
        Botoes = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Botoes[i][j] = new JButton();
                Botoes[i][j].setSize(50, 50);
                c.ipadx = 50;
                c.ipady = 50;
                c.gridx = i;
                c.gridy = j;
                this.add(Botoes[i][j], c);
                Botoes[i][j].addActionListener(this::setValor);
                //Botoes[i][j].setName("0");
            }
        }
        c.ipadx = 20;
        c.gridx = 4;
        c.gridy = 0;
        c.weightx = 3;
        this.add(jButtonX, c);
        c.gridx = 4;
        c.gridy = 1;
        c.insets = new Insets(10, 0, 0, 0);
        this.add(jButtonY, c);
    }

    public void setJogada(ActionEvent evt) {
        JButton b = (JButton) evt.getSource();
        jogada = b.getText();
        idJogada = b.getName();
    }

    public int checaLinhas() {
        for (int linha = 0; linha < 3; linha++) {

            if (Botoes[linha][0].getText().equals("X") && Botoes[linha][1].getText().equals("X") && Botoes[linha][2].getText().equals("X")) {
                JOptionPane.showMessageDialog(this,
                        "X Venceu");
                return -1;
            }
            if (Botoes[linha][0].getText().equals("O") && Botoes[linha][1].getText().equals("O") && Botoes[linha][2].getText().equals("O")) {
                JOptionPane.showMessageDialog(this,
                        "O Venceu");
                return 1;
            }
        }

        return 0;

    }

    public int checaColunas() {
        for (int coluna = 0; coluna < 3; coluna++) {
            if (Botoes[0][coluna].getText().equals("X")
                    && Botoes[1][coluna].getText().equals("X")
                    && Botoes[2][coluna].getText().equals("X")) {
                System.out.println("X");
                JOptionPane.showMessageDialog(this,
                        "X Venceu");
                return -1;
            }
            if (Botoes[0][coluna].getText().equals("O")
                    && Botoes[1][coluna].getText().equals("O")
                    && Botoes[2][coluna].getText().equals("O")) {
                System.out.println("O");
                JOptionPane.showMessageDialog(this,
                        "O Venceu");
                return 1;
            }
        }

        return 0;

    }

    public int checaDiagonais() {

        if (Botoes[0][0].getText().equals("X") && Botoes[1][1].getText().equals("X") && Botoes[2][2].getText().equals("X")) {
            JOptionPane.showMessageDialog(this,
                    "X Venceu");
            return -1;
        }
        if (Botoes[0][0].getText().equals("O") && Botoes[1][1].getText().equals("O") && Botoes[2][2].getText().equals("O")) {
            JOptionPane.showMessageDialog(this,
                    "O Venceu");
            return 1;
        }
        if (Botoes[0][2].getText().equals("O") && Botoes[1][1].getText().equals("O") && Botoes[2][0].getText().equals("O")) {
            JOptionPane.showMessageDialog(this,
                    "O Venceu");
            return -1;
        }
        if (Botoes[0][2].getText().equals("X") && Botoes[1][1].getText().equals("X") && Botoes[2][0].getText().equals("X")) {
            JOptionPane.showMessageDialog(this,
                    "X Venceu");
            return 1;
        }
        return 0;
    }

    public void setValor(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (!"".equals(jogada)) {
            b.setText(jogada);
            b.setName(idJogada);
        }
        jogada = "";
        checaColunas();
        checaLinhas();
        checaDiagonais();
    }

    public void restart() {
        this.removeAll();
        this.repaint();
    }
}
