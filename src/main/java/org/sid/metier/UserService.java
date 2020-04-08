package org.sid.metier;

import org.sid.entities.UserEntity;

public interface UserService {
    UserEntity recupererUserApartirUsername(String username);
}
