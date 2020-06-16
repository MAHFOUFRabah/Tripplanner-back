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
    @CrossOrigin
    @RequestMapping(value = "/unArticle/{idArticle}", method = RequestMethod.GET)
    public ArticleEntity recupererUnArticleApartirDeSonIdWS(@PathVariable Long idArticle) {
        return articleService.recupererUnArticleApartirDeSonId(idArticle);
    }

    // Ajouter un article aux favori
    @CrossOrigin
    @RequestMapping(value = "/unArticleFavori/{idArticle}/{username}", method = RequestMethod.POST)
    public ArticleEntity ajouterUnArticlAuFavorisWS(@PathVariable Long idArticle,
                                                        @PathVariable String username) {
        return articleService.ajouterUnArticleAuFavoris(idArticle, username);

    }


    //supprimer un article
    @CrossOrigin
    @RequestMapping(value = "/unArticle/{idArticle}", method = RequestMethod.DELETE)
    public void supprimerUnArticleApartDeSonIdWS(@PathVariable Long idArticle) {
        articleService.supprimerUnArticleApartIdVoyage(idArticle);
    }

    //Ajouter un article
    @CrossOrigin
    @RequestMapping(value = "/unArticle/{id}", method = RequestMethod.POST)
    public ArticleEntity ajouterUnArticleDuVoyage(@RequestBody ArticleEntity articleEntity, @PathVariable Long id) {
        return articleService.ajouterUnArticleDuVoyage(articleEntity, id);
    }

}
