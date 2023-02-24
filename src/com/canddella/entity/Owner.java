package com.canddella.entity;

public class Owner {
	
	private int ownerId;
	private String ownerName;
	private String ownerphoneNumber;
	private String ownerEmail;
	private String ownerAddress;
	
	public Owner() {
		super();
	}
	public Owner(int ownerId, String ownerName, String ownerphoneNumber, String ownerEmail, String ownerAddress) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerphoneNumber = ownerphoneNumber;
		this.ownerEmail = ownerEmail;
		this.ownerAddress = ownerAddress;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerphoneNumber() {
		return ownerphoneNumber;
	}
	public void setOwnerphoneNumber(String ownerphoneNumber) {
		this.ownerphoneNumber = ownerphoneNumber;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	
	

}
