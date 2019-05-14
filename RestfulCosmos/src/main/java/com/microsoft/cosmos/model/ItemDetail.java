package com.microsoft.cosmos.model;

public class ItemDetail {
	private String description;
	private Boolean soldInStore;
	private String imageUrl;
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getSoldInStore() {
		return this.soldInStore;
	}
	
	public void setSoldInStore(Boolean soldInStore) {
		this.soldInStore = soldInStore;
	}
	
	public String getImageUrl() {
		return this.imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
