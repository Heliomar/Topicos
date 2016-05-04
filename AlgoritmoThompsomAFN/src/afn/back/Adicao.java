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
    boolean ehfim = false; 

    public Adicao(){
        this.transicao = new Transicao();
    }
    @Override
    public Transicao resolver(String tokens, int i) {
        /** 
         * Acho que não vai dar pra fz as duas
         * o certo é retornar a transicao so com a transicãoA e fz a B no parser super;
        */
        String substringA=tokens.substring(0, i);
        String substringB=tokens.substring(i, tokens.length());
        transicaoA = parser.analisar(substringA);
        transicaoB = parser.analisar(substringB);
        if(substringB.equals("")) ehfim = true;
        criarAFN();
        return getTransicao();
    }

    @Override
    protected void criarAFN() {
        transicao.inico = AFNParser.getCount();
        transicao.fim = AFNParser.getCount();
        String[][] novaTransicao = new String[][]{
            {transicao.inico, "e", transicaoA.inico},
            {transicaoA.fim, "e", transicao.fim},
            {transicaoA.fim, "e", transicaoA.inico}
        };
        
        this.transicao.transicoes = novaTransicao;
        transicao.combinaEstados(transicaoA);
        if(!ehfim){
            transicao.combinaEstados(transicaoB);            
        }
        //transicao.combinaEstados(transicaoB);
    }

    @Override
    public Transicao getTransicao() {
        return this.transicao;
    }
    
}
