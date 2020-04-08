package org.sid.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ArticleEntity {
    @Id
    @Column(name = "id_article")
    @GeneratedValue
    private Long idArticle;

    @Column(name = "nom_article")
    private String nomArticle;

    @Column(name = "appartient_a")
    private String appartientA;


    private Boolean estFavoris;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODE_VOYAGE")
    private VoyageEntity voyageEntity;

    public ArticleEntity(String nomArticle, VoyageEntity voyageEntity) {
        super();
        this.nomArticle = nomArticle;
        this.voyageEntity = voyageEntity;
    }


    public ArticleEntity() {
        super();
    }

    public String getAppartientA() {
        return appartientA;
    }

    public void setAppartientA(String appartientA) {
        this.appartientA = appartientA;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public VoyageEntity getVoyageEntity() {
        return voyageEntity;
    }

    public void setVoyageEntity(VoyageEntity voyageEntity) {
        this.voyageEntity = voyageEntity;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public Boolean getEstFavoris() {
        return estFavoris;
    }

    public void setEstFavoris(Boolean estFavoris) {
        this.estFavoris = estFavoris;
    }
}
