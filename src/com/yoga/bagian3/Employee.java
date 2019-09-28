package com.yoga.bagian3;

import java.util.Date;

public class Employee extends User {

	public Employee(String name,Date registerDate) {
		super.setName(name);
		super.setRegisterDate(registerDate);
		super.setDiscount(0.3);
	}
}
