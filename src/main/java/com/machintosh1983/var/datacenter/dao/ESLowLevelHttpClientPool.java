package com.machintosh1983.var.datacenter.dao;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.http.HttpHost;
import org.apache.log4j.Logger;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * 
 * @author Machintosh1983
 *
 */
public class ESLowLevelHttpClientPool extends BasePooledObjectFactory<RestClient> {
	private Logger logger = Logger.getLogger(getClass());

	private String vipAddress;
	private int port;
	private String usr;
	private String pwd;
	
	public ESLowLevelHttpClientPool( String vipAddress, int port ) {
		this(vipAddress, port ,null, null);
	}
	
	public ESLowLevelHttpClientPool( String vipAddress, int port , String user, String pwd ) {
		this.vipAddress = vipAddress;
		this.port = port;
		this.usr = user;
		this.pwd = pwd;
	}

	@Override
	public RestClient create() throws Exception {
		logger.info("Create elasticsearch http client["+this.vipAddress+":"+this.port+"]");
		RestClient client = RestClient.builder( new HttpHost(this.vipAddress, this.port, "http") ).build();
		return client;
	}

	@Override
	public PooledObject<RestClient> wrap(RestClient arg0) {
		return new DefaultPooledObject<RestClient>(arg0);
	}

	@Override
	public void passivateObject(PooledObject<RestClient> p) throws Exception {
		super.passivateObject(p);
	}

}
