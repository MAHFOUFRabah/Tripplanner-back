package org.sid.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Item {
	@Id @Column(name = "id_item") @GeneratedValue 
	private Long idIitem;
	
	@Column(name = "nom_item")
	private String nomItem;
	
	@Column(name = "belongs_to")
	private String belongsTo;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="CODE_TRIP")
	private Trip trip;

	public String getBelongsTo() {
		return belongsTo;
	}
 

	public void setBelongsTo(String belongsTo) {
		this.belongsTo = belongsTo;
	}


	public String getNomItem() {
		return nomItem;
	}
	

	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	

	public Long getIdIitem() {
		return idIitem;
	}

	public void setIdIitem(Long idIitem) {
		this.idIitem = idIitem;
	}

	public Item(String nomItem, Trip trip) {
		super();
		this.nomItem = nomItem;
		this.trip = trip;
	}
	

	public Item() {
		super();
	}
	
	

}
