package com.microsoft.cosmos.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.documentdb.PartitionKey;
import com.microsoft.azure.spring.data.cosmosdb.core.DocumentDbTemplate;
import com.microsoft.azure.spring.data.cosmosdb.core.query.Criteria;
import com.microsoft.azure.spring.data.cosmosdb.core.query.CriteriaType;
import com.microsoft.azure.spring.data.cosmosdb.core.query.DocumentQuery;
import com.microsoft.cosmos.model.Item;

@Repository
public class SqlAPIDAOImpl implements ItemsDAO {

	/*@Autowired
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
	} */
	
	private final DocumentDbTemplate documentDbTemplate;
	
	@Autowired
	public SqlAPIDAOImpl(DocumentDbTemplate documentDbTemplate) {
		this.documentDbTemplate = documentDbTemplate;
	}
	@Override
	public Item getItem(Integer id) {
		List<Object> itemIdValues = new ArrayList<Object>();
		itemIdValues.add(id);
		Criteria criteria = Criteria.getInstance(CriteriaType.IS_EQUAL, "itemId", itemIdValues);
		DocumentQuery query = new DocumentQuery(criteria);
		List<Item> items = documentDbTemplate.find(query, Item.class, "Items");
		if(items != null && items.size() > 0) {
			return items.get(0);
		}
		return null;
	}

	@Override
	public List<Item> getItems() {
		return documentDbTemplate.findAll("Items", Item.class);
	}

	@Override
	public void setItem(Item item) {
		documentDbTemplate.insert("Items", item, new PartitionKey("itemId"));
	} 
}