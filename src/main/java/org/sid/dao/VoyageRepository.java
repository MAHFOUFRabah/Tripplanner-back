package org.sid.dao;

import org.sid.entities.VoyageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoyageRepository extends JpaRepository<VoyageEntity, Long> {

    List<VoyageEntity> findByAppartientA(String idFonctionnel);


}
