package org.sid.web.voyage;

import org.sid.entities.voyage.VoyageEntity;
import org.sid.metier.article.ItemService;
import org.sid.metier.voyage.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoyageController {
    @Autowired
    ItemService itemService;
    @Autowired
    TripService tripService;

    // Charger tous les voyages
    @CrossOrigin
    @RequestMapping(value = "/allTrips", method = RequestMethod.GET)
    public List<VoyageEntity> AllTrip() {
        return tripService.recupererTousLesVoyagesDeUtilisateur();
    }

    //Charger un voyage spécifique
    @CrossOrigin
    @RequestMapping(value = "/oneTrip/{id}", method = RequestMethod.GET)
    public VoyageEntity getTrip(@PathVariable Long id) {
        return tripService.recupererUnVoyageApartirDeId(id);
    }

    //Ajouter un voyage
    @CrossOrigin
    @RequestMapping(value = "/oneTrip", method = RequestMethod.POST)
    public VoyageEntity addTrip(@RequestBody VoyageEntity trip) {
        return tripService.ajouterUnNouveauVoyage(trip);
    }

    // Supprimer un voyage
    @CrossOrigin
    @RequestMapping(value = "/oneTrip/{id}", method = RequestMethod.DELETE)
    public void deleteTrip(@PathVariable Long id) {
        tripService.supprimerUnVoyageApartirDeId(id);
    }


    //mettre à jour le nom d'un voyage
    @RequestMapping(value = "/oneTrip/{id}", method = RequestMethod.PUT)
    public VoyageEntity updateTrip(@PathVariable Long id, @RequestBody VoyageEntity tripT) {

        return tripService.mettreAjourUnVoyage(id, tripT);

    }
}
