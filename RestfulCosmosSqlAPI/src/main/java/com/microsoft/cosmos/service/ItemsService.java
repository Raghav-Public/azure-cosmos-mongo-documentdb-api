package com.microsoft.cosmos.service;

import com.microsoft.cosmos.model.Item;
import java.util.List;

public interface ItemsService {
	List<Item> getAllItems();
	Item getItemById(Integer id);
	void saveItem(Item item);
}