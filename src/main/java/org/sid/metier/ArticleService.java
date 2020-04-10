package org.sid.metier;

import org.sid.entities.ArticleEntity;

import java.util.List;

public interface ArticleService {

    List<ArticleEntity> recupererTousLesArticlesDuVoyage(Long idVoyage,String username);

    ArticleEntity recupererUnArticleApartirDeSonId(Long idArticle);

    ArticleEntity ajouterUnArticleDuVoyage(ArticleEntity article, Long idVoyage);

    void supprimerUnArticleApartIdVoyage(Long idVoyage);

    ArticleEntity ajouterUnArticleAuFavoris(Long idArticle, String username);
}
