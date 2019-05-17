package com.microsoft.cosmos.model;

public class ItemKey {
	private Integer itemId;
	private String name;
	
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
	 @Override
	 public boolean equals(Object o) {
		 if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        ItemKey itemKey = (ItemKey) o;
	        if (!itemId.equals(itemKey.itemId)) return false;
	        return name.equals(itemKey.name);
	 }
	 @Override
	 public int hashCode() {
		 int result = itemId.hashCode();
		 result = 31 * result + name.hashCode();
		 return result;
	}
	@Override
	public String toString() {
		return "ItemKey{" +
	                "itemId=" + itemId +
	                ", name='" + name + '\'' +
	                '}';
	}
}
