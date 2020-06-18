package org.sid.metier;

import org.sid.entities.UserEntity;
import org.sid.entities.VoyageEntity;
import org.sid.metier.DTO.VoyageDTO;

import java.util.List;

public interface VoyageService {
    List<VoyageEntity> recupererTousLesVoyagesDeUtilisateur(String idFonctionnel);

    VoyageEntity recupererUnVoyageApartirDeId(Long idVoyage);

    VoyageEntity ajouterUnNouveauVoyage(VoyageEntity trip, String username);

    void supprimerUnVoyageApartirDeId(String username, Long idVoyage);

    VoyageEntity mettreAjourUnVoyage(Long idVoyage, String nouveauNomDuVoyage);

    UserEntity ajouterUnParticipantAuVoyage(String codeVoyage, String username);

}
