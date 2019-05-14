package com.microsoft.cosmos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsoft.cosmos.dao.MongoDAOImpl;
import com.microsoft.cosmos.model.Item;

@Service
public class MongoItemsServiceImpl implements ItemsService {

	@Autowired
	private final MongoDAOImpl mongoDAOImpl;
	
	
	public MongoItemsServiceImpl(MongoDAOImpl mongoItemsDAO) {
		this.mongoDAOImpl = mongoItemsDAO;
	}
	
	
	@Override
	public List<Item> getAllItems() {
		return this.mongoDAOImpl.getItems();
	}

	@Override
	public Item getItemById(Integer id) {
		return this.mongoDAOImpl.getItem(id);
	}

	@Override
	public void saveItem(Item item) {
		this.mongoDAOImpl.setItem(item);
	}

}
