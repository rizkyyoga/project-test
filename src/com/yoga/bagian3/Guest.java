package com.yoga.bagian3;

import java.util.Date;

public class Guest extends User {
	public Guest(String name, Date registerDate) {
		super.setName(name);
		super.setRegisterDate(registerDate);
		super.setDiscount(0);
	}
}
