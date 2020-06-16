package org.sid.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "CODE_VOYAGE")
    private VoyageEntity voyageEntity;

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

    public UserEntity(String username, String idFonctionnelUser) {
        this.username = username;
        this.idFonctionnelUser = idFonctionnelUser;
    }


    public UserEntity() {
    }

    public VoyageEntity getVoyageEntity() {
        return voyageEntity;
    }

    public void setVoyageEntity(VoyageEntity voyageEntity) {
        this.voyageEntity = voyageEntity;
    }

}
