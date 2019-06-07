/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minorbox.enums;

/**
 *
 * @author Adriel
 */
public enum StatusRequisicaoEnum {
    A("Aprovado"),
    E("Esperando"),
    R("Rejeitado"),
            
    O("Opened");
    
    private String tipo;

    private StatusRequisicaoEnum(final String tipo) {
        this.tipo = tipo;
    }
    
}
