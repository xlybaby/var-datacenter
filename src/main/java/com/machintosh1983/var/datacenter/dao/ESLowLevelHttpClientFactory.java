package com.machintosh1983.var.datacenter.dao;

import org.elasticsearch.client.RestClient;

public interface ESLowLevelHttpClientFactory {

	public RestClient getClient();
	public void close(RestClient client);
	
}
