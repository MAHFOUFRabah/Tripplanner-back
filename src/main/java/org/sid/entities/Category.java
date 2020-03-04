package org.sid.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    private String id;

    private String name;
    // Dans ducument Category on ajoutera que id Produit
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Collection<Product> products = new ArrayList<>();

    @Override
    public String toString() {
	return "Category [id=" + id + ", name=" + name + "]";
    }

    public Category(String name, Collection<Product> products) {
	super();
	this.name = name;
	this.products = products;
    }

}
