package org.sid.web;

import org.sid.entities.UserEntity;
import org.sid.entities.VoyageEntity;
import org.sid.metier.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //Ajouter un voyage
    @CrossOrigin
    @RequestMapping(value = "/ajouterUser", method = RequestMethod.POST)
    public UserEntity ajouterUnNouveauVoyageWS(@RequestBody UserEntity userEntity) {
        return this.userService.ajouterUserRegister(userEntity);
    }

}
