package org.sid.metier.impl;

import org.sid.dao.UserRepository;
import org.sid.entities.UserEntity;
import org.sid.metier.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity recupererUserApartirUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) throw new RuntimeException("Aucun user n'a été remonté");
        return userEntity;
    }
}
