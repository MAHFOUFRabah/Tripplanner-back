package org.sid.entities.article;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.sid.entities.voyage.VoyageEntity;

import javax.persistence.*;

@Entity
public class ArticleEntity {
    @Id
    @Column(name = "id_article")
    @GeneratedValue
    private Long idArticle;

    @Column(name = "nom_article")
    private String nomArticle;

    @Column(name = "belongs_to")
    private String belongsTo;

    @JsonBackReference
    @ManyToOne
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

    public String getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(String belongsTo) {
        this.belongsTo = belongsTo;
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


}
