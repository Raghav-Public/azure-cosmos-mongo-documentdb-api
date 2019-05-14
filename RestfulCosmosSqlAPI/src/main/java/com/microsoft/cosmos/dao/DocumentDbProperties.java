package com.microsoft.cosmos.dao;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "azure.cosmosdb")
public class DocumentDbProperties {
	private String uri;
	private String key;
	private String database;
	
	public String getUri() {
		return this.uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getKey() {
		return this.key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getDatabase() {
		return this.database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	
}
