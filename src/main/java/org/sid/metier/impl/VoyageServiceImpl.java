package org.sid.metier.impl;

import org.sid.dao.VoyageRepository;
import org.sid.entities.UserEntity;
import org.sid.entities.VoyageEntity;
import org.sid.metier.DTO.VoyageDTO;
import org.sid.metier.UserService;
import org.sid.metier.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoyageServiceImpl implements VoyageService {

    @Autowired
    private VoyageRepository tripRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<VoyageEntity> recupererTousLesVoyagesDeUtilisateur(String username) {
        List<UserEntity> listVoyageUsers = userService.recupererUserApartirUsername(username);

        List <VoyageEntity> listVoyageEntities  = new ArrayList<>();
        if(listVoyageUsers != null || !listVoyageUsers.isEmpty()  ) {
            for(UserEntity user:listVoyageUsers) {
                if(user.getVoyageEntity() != null) {
                    VoyageEntity voyageUser = tripRepository.findById((user.getVoyageEntity().getIdVoyage())).orElse(null);
                    listVoyageEntities.add(voyageUser);
                }

            }
        }
        return listVoyageEntities;
    }

    @Override
    public VoyageEntity recupererUnVoyageApartirDeId(Long id) {

        VoyageEntity voyageEntity = this.tripRepository.findById(id).orElse(null);
        if (voyageEntity == null) {
            throw new RuntimeException("l'élement n'a été correctement supprimé !");
        }
        return voyageEntity;
    }

    @Override
    public VoyageEntity ajouterUnNouveauVoyage(VoyageEntity trip,String username) {
        VoyageEntity voyageCree = new VoyageEntity(trip.getNomVoyage());
        VoyageEntity voyageDB = tripRepository.save(voyageCree);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setVoyageEntity(voyageDB);
        this.userService.ajouterUserVoyage(userEntity);
        return voyageDB;
    }

    @Override
    public void supprimerUnVoyageApartirDeId(String username, Long idVoyage) {

this.userService.supprimerUnUserParIdVoyage(idVoyage, username);

    }


    @Override
    public VoyageEntity mettreAjourUnVoyage(Long id, VoyageEntity tripT) {
        VoyageEntity nouveauVoyageEntity;
        VoyageEntity voyageEntity = tripRepository.findById(id).orElse(null);
        if (voyageEntity == null) {
            throw new RuntimeException("Aucun voyage n'a été remonté");
        } else {
            voyageEntity.setNomVoyage(tripT.getNomVoyage());
            nouveauVoyageEntity = tripRepository.save(voyageEntity);
        }
        return nouveauVoyageEntity;
    }

    @Override
    public UserEntity ajouterUnParticipantAuVoyage(String codeVoyage, String username) {

        VoyageEntity voyageEntityOriginal =tripRepository.findByCodeBarre(codeVoyage);
        if(voyageEntityOriginal==null) throw new RuntimeException("Aucun Voyage n'a été trouvé avec le code"+codeVoyage);
        else {
            return CreerUnVoyageEntity(username, voyageEntityOriginal);
        }

    }

    private UserEntity CreerUnVoyageEntity( String username, VoyageEntity voyageEntityOriginal) {
        UserEntity userEntity = new UserEntity();
        userEntity.setVoyageEntity(voyageEntityOriginal);
        userEntity.setUsername(username);
        return userService.ajouterUserVoyage(userEntity);
    }


}
