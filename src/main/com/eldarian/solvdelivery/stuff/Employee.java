package com.eldarian.solvdelivery.stuff;

public abstract class Employee {
	private int id;
	private String name;

	
	private static int lastId = 0;
	public Employee() {
		this.id = generateId();
		this.name = "<noname>";
	}
	
	public abstract void getRequest(int requestId);
	
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
	
}
