package com.microsoft.cosmos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microsoft.cosmos.model.Item;

@Repository
public class SqlAPIDAOImpl implements ItemsDAO {

	@Autowired
	private final ItemsRepository itemsRepository;
	
	@Autowired
	public SqlAPIDAOImpl(ItemsRepository itemsRepository) {
		this.itemsRepository = itemsRepository;
	}
	@Override
	public Item getItem(Integer id) {
		List<Item> items = itemsRepository.findByItemId(id);
		Item item = null;
		if(items != null && items.size() > 0) {
			item = items.get(0);
		}
		return item;
		//return itemsRepository.findByItemId(id);
	}

	@Override
	public List<Item> getItems() {
		return (List<Item>)itemsRepository.findAll();
	}

	@Override
	public void setItem(Item item) {
		itemsRepository.save(item);
	} 
	
}