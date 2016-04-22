/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn.back;

import afn.util.ExpressaoAbstrata;
import afn.util.Transicao;
import afn.front.AFNParser;

/**
 *
 * @author Lucas
 */
public class Adicao extends ExpressaoAbstrata{
    private Transicao transicaoA;
    private Transicao transicaoB;
    AFNParser parser = new AFNParser();

    @Override
    public Transicao resolver(String tokens, int i) {
        /** 
         * Acho que não vai dar pra fz as duas
         * o certo é retornar a transicao so com a transicãoA e fz a B no parser super;
        */
        String substringA=tokens.substring(0);
        String substringB=tokens.substring(i, tokens.length());
        transicaoA = parser.analisar(substringA);
        transicaoB = parser.analisar(substringB);
        criarAFN();
        return getTransicao();
    }

    @Override
    protected void criarAFN() {
        //Afn da transicao A
        this.transicao = null;
    }

    @Override
    public Transicao getTransicao() {
        return this.transicao;
    }
    
}
