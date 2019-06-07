/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.minorbox.entity;

import br.com.minorbox.enums.PerfilUsuariosEnum;
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
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue
    @Column(name="id_usuario")
    private Long id;
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Column(name = "email_usuario")
    private String emailUsuario;
    @Column(name = "perfil_usuario")
    private PerfilUsuariosEnum perfilUsuario;
    @Column(name="senha_usuario")
    private String senha;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public PerfilUsuariosEnum getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuariosEnum perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
