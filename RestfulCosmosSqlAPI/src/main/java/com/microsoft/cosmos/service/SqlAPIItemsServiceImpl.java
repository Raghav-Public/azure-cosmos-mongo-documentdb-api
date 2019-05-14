package com.microsoft.cosmos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microsoft.cosmos.dao.SqlAPIDAOImpl;
import com.microsoft.cosmos.model.Item;

@Service
public class SqlAPIItemsServiceImpl implements ItemsService {

	@Autowired
	private final SqlAPIDAOImpl sqlAPIDAOImpl;
	
	public SqlAPIItemsServiceImpl(SqlAPIDAOImpl sqlAPIDAOImpl) {
		this.sqlAPIDAOImpl = sqlAPIDAOImpl;
	}
	
	
	@Override
	public List<Item> getAllItems() {
		return this.sqlAPIDAOImpl.getItems();
	}

	@Override
	public Item getItemById(Integer id) {
		return this.sqlAPIDAOImpl.getItem(id);
	}

	@Override
	public void saveItem(Item item) {
		this.sqlAPIDAOImpl.setItem(item);
	}
}
