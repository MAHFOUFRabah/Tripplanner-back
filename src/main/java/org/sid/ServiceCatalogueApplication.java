package org.sid;

import org.sid.dao.ArticleRepository;
import org.sid.dao.UserRepository;
import org.sid.dao.VoyageRepository;
import org.sid.entities.ArticleEntity;
import org.sid.entities.UserEntity;
import org.sid.entities.VoyageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ServiceCatalogueApplication implements CommandLineRunner {
    @Autowired
    private VoyageRepository tripRepository;

    @Autowired
    private ArticleRepository itemRepository;

    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(ServiceCatalogueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String idFonctionnel = UUID.randomUUID().toString();
        String idFonctionnel2 = UUID.randomUUID().toString();

        VoyageEntity voy1 = new VoyageEntity("USA TRIP");

       VoyageEntity trip1 = tripRepository.save(voy1);
        VoyageEntity trip2 = tripRepository.save(new VoyageEntity("EU TRIP"));
        ArticleEntity item1 = itemRepository.save(new ArticleEntity("Papiers", trip1));
        ArticleEntity item2 = itemRepository.save(new ArticleEntity("Chargeurs", trip1));
        ArticleEntity item3 = itemRepository.save(new ArticleEntity("Papiers", trip2));
        ArticleEntity item4 = itemRepository.save(new ArticleEntity("Chargeurs", trip2));
        UserEntity userEntity = new UserEntity();
        userEntity.setIdFonctionnelUser(idFonctionnel);
        userEntity.setUsername("admin");
        userEntity.setVoyageEntity(trip1);
        userRepository.save(userEntity).getIdFonctionnelUser();


        UserEntity userEntity2 = new UserEntity();
        userEntity2.setIdFonctionnelUser(idFonctionnel2);
        userEntity2.setUsername("user");
        userEntity2.setVoyageEntity(trip1);
        userRepository.save(userEntity2).getIdFonctionnelUser();

        System.out.println("l'application a démarré !!!");

    }


}
