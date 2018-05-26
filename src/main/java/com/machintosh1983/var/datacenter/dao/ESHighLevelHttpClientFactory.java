package com.machintosh1983.var.datacenter.dao;

import org.elasticsearch.client.RestHighLevelClient;

public interface ESHighLevelHttpClientFactory {

	public RestHighLevelClient getClient();
	public void close(RestHighLevelClient client);
	
}
