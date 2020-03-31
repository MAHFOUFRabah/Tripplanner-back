package org.sid.metier.article;

import org.sid.entities.article.ArticleEntity;

import java.util.List;

public interface ArticleService {

    List<ArticleEntity> recupererTousLesArticlesDuVoyage(Long idVoyage);

    ArticleEntity recupererUnArticleApartirDeSonId(Long idArticle);

    ArticleEntity ajouterUnArticleDuVoyage(ArticleEntity article, Long idVoyage);

    void supprimerUnArticleApartIdVoyage(Long idVoyage);

    ArticleEntity mettreAjourUnArticleDuVoyage(Long idArticle, ArticleEntity article);
}
