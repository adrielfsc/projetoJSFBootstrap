/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minorbox.dao;

import br.com.minorbox.entity.RequisicaoReembolso;
import br.com.minorbox.entity.Usuarios;
import br.com.minorbox.enums.StatusRequisicaoEnum;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Adriel
 */
public class RequisicaoReembolsoDAO {

    public static void main(String[] args) {
        RequisicaoReembolsoDAO dao = new RequisicaoReembolsoDAO();
        dao.listaRembolsos();
    }

    public boolean criarNovaSolicitacao(RequisicaoReembolso req) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("minor_box");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        if (null != req) {
            req.setStatusRequisicao(StatusRequisicaoEnum.O);
            manager.persist(req);
            manager.getTransaction().commit();
            factory.close();
            return true;
        } else {
            System.out.println("A requisição não pode ser nula");
            return false;
        }

    }

    public ArrayList listaRembolsos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("minor_box");
        EntityManager manager = factory.createEntityManager();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<RequisicaoReembolso> c = cb.createQuery(RequisicaoReembolso.class);
        Root<RequisicaoReembolso> l = c.from(RequisicaoReembolso.class);
        c.select(l);
        TypedQuery<RequisicaoReembolso> query = manager.createQuery(c);
        List<RequisicaoReembolso> reembolsos = query.getResultList();
        for (RequisicaoReembolso reembolso : reembolsos) {
            System.out.println("descricao: " + reembolso.getDescricaoRequisicao() + ", valor: "
                    + reembolso.getValorRequisicao()
                    + ", Status requisicao " + reembolso.getStatusRequisicao().name());
        }
        
        return (ArrayList)reembolsos;
    }

    public void aprovarRequisicao(RequisicaoReembolso req) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("minor_box");
        EntityManager manager = factory.createEntityManager();
        req.setStatusRequisicao(StatusRequisicaoEnum.A);

    }

    public void rejeitarRequiscao(RequisicaoReembolso req) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("minor_box");
        EntityManager manager = factory.createEntityManager();
        RequisicaoReembolso requisicao = manager.find(RequisicaoReembolso.class, req.getId());

        req.setStatusRequisicao(StatusRequisicaoEnum.R);
    }

    public void alterarSolicitacao(RequisicaoReembolso req) {
        //usuario altera descricao ou valor da requisicao
    }

}
