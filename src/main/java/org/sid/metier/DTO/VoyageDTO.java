package org.sid.metier.DTO;

import javax.persistence.Column;

public class VoyageDTO {
    private Long idVoyage;

    private String nomVoyage;

    private String codeBarre;

    private String appartientA;

    public Long getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(Long idVoyage) {
        this.idVoyage = idVoyage;
    }

    public String getNomVoyage() {
        return nomVoyage;
    }

    public void setNomVoyage(String nomVoyage) {
        this.nomVoyage = nomVoyage;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getAppartientA() {
        return appartientA;
    }

    public void setAppartientA(String appartientA) {
        this.appartientA = appartientA;
    }
}
