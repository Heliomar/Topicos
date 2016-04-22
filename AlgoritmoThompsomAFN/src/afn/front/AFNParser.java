/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn.front;

import afn.back.Adicao;
import afn.back.Concatenar;
import afn.util.ExpressaoAbstrata;
import afn.back.Iteracao;
import afn.front.OperadoresEnum.Operadores;
import afn.back.Simbolo;
import afn.util.Transicao;
import afn.back.Uniao;

/**
 *
 * @author Lucas
 */
public class AFNParser{
    
    public static final String OPERADORES = "+/*.";
    
    public static int COUNT = 0;
    private Transicao transicao;
    
    private void setTransicao(Transicao transicao){
        this.transicao = transicao;
    }
    
    public Transicao getTransicao(){
        return this.transicao;
    }
    
    /**
     * Mantem um contador sequencial para os estados
     * @return um nome de estado qx;
     */
    public static String getCount(){
        return "q"+COUNT++;
    }

    /**
     *Recebe uma cadeia de caracteres e delega as operações necessárias
     * para as classe responsaveis.
     * @param tokens uma expressão regular valida
     * @return AFN do 'tokens'
     */
    public Transicao analisar(String tokens){
        
        /**
        
        if(expressaoTerminal(tokens)){
            setTransicao(new Simbolo(tokens).resolver(tokens, 0));
        }else{
            setTransicao(new Concatenar().resolver(tokens, 1));
        }if(!expressaoTerminal(tokens) && checaOperador(tokens.substring(1, 2))){
            String operador = tokens.substring(0,1);
            ExpressaoAbstrata Expressao = criarExpressao(getNomeDoOperador(operador));
            //tokens = tokens.substring(0)+tokens.substring(2, tokens.length());
            tokens = removerChar(tokens, 1);
            setTransicao(Expressao.resolver(tokens, COUNT));
        }
        
        */
        if(expressaoTerminal(tokens)){
            setTransicao(new Simbolo(tokens).resolver(tokens, 0));
        }else{
            if(checaOperador(tokens.substring(1, 2))){
            String operador = tokens.substring(1,2);
            ExpressaoAbstrata Expressao = criarExpressao(getOperador(operador));
            tokens = removerChar(tokens, 1);
            setTransicao(Expressao.resolver(tokens, 1));
            }else{
                setTransicao(new Concatenar().resolver(tokens, 1));
            }
        }
        
        return getTransicao();
    }     
            
    public boolean checaOperador(String s){
            return OPERADORES.contains(s);
    }
    
    /**
     * Percorre a lista dos operadores para obter o operador solicitado
     * @param operador
     * @return Retorna um operador 
     */
    public Operadores getOperador(String operador){
        Operadores[] values = Operadores.values();
        Operadores name = null;
        for(Operadores e: values){
            if(e.getOperador().equals(operador)){
                name = e;
                break;
            }
        }
        return name;
    }

    /**
     * Verifica se a string é uma expressão terminal
     * @param tokens
     * @return true se expressão terminal
     */
    private boolean expressaoTerminal(String tokens) {
        return tokens.length() == 1;
    }

    /**
     * Fabrica as expressoes de acordo com o nome do operador
     * @param nome
     * @return uma expressao ExpressaoAbstrata
     */
    private ExpressaoAbstrata criarExpressao(Operadores nome) {
       ExpressaoAbstrata expressao = null;
       switch(nome){
           case ADICAO:
               expressao =  new Adicao();
               break;
           case ITERACAO:
               expressao = new Iteracao();
               break;
           case UNIAO:
               expressao = new Uniao();
               break;
       }
       
       return expressao;
    }
    
    /**
     * Remove um char da posicão desejada, insere o restante no final da string
     * @param tokens String
     * @param pos posição para remover
     * @return String sem o caracter da posicao pos
     */
    private String removerChar(String tokens, int pos) {
        String nTokens = tokens.substring(0, pos);
        int i = pos+1;
        while(i < tokens.length()){
            nTokens += tokens.substring(i);
            i++;
        }
        return nTokens;
    }
}
