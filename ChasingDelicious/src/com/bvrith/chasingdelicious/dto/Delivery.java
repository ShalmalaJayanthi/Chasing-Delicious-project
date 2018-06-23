package com.bvrith.chasingdelicious.dto;
import java.util.*;

public class Delivery {
	private double totalAmount;
	private String date;
	private String status;
	private String deliveryId;
	private OrderDetails transactionId;
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		totalAmount = totalAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	public OrderDetails getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(OrderDetails transactionId) {
		this.transactionId = transactionId;
	}
	
	
}
