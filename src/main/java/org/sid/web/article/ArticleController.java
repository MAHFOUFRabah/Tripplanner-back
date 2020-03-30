package org.sid.web.article;

import org.sid.entities.article.ArticleEntity;
import org.sid.metier.article.ItemService;
import org.sid.metier.voyage.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ItemService itemService;
    @Autowired
    TripService tripService;

    //Charger Tous les articles
    @CrossOrigin
    @RequestMapping(value = "/allItems/{id}", method = RequestMethod.GET)
    public List<ArticleEntity> AllItems(@PathVariable Long id) {
        return itemService.recupererTousLesArticlesDuVoyage(id);
    }

    //Charger un article spécifique
    @RequestMapping(value = "/oneItem/{id}", method = RequestMethod.GET)
    public ArticleEntity getItem(@PathVariable Long id) {
        return itemService.recupererUnArticleApartirDeSonId(id);
    }

    // Ajouter un article aux favori
    @CrossOrigin
    @RequestMapping(value = "/oneItem/{idItem}", method = RequestMethod.PUT)
    public ArticleEntity updateItem(@PathVariable Long idItem, @RequestBody ArticleEntity itemT) {

        return itemService.mettreAjourUnArticleDuVoyage(idItem, itemT);

    }


    //supprimer un article
    @CrossOrigin
    @RequestMapping(value = "/oneItem/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable Long id) {
        itemService.supprimerUnArticleApartIdVoyage(id);
    }

    //Ajouter un article
    @CrossOrigin
    @RequestMapping(value = "/oneItem/{id}", method = RequestMethod.POST)
    public ArticleEntity addItem(@RequestBody ArticleEntity item, @PathVariable Long id) {
        return itemService.ajouterUnArticleDuVoyage(item, id);
    }

}
