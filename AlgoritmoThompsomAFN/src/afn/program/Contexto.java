/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn.program;

import afn.front.AFNParser;
import afn.util.Transicao;

/**
 *
 * @author Lucas
 */
class Contexto {
    
    public String gerarAFN(String showInputDialog) {
        AFNParser parser = new AFNParser();
        Transicao compilado = parser.analisar(showInputDialog);
        return compilado.toFormatedString();
    }
    
}
