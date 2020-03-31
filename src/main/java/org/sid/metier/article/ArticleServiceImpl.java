package org.sid.metier.article;

import org.sid.dao.article.ArticleRepository;
import org.sid.dao.voyage.VoyageRepository;
import org.sid.entities.article.ArticleEntity;
import org.sid.entities.voyage.VoyageEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    VoyageRepository voyageRepository;

    @Override
    public List<ArticleEntity> recupererTousLesArticlesDuVoyage(Long idVoyage) {
        return articleRepository.recupereTousLesArticleDuVoyageRepository(idVoyage);
    }

    @Override
    public ArticleEntity recupererUnArticleApartirDeSonId(Long idArticle) {
        return articleRepository.findById(idArticle).orElse(null);
    }

    @Override
    public ArticleEntity ajouterUnArticleDuVoyage(ArticleEntity articleEntity, Long idVoyage) {
        VoyageEntity voyageEntity = voyageRepository.findById(idVoyage).orElse(null);
        articleEntity.setVoyageEntity(voyageEntity);
        return articleRepository.save(articleEntity);
    }

    @Override
    public void supprimerUnArticleApartIdVoyage(Long idVoyage) {
        articleRepository.deleteById(idVoyage);
    }

    @Override
    public ArticleEntity mettreAjourUnArticleDuVoyage(Long idArticle, ArticleEntity articleEntity) {
        ArticleEntity articleRecupere = articleRepository.findById(idArticle).orElse(null);
        System.out.println(articleEntity.getBelongsTo());
        articleRecupere.setBelongsTo(articleEntity.getBelongsTo());

        return articleRepository.save(articleRecupere);
    }
}
