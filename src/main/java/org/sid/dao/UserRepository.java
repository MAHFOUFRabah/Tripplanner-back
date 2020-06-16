package org.sid.dao;

import org.sid.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByUsername(String usernam);

    @Modifying
    @Transactional
    @Query("delete from  UserEntity o where o.voyageEntity.idVoyage=:x and o.username=:y ")
    void deleteUserByIdVoyage(@Param("x") Long idVoyage, @Param("y") String username);
}
