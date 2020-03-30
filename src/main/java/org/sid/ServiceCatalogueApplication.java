package org.sid;

import org.sid.dao.article.ArticleRepository;
import org.sid.dao.voyage.VoyageRepository;
import org.sid.entities.article.ArticleEntity;
import org.sid.entities.voyage.VoyageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceCatalogueApplication implements CommandLineRunner {
    @Autowired
    private VoyageRepository tripRepository;

    @Autowired
    private ArticleRepository itemRepository;


    public static void main(String[] args) {
        SpringApplication.run(ServiceCatalogueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        VoyageEntity trip1 = tripRepository.save(new VoyageEntity("USA TRIP"));
        VoyageEntity trip2 = tripRepository.save(new VoyageEntity("EU TRIP"));
        ArticleEntity item1 = itemRepository.save(new ArticleEntity("Papiers", trip1));
        ArticleEntity item2 = itemRepository.save(new ArticleEntity("Chargeurs", trip1));
        ArticleEntity item3 = itemRepository.save(new ArticleEntity("Papiers", trip2));
        ArticleEntity item4 = itemRepository.save(new ArticleEntity("Chargeurs", trip2));
        System.out.println("l'application a démarré !!!");

    }


}
