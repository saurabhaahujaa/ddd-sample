package com.ddd_bootcamp.domain;

import java.math.BigDecimal;

public class Product {
    private String name;
    private Price price;


	public Price getPrice() {
		return price;
	}


	public void setPrice(Price price) {
		this.price = price;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Product(String name, Price price) {
		super();
		this.name = name;
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

	
}