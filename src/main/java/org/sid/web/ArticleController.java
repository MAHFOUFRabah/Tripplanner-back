package org.sid.web;

import org.sid.entities.ArticleEntity;
import org.sid.metier.ArticleService;
import org.sid.metier.UserService;
import org.sid.metier.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private VoyageService voyageService;

    //Charger Tous les articles
    @CrossOrigin
    @RequestMapping(value = "/tousArticle/{idVoyage}/{username}", method = RequestMethod.GET)
    public List<ArticleEntity> recupererTousLesArticlesDuVoyageWS(@PathVariable Long idVoyage, @PathVariable String username) {

        return articleService.recupererTousLesArticlesDuVoyage(idVoyage,username);
    }

    //Charger un article spécifique
    @RequestMapping(value = "/unArticle/{id}", method = RequestMethod.GET)
    public ArticleEntity recupererUnArticleApartirDeSonIdWS(@PathVariable Long idArticle) {
        return articleService.recupererUnArticleApartirDeSonId(idArticle);
    }

    // Ajouter un article aux favori
    @CrossOrigin
    @RequestMapping(value = "/unArticle/{idArticle}/{username}", method = RequestMethod.PUT)
    public ArticleEntity mettreAjourUnArticleDuVoyageWS(@PathVariable Long idArticle, @RequestBody ArticleEntity articleEntity,
                                                        @PathVariable String username) {
        return articleService.mettreAjourUnArticleDuVoyage(idArticle, articleEntity, username);

    }


    //supprimer un article
    @CrossOrigin
    @RequestMapping(value = "/unArticle/{id}", method = RequestMethod.DELETE)
    public void supprimerUnArticleApartIdVoyageWS(@PathVariable Long idVoyage) {
        articleService.supprimerUnArticleApartIdVoyage(idVoyage);
    }

    //Ajouter un article
    @CrossOrigin
    @RequestMapping(value = "/unArticle/{id}", method = RequestMethod.POST)
    public ArticleEntity ajouterUnArticleDuVoyage(@RequestBody ArticleEntity articleEntity, @PathVariable Long id) {
        return articleService.ajouterUnArticleDuVoyage(articleEntity, id);
    }

}
