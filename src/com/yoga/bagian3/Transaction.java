package com.yoga.bagian3;

public class Transaction {
	private Product product;
	private User user;
	private int qty;

	public Transaction(Product product, User user, int qty) {
		this.product = product;
		this.user = user;
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
