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
public class Simbolo extends ExpressaoAbstrata{
    
    String token = "";
    public Simbolo(String token){
        this.token = token;
        //this.transicoes = new Stri
    }
    
    @Override
    public Transicao resolver(String tokens, int i) {
        criarAFN();
        return getTransicao();
    }

    @Override
    public Transicao getTransicao() {
        return this.transicao;
    }

    @Override
    protected void criarAFN() {
        transicao = new Transicao();
        transicao.inico = AFNParser.getCount();
        transicao.fim = AFNParser.getCount();
        String[][] x = new String[][]{{transicao.inico,""+token,transicao.fim}};
        transicao.transicoes = x;
        //return R;
    }

    
}
