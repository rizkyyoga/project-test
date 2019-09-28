package com.yoga.bagian3;

public class Product {
	private ProductType type;
	private double price;
	private String name;

	public Product(ProductType type, double price, String name) {
		this.type = type;
		this.price = price;
		this.name = name;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
