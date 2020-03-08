package org.sid.entities;

import java.util.Collection;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Trip {
	@Id @Column(name = "id_trip") @GeneratedValue 
	private Long idTrip;
	
	@Column(name = "nom_trip")
	private String nomTrip; 
	
	@Column(name = "code_barre")
	private String codeBarre;
	
	
	/*@JsonManagedReference
	@OneToMany(mappedBy="trip",fetch=FetchType.LAZY)
	private Collection<Item> items;*/

	public Long getIdTrip() {
		return idTrip;
	}

	public void setIdTrip(Long idTrip) {
		this.idTrip = idTrip;
	}

	public String getNomTrip() {
		return this.nomTrip;
	}

	
	public String getCodeBarre() {
		return codeBarre;
	}

	public void setCodeBarre(String codeBarre) {
		this.codeBarre = codeBarre;
	}

	public void setNomTrip(String nomTrip) {
		this.nomTrip = nomTrip;
	}

	/*public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}*/
	

	public Trip() {
		super();
	}

	public Trip(String nomTrip) {
		super();
		this.nomTrip = nomTrip;
		this.codeBarre= this.GenerateCodeBarre();
	}
	
	 
	
	private String GenerateCodeBarre(){
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 6;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    
	    generatedString =generatedString.toUpperCase();
	 
	    return generatedString;
	}
	

}
