package org.sid.metier.impl;

import org.sid.dao.VoyageRepository;
import org.sid.entities.UserEntity;
import org.sid.entities.VoyageEntity;
import org.sid.metier.UserService;
import org.sid.metier.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoyageServiceImpl implements VoyageService {

    @Autowired
    private VoyageRepository tripRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<VoyageEntity> recupererTousLesVoyagesDeUtilisateur(String username) {
        String idFontionnel = userService.recupererUserApartirUsername(username).getIdFonctionnelUser();

        return tripRepository.recupereTousLesVoyageDeUser(idFontionnel);
    }

    @Override
    public VoyageEntity recupererUnVoyageApartirDeId(Long id) {

        VoyageEntity voyageEntity = this.tripRepository.findById(id).orElse(null);
        if (voyageEntity == null) {
            throw new RuntimeException("l'élement n'a été correctement supprimé !");
        }
        return voyageEntity;
    }

    @Override
    public VoyageEntity ajouterUnNouveauVoyage(VoyageEntity trip,String username) {
        VoyageEntity voyageEntity =new VoyageEntity(trip.getNomVoyage());
        UserEntity userEntity = userService.recupererUserApartirUsername(username);
        voyageEntity.setAppartientA(userEntity.getIdFonctionnelUser());
        return tripRepository.save(voyageEntity);
    }

    @Override
    public void supprimerUnVoyageApartirDeId(Long id) {

        tripRepository.deleteById(id);


    }


    @Override
    public VoyageEntity mettreAjourUnVoyage(Long id, VoyageEntity tripT) {
        VoyageEntity nouveauVoyageEntity;
        VoyageEntity voyageEntity = tripRepository.findById(id).orElse(null);
        if (voyageEntity == null) {
            throw new RuntimeException("Aucun voyage n'a été remonté");
        } else {
            voyageEntity.setNomVoyage(tripT.getNomVoyage());
            nouveauVoyageEntity = tripRepository.save(voyageEntity);
        }
        return nouveauVoyageEntity;
    }


}
