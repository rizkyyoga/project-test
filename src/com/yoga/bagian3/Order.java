package com.yoga.bagian3;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Order {

	private String orderId;
	private List<Transaction> transaction;

	public Order(List<Transaction> transaction) {
		this.orderId = UUID.randomUUID().toString().replace("-", "");
		this.transaction = transaction;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	private double calculatePrice(Transaction t) {
		double price = t.getProduct().getPrice() * t.getQty();
		double fixedDiscount = Math.round(price / 100) * 5;
		double percentageDiscount = 0;
		if (!t.getProduct().getType().equals(ProductType.GROCERY)) {
			if (t.getUser() instanceof Employee && (price * t.getUser().getDiscount()) > percentageDiscount) {
				percentageDiscount = price * t.getUser().getDiscount();
			}
			if (t.getUser() instanceof Affiliate && (price * t.getUser().getDiscount()) > percentageDiscount) {
				percentageDiscount = price * t.getUser().getDiscount();
			}
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -2);
			if (t.getUser().getRegisterDate().getTime() < cal.getTime().getTime()
					&& (price * 0.05) > percentageDiscount) {
				percentageDiscount = price * 0.05;
			}

		}
		return price - fixedDiscount - percentageDiscount;
	}

	@Override
	public String toString() {
		String ret = new String();
		ret += "Order Id : " + this.orderId + "\n";
		double sum = 0;
		for (Transaction t : transaction) {
			double price = calculatePrice(t);
			sum += price;
			ret += t.getUser().getName() + " Buy " + t.getProduct().getName() + " ($" + t.getProduct().getPrice()
					+ "), qty : " + t.getQty() + ", total price per item (include discount) : $" + price + "\n";
		}
		ret += "Total should be paid : $" + sum + "\n";
		return ret;
	}
}
