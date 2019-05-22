package com.microsoft.cosmos.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.documentdb.PartitionKey;
import com.microsoft.azure.spring.data.cosmosdb.core.DocumentDbTemplate;
import com.microsoft.azure.spring.data.cosmosdb.core.query.Criteria;
import com.microsoft.azure.spring.data.cosmosdb.core.query.CriteriaType;
import com.microsoft.azure.spring.data.cosmosdb.core.query.DocumentQuery;
import com.microsoft.cosmos.model.Item;
import com.microsoft.cosmos.model.ItemKey;

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
		item.setItemKey();
		documentDbTemplate.insert("Items", item, new PartitionKey(item.getItemKey()));
	}
	
	@Override
	public List<Item> findItems(Integer itemId, String name) {
		List<Object> itemIdValues = new ArrayList<Object>();
		itemIdValues.add(itemId);
		List<Object> nameIdValues = new ArrayList<Object>();
		nameIdValues.add(name);
		
		Criteria criteriaItemId = Criteria.getInstance(CriteriaType.IS_EQUAL, "itemId", itemIdValues);
		Criteria criteriaName = Criteria.getInstance(CriteriaType.IS_EQUAL, "name", nameIdValues);
		
		Criteria criteriaAnd = Criteria.getInstance(CriteriaType.AND, criteriaItemId, criteriaName);
		DocumentQuery query = new DocumentQuery(criteriaAnd);
		
		List<Item> items = documentDbTemplate.find(query, Item.class, "Items");
		return items;
	}
	
	@Override
	public List<Item> findItems(Date startDate, Date endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		List<Object> dateValues = new ArrayList<Object>();
		dateValues.add(formatter.format(startDate));
		dateValues.add(formatter.format(endDate));
		Criteria criteria = Criteria.getInstance(CriteriaType.BETWEEN, "manufacturedOn", dateValues);
		DocumentQuery query = new DocumentQuery(criteria);
		
		List<Item> items = documentDbTemplate.find(query, Item.class, "Items");
		return items;
	}
	
	@Override
	public List<Item> findItems(Integer itemId, String name, String sku) {
		
		List<Object> itemIdValues = new ArrayList<Object>();
		itemIdValues.add(itemId);
		List<Object> nameIdValues = new ArrayList<Object>();
		nameIdValues.add(name);
		List<Object> skuValues = new ArrayList<Object>();
		skuValues.add(sku);
		
		Criteria criteriaItemId = Criteria.getInstance(CriteriaType.IS_EQUAL, "itemId", itemIdValues);
		Criteria criteriaName = Criteria.getInstance(CriteriaType.IS_EQUAL, "name", nameIdValues);
		Criteria criteriaFirstAnd = Criteria.getInstance(CriteriaType.AND, criteriaItemId, criteriaName);
		Criteria criteriaSku = Criteria.getInstance(CriteriaType.IS_EQUAL, "sku", skuValues);
		Criteria criteriaSecondAnd = Criteria.getInstance(CriteriaType.AND, criteriaFirstAnd, criteriaSku);
		
		DocumentQuery query = new DocumentQuery(criteriaSecondAnd);
		
		List<Item> items = documentDbTemplate.find(query, Item.class, "Items");
		return items;
	}
}