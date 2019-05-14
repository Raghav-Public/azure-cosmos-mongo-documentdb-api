## Azure CosmosDB Mongo API
### RestfulCosmos

Restful API that connects to Cosmos Mongo API

1. update application.properties with MongoDB connection details
2. Run the app
3. You can use the following APIs
    1. Get All Items
        GET http://localhost:8080/items/v1/ [Responds back with all the Items in a collection]
    2. Get Item by Id
        GET http://localhost:8080/items/v1/{itemId} [Responds back with one Item in a collection]
    3. Create Item
        POST http://localhost:8080/items/v1/
         {
        "itemId": 1,
        "name": "some name",
        "itemDetail": {
            "description": "test",
            "soldInStore": true,
            "imageUrl": "http://imageurl"
        },
        "parts": [
            {
                "size": "10",
                "quantity": 100,
                "price": 65
            },
            {
                "size": "9",
                "quantity": 90,
                "price": 65
            }
        ]
    }


## Azure CosmosDB Native API (SQL/DocumentDB API)
### RestfulCosmosSqlApi

Restful API that connects to Cosmos Sql API

1. update application.properties with DocumentDB/Sql API connection details
2. Run the app
3. You can use the following APIs
    1. Get All Items
        GET http://localhost:8080/items/v1/ [Responds back with all the Items in a collection]
    2. Get Item by Id
        GET http://localhost:8080/items/v1/{itemId} [Responds back with one Item in a collection]
    3. Create Item
        POST http://localhost:8080/items/v1/
         {
        "itemId": 1,
        "name": "some name",
        "itemDetail": {
            "description": "test",
            "soldInStore": true,
            "imageUrl": "http://imageurl"
        },
        "parts": [
            {
                "size": "10",
                "quantity": 100,
                "price": 65
            },
            {
                "size": "9",
                "quantity": 90,
                "price": 65
            }
        ]
    }

Update:
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