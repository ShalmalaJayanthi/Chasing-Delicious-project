package com.bvrith.chasingdelicious.dto;

public class Feedback {
	private  Delivery deliveryId;
	private String feedback;
	public Delivery getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Delivery deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
