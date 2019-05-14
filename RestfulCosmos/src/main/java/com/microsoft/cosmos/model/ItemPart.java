package com.microsoft.cosmos.model;

public class ItemPart {
	private String size;
	private Integer quantity;
	private long price;
	
	public String getSize() {
		return this.size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public long getPrice() {
		return this.price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
}
