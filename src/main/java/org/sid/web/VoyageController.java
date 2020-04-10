package org.sid.web;

import org.sid.entities.VoyageEntity;
import org.sid.metier.ArticleService;
import org.sid.metier.UserService;
import org.sid.metier.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoyageController {
    @Autowired
    ArticleService articleService;
    @Autowired
    VoyageService voyageService;
    @Autowired
    UserService userService;

    // Charger tous les voyages
    @CrossOrigin
    @RequestMapping(value = "/allTrips/{username}", method = RequestMethod.GET)
    public List<VoyageEntity> recupererTousLesVoyagesDeUtilisateurWS(@PathVariable String username) {

        return voyageService.recupererTousLesVoyagesDeUtilisateur(username);
    }

    //Charger un voyage spécifique
    @CrossOrigin
    @RequestMapping(value = "/oneTrip/{idVoyage}", method = RequestMethod.GET)
    public VoyageEntity recupererUnVoyageApartirDeIdWS(@PathVariable Long idVoyage) {
        return voyageService.recupererUnVoyageApartirDeId(idVoyage);
    }

    //Ajouter un voyage
    @CrossOrigin
    @RequestMapping(value = "/oneTrip/{username}", method = RequestMethod.POST)
    public VoyageEntity ajouterUnNouveauVoyageWS(@RequestBody VoyageEntity trip, @PathVariable String username) {
        return voyageService.ajouterUnNouveauVoyage(trip, username);
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
