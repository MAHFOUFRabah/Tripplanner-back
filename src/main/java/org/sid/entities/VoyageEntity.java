package org.sid.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Random;

@Entity
public class VoyageEntity {
    @Id
    @Column(name = "id_voyage")
    @GeneratedValue
    private Long idVoyage;

    @Column(name = "nom_voyage")
    private String nomVoyage;

    @Column(name = "code_barre")
    private String codeBarre;

    @Column(name = "appartient_a")
    private String appartientA;


    @JsonManagedReference
    @OneToMany(mappedBy = "voyageEntity", fetch = FetchType.LAZY)
    private Collection<ArticleEntity> items;

    public VoyageEntity() {
        super();
    }

    public VoyageEntity(String nomVoyage) {
        super();
        this.nomVoyage = nomVoyage;
        this.codeBarre = this.GenerateCodeBarre();
    }

    public Long getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(Long idVoyage) {
        this.idVoyage = idVoyage;
    }

    public String getNomVoyage() {
        return this.nomVoyage;
    }

    public void setNomVoyage(String nomVoyage) {
        this.nomVoyage = nomVoyage;
    }

	/*public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}*/

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    private String GenerateCodeBarre() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        generatedString = generatedString.toUpperCase();

        return generatedString;
    }

    public String getAppartientA() {
        return appartientA;
    }

    public void setAppartientA(String appartientA) {
        this.appartientA = appartientA;
    }
}
