package org.sid.metier;

import org.sid.entities.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> recupererUserApartirUsername(String username);

    UserEntity ajouterUserRegister(UserEntity userEntity);

    UserEntity ajouterUserVoyage(UserEntity userEntity);

    void supprimerUnUserParIdVoyage(Long idVoyage, String username);

}
