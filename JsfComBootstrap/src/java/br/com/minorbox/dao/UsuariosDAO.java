/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minorbox.dao;

import br.com.minorbox.entity.Usuarios;
import br.com.minorbox.enums.PerfilUsuariosEnum;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Adriel
 */
public class UsuariosDAO {

    public static void main(String[] args) {
        UsuariosDAO dao = new UsuariosDAO();
        
        Usuarios usu = new Usuarios();
        usu.setNomeUsuario("Adriel");
        usu.setSenha("123456");
        usu = dao.buscarUsuario(usu.getNomeUsuario(), usu.getSenha());
        System.out.println(usu.getEmailUsuario());
    }

    public void listarUsuariosString() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("minor_box");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<String> c = cb.createQuery(String.class);
        Root<Usuarios> listaUsuarios = c.from(Usuarios.class);
        c.select(listaUsuarios.<String>get("nomeUsuario"));
        TypedQuery<String> query = manager.createQuery(c);
        List<String> nomes = query.getResultList();
        for (String nome : nomes) {
            System.out.println("Usuario: " + nome);
        }
        manager.close();
        factory.close();
    }

    public void listaUsuariosObj() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("minor_box");
        EntityManager manager = factory.createEntityManager();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Usuarios> c = cb.createQuery(Usuarios.class);
        Root<Usuarios> l = c.from(Usuarios.class);
        c.select(l);
        TypedQuery<Usuarios> query = manager.createQuery(c);
        List<Usuarios> users = query.getResultList();
        for (Usuarios user : users) {
            System.out.println("usuario" + user.getNomeUsuario() + ", email" + user.getEmailUsuario()
                    + ", perfil " + user.getPerfilUsuario().name());
        }
    }

    public Usuarios buscarUsuario(String login, String senha) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("minor_box");
            EntityManager manager = factory.createEntityManager();
             CriteriaBuilder cb = manager.getCriteriaBuilder();
            manager.getTransaction().begin();
            Usuarios usuario = (Usuarios) manager.createQuery("SELECT u from Usuarios u "
                    + "where u.nomeUsuario = :login and u.senha = :senha").
                    setParameter("nomeUsuario", login).setParameter("senha", senha).getSingleResult();
            return usuario;
        } catch (NoResultException e) {
            return null;
        }

    }
}
