package org.sid.metier.article;

import org.sid.entities.article.ArticleEntity;

import java.util.List;

public interface ItemService {

    List<ArticleEntity> recupererTousLesArticlesDuVoyage(Long id);

    ArticleEntity recupererUnArticleApartirDeSonId(Long id);

    ArticleEntity ajouterUnArticleDuVoyage(ArticleEntity item, Long id);

    void supprimerUnArticleApartIdVoyage(Long id);

    ArticleEntity mettreAjourUnArticleDuVoyage(Long idItem, ArticleEntity itemT);
}
