package org.sid.dao.article;

import org.sid.entities.article.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    @Query("select o from Item o where o.trip.idTrip=:x")
    List<ArticleEntity> recupereTousLesArticleDuVoyageRepository(@Param("x") Long idVoyage);
}
