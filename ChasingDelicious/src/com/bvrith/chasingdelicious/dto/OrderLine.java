package com.bvrith.chasingdelicious.dto;

public class OrderLine {
	private int qty;
	private double cost;
	private FoodItem name;
	private Customer id;
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public FoodItem getName() {
		return name;
	}
	public void setName(FoodItem name) {
		this.name = name;
	}
	public Customer getId() {
		return id;
	}
	public void setId(Customer id) {
		this.id = id;
	}
	
}
 