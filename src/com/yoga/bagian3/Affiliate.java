package com.yoga.bagian3;

import java.util.Date;

public class Affiliate extends User {

	public Affiliate(String name, Date registerDate) {
		super.setName(name);
		super.setRegisterDate(registerDate);
		super.setDiscount(0.1);
	}
}
