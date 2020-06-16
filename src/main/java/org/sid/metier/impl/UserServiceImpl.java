package org.sid.metier.impl;

import org.sid.dao.UserRepository;
import org.sid.entities.UserEntity;
import org.sid.metier.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> recupererUserApartirUsername(String username) {
       List<UserEntity> userEntity = userRepository.findByUsername(username);
        if (userEntity == null) throw new RuntimeException("Aucun user n'a été remonté");
        return userEntity;
    }

    @Override
    public UserEntity ajouterUserRegister(UserEntity userEntity) {
        List <UserEntity> userDB = userRepository.findByUsername(userEntity.getUsername());
        if(userDB== null || userDB.isEmpty()) {
            UserEntity userSave = new UserEntity(userEntity.getUsername(),userEntity.getIdFonctionnelUser());
            return userRepository.save(userEntity);
        }
        else throw new RuntimeException("l'utilisateur existe déjà");
    }

    @Override
    public UserEntity ajouterUserVoyage(UserEntity userEntity) {


            return userRepository.save(userEntity);


    }

    @Override
    public void supprimerUnUserParIdVoyage(Long idVoyage, String username) {
        userRepository.deleteUserByIdVoyage(idVoyage, username);
    }
}
