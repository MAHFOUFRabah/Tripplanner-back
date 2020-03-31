package org.sid.metier.voyage;

import org.sid.dao.voyage.VoyageRepository;
import org.sid.entities.voyage.VoyageEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VoyageServiceImpl implements VoyageService {

    @Autowired
    private VoyageRepository tripRepository;

    @Override
    public List<VoyageEntity> recupererTousLesVoyagesDeUtilisateur() {

        return tripRepository.findAll();
    }

    @Override
    public VoyageEntity recupererUnVoyageApartirDeId(Long id) {

        VoyageEntity voyageEntity = this.recupererUnVoyageApartirDeId(id);
        if (voyageEntity == null) {
            throw new RuntimeException("l'élement n'a été correctement supprimé !");
        }
        return  voyageEntity;
    }

    @Override
    public VoyageEntity ajouterUnNouveauVoyage(VoyageEntity trip) {
        return tripRepository.save(new VoyageEntity(trip.getNomVoyage()));
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
