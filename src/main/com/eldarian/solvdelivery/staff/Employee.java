package com.eldarian.solvdelivery.staff;

import com.eldarian.solvdelivery.Order;

public abstract class Employee {
	private int id;
	private String name;

	
	private static int lastId = 0;

	public Employee() {
		this.id = generateId();
		this.name = "<noname>";
	}

	public abstract boolean handleOrder(Order order);
	
	private int generateId() {
		return ++lastId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
