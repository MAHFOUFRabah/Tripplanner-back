package org.sid.metier.voyage;

import org.sid.entities.voyage.VoyageEntity;

import java.util.List;

public interface VoyageService {
    List<VoyageEntity> recupererTousLesVoyagesDeUtilisateur();

    VoyageEntity recupererUnVoyageApartirDeId(Long idVoyage);

    VoyageEntity ajouterUnNouveauVoyage(VoyageEntity voyage);

    void supprimerUnVoyageApartirDeId(Long idVoyage);

    VoyageEntity mettreAjourUnVoyage(Long idVoyage, VoyageEntity voyageEntity);

}
