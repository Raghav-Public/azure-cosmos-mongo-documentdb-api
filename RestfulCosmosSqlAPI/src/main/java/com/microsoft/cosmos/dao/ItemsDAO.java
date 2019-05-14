package com.microsoft.cosmos.dao;

import java.util.List;

import com.microsoft.cosmos.model.Item;

public interface ItemsDAO {
	Item getItem(Integer id);
	List<Item> getItems();
	void setItem(Item item);
	List<Item> findItems(Integer itemId, String name);
}

