package org.sid.web.voyage;

import org.sid.entities.voyage.VoyageEntity;
import org.sid.metier.article.ArticleService;
import org.sid.metier.voyage.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoyageController {
    @Autowired
    ArticleService articleService;
    @Autowired
    VoyageService voyageService;

    // Charger tous les voyages
    @CrossOrigin
    @RequestMapping(value = "/allTrips", method = RequestMethod.GET)
    public List<VoyageEntity> recupererTousLesVoyagesDeUtilisateurWS() {
        return voyageService.recupererTousLesVoyagesDeUtilisateur();
    }

    //Charger un voyage spécifique
    @CrossOrigin
    @RequestMapping(value = "/oneTrip/{id}", method = RequestMethod.GET)
    public VoyageEntity recupererUnVoyageApartirDeIdWS(@PathVariable Long id) {
        return voyageService.recupererUnVoyageApartirDeId(id);
    }

    //Ajouter un voyage
    @CrossOrigin
    @RequestMapping(value = "/oneTrip", method = RequestMethod.POST)
    public VoyageEntity ajouterUnNouveauVoyageWS(@RequestBody VoyageEntity trip) {
        return voyageService.ajouterUnNouveauVoyage(trip);
    }

    // Supprimer un voyage
    @CrossOrigin
    @RequestMapping(value = "/oneTrip/{id}", method = RequestMethod.DELETE)
    public void supprimerUnVoyageApartirDeIdWS(@PathVariable Long id) {
        voyageService.supprimerUnVoyageApartirDeId(id);
    }


    //mettre à jour le nom d'un voyage
    @RequestMapping(value = "/oneTrip/{id}", method = RequestMethod.PUT)
    public VoyageEntity mettreAjourUnVoyageWS(@PathVariable Long id, @RequestBody VoyageEntity tripT) {

        return voyageService.mettreAjourUnVoyage(id, tripT);

    }
}
