package com.microsoft.cosmos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.microsoft.cosmos.model.Item;

@Repository
public class MongoDAOImpl  implements ItemsDAO {
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public MongoDAOImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	@Override
	public Item getItem(Integer id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("itemId").is(id));
		return mongoTemplate.findOne(query, Item.class);
	}

	@Override
	public List<Item> getItems() {
		return this.mongoTemplate.findAll(Item.class);
	}

	@Override
	public void setItem(Item item) {
		this.mongoTemplate.save(item);
	}

}
