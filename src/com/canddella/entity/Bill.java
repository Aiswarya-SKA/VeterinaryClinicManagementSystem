package com.canddella.entity;



public class Bill {
	
	private int billId;
	private Visits visits; //HAS A 
	private int totalAmount;
	private String paymentMode;
	private String paymentDate;
	
	public Bill() {
		super();
	}

	public Bill(int billId, Visits visits, int totalAmount, String paymentMode, String paymentDate) {
		super();
		this.billId = billId;
		this.visits = visits;
		this.totalAmount = totalAmount;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Visits getVisits() {
		return visits;
	}

	public void setVisits(Visits visits) {
		this.visits = visits;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	

}
