package com.microsoft.cosmos.dao;


import java.util.List;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import com.microsoft.cosmos.model.Item;

@Repository
@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemsRepository extends DocumentDbRepository<Item, String>{
	List<Item> findByItemId(Integer itemId);
}
