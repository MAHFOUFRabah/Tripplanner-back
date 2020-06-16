package org.sid.dao;

import org.sid.entities.ArticleEntity;
import org.sid.entities.VoyageEntity;
import org.sid.metier.DTO.VoyageDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoyageRepository extends JpaRepository<VoyageEntity, Long> {

    //List<VoyageEntity> findByAppartientA(String idFonctionnel);
    VoyageEntity findByCodeBarre(String codebarres);

    /*@Query("select o.idVoyage as idVoyage , o.nomVoyage as nomVoyage, o.codeBarre as codeBarre from  VoyageEntity o where o.appartientA=:x")
    List<VoyageEntity> recupereTousLesVoyageDeUser(@Param("x") String idFonctionnel);*/


}

