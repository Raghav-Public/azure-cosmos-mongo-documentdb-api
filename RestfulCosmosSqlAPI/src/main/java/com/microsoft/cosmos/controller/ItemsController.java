package com.microsoft.cosmos.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.cosmos.model.Item;
import com.microsoft.cosmos.service.ItemsService;

@RestController
@RequestMapping("/v1")
public class ItemsController {
	
	private ItemsService itemsService;
	
	@Autowired
	public ItemsController(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	
	@GetMapping("/items/") 
	List<Item> getItems() {
		return itemsService.getAllItems();
	}
	@GetMapping("/items/{id}") 
	Item getItems(@PathVariable(value = "id") Integer id) {
		return itemsService.getItemById(id);
	}
	@PostMapping(path = "/items/", consumes = "application/json")
	void setItems(@RequestBody Item item) {
		itemsService.saveItem(item);
	}
	//bad logic but you know 
	@GetMapping("/items")
	public List<Item> find(
			@RequestParam(value = "itemId", required = false, defaultValue = "0") Integer itemId,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "sku", required = false, defaultValue = "") String sku,
			@RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
			) {
		if(startDate != null && endDate != null) {
			return itemsService.findItem(startDate, endDate);
		}
		else if(!sku.isBlank() && !name.isBlank() && itemId > 0) {
			return itemsService.findItem(itemId, name, sku);
		}
		else if(!name.isBlank() && itemId > 0) {
			return itemsService.findItem(itemId, name);
		}
		return null;
	}
}