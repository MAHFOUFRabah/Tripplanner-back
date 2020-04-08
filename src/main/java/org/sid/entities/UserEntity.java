package org.sid.entities;

import javax.persistence.*;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "username")
    private String username;
    @Column(name = "id_fonctionnel_user")
    private String idFonctionnelUser;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdFonctionnelUser() {
        return idFonctionnelUser;
    }

    public void setIdFonctionnelUser(String idFonctionnelUser) {
        this.idFonctionnelUser = idFonctionnelUser;
    }
}
