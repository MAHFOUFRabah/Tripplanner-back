package org.sid.entities.article;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.sid.entities.voyage.VoyageEntity;

import javax.persistence.*;

@Entity
public class ArticleEntity {
    @Id
    @Column(name = "id_item")
    @GeneratedValue
    private Long idIitem;

    @Column(name = "nom_item")
    private String nomItem;

    @Column(name = "belongs_to")
    private String belongsTo;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "CODE_TRIP")
    private VoyageEntity voyageEntity;

    public ArticleEntity(String nomItem, VoyageEntity voyageEntity) {
        super();
        this.nomItem = nomItem;
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

    public String getNomItem() {
        return nomItem;
    }

    public void setNomItem(String nomItem) {
        this.nomItem = nomItem;
    }

    public VoyageEntity getVoyageEntity() {
        return voyageEntity;
    }

    public void setVoyageEntity(VoyageEntity voyageEntity) {
        this.voyageEntity = voyageEntity;
    }

    public Long getIdIitem() {
        return idIitem;
    }

    public void setIdIitem(Long idIitem) {
        this.idIitem = idIitem;
    }


}
