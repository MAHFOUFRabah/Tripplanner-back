package org.sid.dao;


import org.sid.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    @Query("select o from  ArticleEntity o where o.voyageEntity.idVoyage=:x")
    List<ArticleEntity> recupereTousLesArticleDuVoyageRepository(@Param("x") Long idVoyage);
}
