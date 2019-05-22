package com.microsoft.cosmos.service;

import com.microsoft.cosmos.model.Item;

import java.util.Date;
import java.util.List;

public interface ItemsService {
	List<Item> getAllItems();
	Item getItemById(Integer id);
	void saveItem(Item item);
	List<Item> findItem(Integer itemId, String name);
	List<Item> findItem(Integer itemId, String name, String sku);
	List<Item> findItem(Date startDate, Date endDate);
}