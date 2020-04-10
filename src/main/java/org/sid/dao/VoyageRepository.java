package org.sid.dao;

import org.sid.entities.ArticleEntity;
import org.sid.entities.VoyageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoyageRepository extends JpaRepository<VoyageEntity, Long> {

    List<VoyageEntity> findByAppartientA(String idFonctionnel);

    @Query("select o from  VoyageEntity o where o.appartientA=:x")
    List<VoyageEntity> recupereTousLesVoyageDeUser(@Param("x") String idFonctionnel);


}
