package org.sid.metier.impl;

import org.sid.dao.ArticleRepository;
import org.sid.dao.VoyageRepository;
import org.sid.entities.ArticleEntity;
import org.sid.entities.UserEntity;
import org.sid.entities.VoyageEntity;
import org.sid.metier.ArticleService;
import org.sid.metier.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    VoyageRepository voyageRepository;
    @Autowired
    UserService userService;

    @Override
    public List<ArticleEntity> recupererTousLesArticlesDuVoyage(Long idVoyage,String username) {
        List<ArticleEntity> listArticleEntity = new CopyOnWriteArrayList<>(articleRepository.recupereTousLesArticleDuVoyageRepository(idVoyage));
        UserEntity userEntity = userService.recupererUserApartirUsername(username);
        for(ArticleEntity article:listArticleEntity){
            if(userEntity.getIdFonctionnelUser().equals(article.getAppartientA())){
                article.setEstFavoris(true);
                listArticleEntity.set(listArticleEntity.indexOf(article),article);
            }
        }
        return listArticleEntity;
    }

    @Override
    public ArticleEntity recupererUnArticleApartirDeSonId(Long idArticle) {
        return articleRepository.findById(idArticle).orElse(null);
    }

    @Override
    public ArticleEntity ajouterUnArticleDuVoyage(ArticleEntity articleEntity, Long idVoyage) {
        ArticleEntity articleEntityModifie;
        VoyageEntity voyageEntity = voyageRepository.findById(idVoyage).orElse(null);
        if (voyageEntity == null) {
            throw new RuntimeException("Aucun voyage n'a été remonté");
        } else {
            articleEntity.setVoyageEntity(voyageEntity);
            articleEntityModifie = articleRepository.save(articleEntity);
        }
        return articleEntityModifie;

    }

    @Override
    public void supprimerUnArticleApartIdVoyage(Long idVoyage) {
        articleRepository.deleteById(idVoyage);
    }

    @Override
    public ArticleEntity ajouterUnArticleAuFavoris(Long idArticle, String username) {
        ArticleEntity articleRecupere = articleRepository.findById(idArticle).orElse(null);
        UserEntity userEntity = userService.recupererUserApartirUsername(username);
        articleRecupere.setAppartientA(userEntity.getIdFonctionnelUser());
        return articleRepository.save(articleRecupere);
    }
}
