package org.sid.dao;

import java.util.List;

import org.sid.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long>{
	@Query("select o from Item o where o.trip.idTrip=:x")
	public List<Item> listItemOfTrip(@Param("x")Long idTrip);
}
