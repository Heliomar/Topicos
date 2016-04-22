/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn.util;

import afn.util.Transicao;


/**
 *
 * @author Lucas
 * Difine as operacoes de conversão:
 * 
 * 
 */
public abstract class ExpressaoAbstrata {
    
    public Transicao transicao;

    /**
     * Faz o pré processameento necessário para a criação do AFN.
     * Cada operação determina o seu pré processamento.
     * @param tokens String a ser processada.
     * @param i index do inicio da string. Divide a expressão regular em duas subexpressões
     * @return retorna as transicoes criadas
     */
    public abstract Transicao resolver(String tokens, int i);

    /**
     *Cria o AFN utilizando as regras do algorittmo de Thompsom, salva o resultado na propriedade transição.
     */
    protected abstract void criarAFN();
    public abstract Transicao getTransicao();
}
