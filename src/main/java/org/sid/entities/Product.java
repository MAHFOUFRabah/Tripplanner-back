package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// C'est du mapping object  
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private String id;

    private String name;
    private double price;
    @ManyToOne
    @JoinColumn(name = "CODE_TRIP")
    private Category category;

    public Product(String name, double price, Category category) {
	super();
	this.name = name;
	this.price = price;
	this.category = category;
    }

}
