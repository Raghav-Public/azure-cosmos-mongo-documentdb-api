package com.microsoft.cosmos.dao;

import java.util.Date;
import java.util.List;

import com.microsoft.cosmos.model.Item;

public interface ItemsDAO {
	Item getItem(Integer id);
	List<Item> getItems();
	void setItem(Item item);
	List<Item> findItems(Integer itemId, String name);
	List<Item> findItems(Integer itemId, String name, String sku);
	List<Item> findItems(Date startDate, Date endDate);
}

