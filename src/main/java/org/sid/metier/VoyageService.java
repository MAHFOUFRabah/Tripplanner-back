package org.sid.metier;

import org.sid.entities.VoyageEntity;

import java.util.List;

public interface VoyageService {
    List<VoyageEntity> recupererTousLesVoyagesDeUtilisateur(String idFonctionnel);

    VoyageEntity recupererUnVoyageApartirDeId(Long idVoyage);

    VoyageEntity ajouterUnNouveauVoyage(VoyageEntity voyage, String username);

    void supprimerUnVoyageApartirDeId(Long idVoyage);

    VoyageEntity mettreAjourUnVoyage(Long idVoyage, VoyageEntity voyageEntity);

}
