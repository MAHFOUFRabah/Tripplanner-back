package org.sid.metier.article;

import org.sid.dao.article.ArticleRepository;
import org.sid.dao.voyage.VoyageRepository;
import org.sid.entities.article.ArticleEntity;
import org.sid.entities.voyage.VoyageEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Autowired
    ArticleRepository itemRepository;
    @Autowired
    VoyageRepository tripRepository;

    @Override
    public List<ArticleEntity> recupererTousLesArticlesDuVoyage(Long id) {
        return itemRepository.recupereTousLesArticleDuVoyageRepository(id);
    }

    @Override
    public ArticleEntity recupererUnArticleApartirDeSonId(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public ArticleEntity ajouterUnArticleDuVoyage(ArticleEntity item, Long id) {
        VoyageEntity trip = tripRepository.findById(id).orElse(null);
        item.setVoyageEntity(trip);
        return itemRepository.save(item);
    }

    @Override
    public void supprimerUnArticleApartIdVoyage(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ArticleEntity mettreAjourUnArticleDuVoyage(Long idItem, ArticleEntity itemT) {
        ArticleEntity item = itemRepository.findById(idItem).orElse(null);
        System.out.println(itemT.getBelongsTo());
        item.setBelongsTo(itemT.getBelongsTo());

        return itemRepository.save(item);
    }
}
