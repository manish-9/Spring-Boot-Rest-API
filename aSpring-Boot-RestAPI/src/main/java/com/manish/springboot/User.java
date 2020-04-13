package com.manish.springboot;

public class User {

	int id, pin;
	String name;
	double balance;
	
	public User() {
		
	}
	
	public User(int id, int pin, String name, double balance) {
		super();
		this.id = id;
		this.pin = pin;
		this.name = name;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pin=" + pin + ", name=" + name + ", balance=" + balance + "]";
	}

}