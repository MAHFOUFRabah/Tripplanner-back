package org.sid.metier.voyage;

import org.sid.entities.voyage.VoyageEntity;

import java.util.List;

public interface TripService {
    List<VoyageEntity> recupererTousLesVoyagesDeUtilisateur();

    VoyageEntity recupererUnVoyageApartirDeId(Long id);

    VoyageEntity ajouterUnNouveauVoyage(VoyageEntity trip);

    void supprimerUnVoyageApartirDeId(Long id);

    VoyageEntity mettreAjourUnVoyage(Long id, VoyageEntity tripT);

}
