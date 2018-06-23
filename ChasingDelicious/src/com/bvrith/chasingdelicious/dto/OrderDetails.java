package com.bvrith.chasingdelicious.dto;
import java.sql.Date;
import java.util.*;

public class OrderDetails {
	private double totalcost;
	private String date;
	private String transactionId;
	private double deliveryCharges;
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public double getDeliveryCharges() {
		return deliveryCharges;
	}
	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}
	
}
