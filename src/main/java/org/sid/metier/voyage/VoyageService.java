package org.sid.metier.voyage;

import org.sid.entities.voyage.VoyageEntity;

import java.util.List;

public interface VoyageService {
     public List<VoyageEntity> recupererTousLesVoyagesDeUtilisateur();

    public VoyageEntity recupererUnVoyageApartirDeId(Long idVoyage);

    public VoyageEntity ajouterUnNouveauVoyage(VoyageEntity voyage);

    public void supprimerUnVoyageApartirDeId(Long idVoyage);

    public VoyageEntity mettreAjourUnVoyage(Long idVoyage, VoyageEntity voyageEntity);

}
