package com.microsoft.cosmos.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;





@Document(collection = "Items")
public class Item {
	@Id
	private String itemKey;
	private Integer itemId;
	private String name;
	private String sku;
	private ItemDetail itemDetail;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date manufacturedOn;
	private List<ItemPart> parts;
	
	public String getItemKey() {
		return this.itemKey;
	}
	public void setItemKey() {
		this.itemKey = this.itemId + this.name;
	}
	public Integer getItemId() {
		return this.itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSku() {
		return this.sku;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public ItemDetail getItemDetail() {
		return this.itemDetail;
	}
	
	public void setItemDetail(ItemDetail itemDetail) {
		this.itemDetail = itemDetail;
	}
	
	public Date getmanufacturedOn() {
		return this.manufacturedOn;
	}
	
	public void setManufacturedOn(Date manufacturedOn) {
		this.manufacturedOn = manufacturedOn;
	}
	
	public List<ItemPart> getParts() {
		return this.parts;
	}
	
	public void setParts(List<ItemPart> parts) {
		this.parts = parts;
	}
	@Override
	public String toString() {
	      return String.format("User: %s %s %s", itemId, name);
	}
}

