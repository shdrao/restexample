package com.capgemini.rest.entity;

public class Worker {
	private String name;
	private int id;
	
	public Worker(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", id=" + id + "]";
	}
	

}
