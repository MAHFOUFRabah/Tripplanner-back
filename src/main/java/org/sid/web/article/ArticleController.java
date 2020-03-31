package org.sid.web.article;

import org.sid.entities.article.ArticleEntity;
import org.sid.metier.article.ArticleService;
import org.sid.metier.voyage.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    VoyageService voyageService;

    //Charger Tous les articles
    @CrossOrigin
    @RequestMapping(value = "/tousArticle/{id}", method = RequestMethod.GET)
    public List<ArticleEntity> recupererTousLesArticlesDuVoyageWS(@PathVariable Long idVoyage) {
        return articleService.recupererTousLesArticlesDuVoyage(idVoyage);
    }

    //Charger un article spécifique
    @RequestMapping(value = "/unArticle/{id}", method = RequestMethod.GET)
    public ArticleEntity recupererUnArticleApartirDeSonIdWS(@PathVariable Long idArticle) {
        return articleService.recupererUnArticleApartirDeSonId(idArticle);
    }

    // Ajouter un article aux favori
    @CrossOrigin
    @RequestMapping(value = "/unArticle/{idArticle}", method = RequestMethod.PUT)
    public ArticleEntity mettreAjourUnArticleDuVoyageWS(@PathVariable Long idArticle, @RequestBody ArticleEntity articleEntity) {

        return articleService.mettreAjourUnArticleDuVoyage(idArticle, articleEntity);

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
