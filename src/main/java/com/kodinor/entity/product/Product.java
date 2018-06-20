package com.kodinor.entity.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public Product() {
		//
	}
	
	

}
