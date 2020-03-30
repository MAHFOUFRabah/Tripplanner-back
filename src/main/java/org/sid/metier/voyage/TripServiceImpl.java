package org.sid.metier.voyage;

import org.sid.dao.voyage.VoyageRepository;
import org.sid.entities.voyage.VoyageEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TripServiceImpl implements TripService {

    @Autowired
    private VoyageRepository tripRepository;

    @Override
    public List<VoyageEntity> recupererTousLesVoyagesDeUtilisateur() {
        return tripRepository.findAll();
    }

    @Override
    public VoyageEntity recupererUnVoyageApartirDeId(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    @Override
    public VoyageEntity ajouterUnNouveauVoyage(VoyageEntity trip) {
        return tripRepository.save(new VoyageEntity(trip.getNomTrip()));
    }

    @Override
    public void supprimerUnVoyageApartirDeId(Long id) {
        tripRepository.deleteById(id);
    }


    public VoyageEntity mettreAjourUnVoyage(Long id, VoyageEntity tripT) {
        VoyageEntity trip = tripRepository.findById(id).orElse(null);
        trip.setNomTrip(tripT.getNomTrip());

        return tripRepository.save(trip);
    }
}
