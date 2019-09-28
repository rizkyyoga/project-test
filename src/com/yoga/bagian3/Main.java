package com.yoga.bagian3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Product definition
		Product sprite = new Product(ProductType.GROCERY, 3, "Sprite");
		Product proshop = new Product(ProductType.APPAREL, 10.5, "Proshop");
		Product hp = new Product(ProductType.ELECTRONIC, 200, "Xiaomi Redmi Note 5");
		Product hotwheels = new Product(ProductType.TOYS, 5, "Hotwheels");

		// User definition
		Calendar eRegDate = Calendar.getInstance();
		eRegDate.add(Calendar.YEAR, 0);
		User employee = new Employee("Employee", eRegDate.getTime());

		Calendar aRegDate = Calendar.getInstance();
		aRegDate.add(Calendar.YEAR, -1);
		User affiliate = new Affiliate("Affiliate", aRegDate.getTime());

		Calendar gRegDate = Calendar.getInstance();
		gRegDate.add(Calendar.YEAR, -2);
		User guest = new Guest("Guest", gRegDate.getTime());

		// Transaction definition
		// Employee Order
		List<Transaction> elt = new ArrayList<Transaction>();
		Transaction e1 = new Transaction(sprite, employee, 1);
		elt.add(e1);
		Transaction e2 = new Transaction(hp, employee, 3);
		elt.add(e2);
		Order eOrder = new Order(elt);
		System.out.println(eOrder);

		// Affiliate Order
		List<Transaction> alt = new ArrayList<Transaction>();
		Transaction a1 = new Transaction(hotwheels, affiliate, 10);
		alt.add(a1);
		Transaction a2 = new Transaction(sprite, affiliate, 2);
		alt.add(a2);
		Transaction a3 = new Transaction(proshop, affiliate, 1);
		alt.add(a3);
		Order aOrder = new Order(alt);
		System.out.println(aOrder);

		// Guest Order
		List<Transaction> glt = new ArrayList<Transaction>();
		Transaction g1 = new Transaction(sprite, guest, 1);
		glt.add(g1);
		Transaction g2 = new Transaction(proshop, guest, 3);
		glt.add(g2);
		Order gOrder = new Order(glt);
		System.out.println(gOrder);
	}
}
