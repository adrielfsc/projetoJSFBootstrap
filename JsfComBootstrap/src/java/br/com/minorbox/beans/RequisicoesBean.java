/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minorbox.beans;

import br.com.minorbox.dao.RequisicaoReembolsoDAO;
import br.com.minorbox.entity.RequisicaoReembolso;
import br.com.minorbox.enums.StatusRequisicaoEnum;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Adriel
 */
@ManagedBean
@RequestScoped
public class RequisicoesBean {

    RequisicaoReembolso req;
    RequisicaoReembolsoDAO reqDAO;
    StatusRequisicaoEnum reqEnum;
    ArrayList<RequisicaoReembolso> listReqs;
           
            
    public RequisicoesBean() {
        req = new RequisicaoReembolso();
        reqDAO = new RequisicaoReembolsoDAO();
    }
    
  
    
    @PostConstruct
    public void init(){
        listReqs =  reqDAO.listaRembolsos();
    }

    public ArrayList<RequisicaoReembolso> getListReqs() {
        return listReqs;
    }

    public StatusRequisicaoEnum getReqEnum() {
        return reqEnum;
    }
    
    public RequisicaoReembolso editarRequisicoes(){
        return null;
    } 
    
    
    
    
}
