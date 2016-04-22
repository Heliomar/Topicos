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
 * Classe responsavel pela concatenação das transiçoes
 */
public class Concatenar extends ExpressaoAbstrata{
    Transicao transicaoA;
    Transicao transicaoB;
    AFNParser parser = new AFNParser();
    
    @Override
    public Transicao getTransicao(){
        return this.transicao;
    }
       
    @Override
    public Transicao resolver(String tokens, int i) {
       String substringA = tokens.substring(0, i);
       String substringB = tokens.substring(i, tokens.length());
       transicaoA = parser.analisar(substringA);
       transicaoB = parser.analisar(substringB);
       criarAFN();
       return getTransicao();
    }
    
    @Override
    protected void criarAFN(){
        this.transicao = new Transicao();
        this.transicao.inico = transicaoA.inico;
        transicao.fim = transicaoB.fim;
        String[][] novaTransicao = new String[][]{{transicaoA.fim, "e", transicaoB.inico}};
        transicao.transicoes = novaTransicao;
        transicao.combinaEstados(transicaoA);
        transicao.combinaEstados(transicaoB);
    }
    
}
