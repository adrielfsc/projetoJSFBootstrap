/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minorbox.entity;

import br.com.minorbox.enums.StatusRequisicaoEnum;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adriel
 */

@Entity
@Table(name = "reembolso")
public class RequisicaoReembolso {
    @Id
    @GeneratedValue
    @Column(name = "reembolso_id")
    private int id;
    @Column(name = "valor_reembolso")
    private String valorRequisicao;
    @Column(name = "descricao_reembolso")
    private String descricaoRequisicao;
    @Column(name = "aprova_reembolso")
    private StatusRequisicaoEnum statusRequisicao;

    public String getValorRequisicao() {
        return valorRequisicao;
    }

    public void setValorRequisicao(String valorRequisicao) {
        this.valorRequisicao = valorRequisicao;
    }

    public String getDescricaoRequisicao() {
        return descricaoRequisicao;
    }

    public void setDescricaoRequisicao(String descricaoRequisicao) {
        this.descricaoRequisicao = descricaoRequisicao;
    }

    public StatusRequisicaoEnum getStatusRequisicao() {
        return statusRequisicao;
    }

    public void setStatusRequisicao(StatusRequisicaoEnum statusRequisicao) {
        this.statusRequisicao = statusRequisicao;
    }

    public int getId() {
        return id;
    }
   
 
    
    
}
