package com.machintosh1983.var.datacenter.dao;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.log4j.Logger;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.machintosh1983.var.datacenter.research.common.ErrorCode;
import com.machintosh1983.var.datacenter.research.common.configure.ESClientPoolCommonConfiguration;

@Configuration
public class ESClientInitializer {

	@Autowired
	private ESClientPoolCommonConfiguration eSClientPoolCommonConfiguration;
	 
	@Bean 
	public GenericObjectPoolConfig eSGenericObjectPoolConfig() {
		GenericObjectPoolConfig eSGenericObjectPoolConfig = new GenericObjectPoolConfig();
		eSGenericObjectPoolConfig.setMaxIdle(eSClientPoolCommonConfiguration.getMaxIdle());
		eSGenericObjectPoolConfig.setMaxTotal(eSClientPoolCommonConfiguration.getMaxTotal());
		eSGenericObjectPoolConfig.setTestOnBorrow(eSClientPoolCommonConfiguration.getTestOnBorrow());
		eSGenericObjectPoolConfig.setTestOnReturn(eSClientPoolCommonConfiguration.getTestOnReturn());
		eSGenericObjectPoolConfig.setMinIdle(eSClientPoolCommonConfiguration.getMinIdle());
		eSGenericObjectPoolConfig.setLifo(eSClientPoolCommonConfiguration.getLifo());
        
        return eSGenericObjectPoolConfig;
	}
	
	@Bean
	public ESLowLevelHttpClientFactory eSLowLevelHttpClientFactory(GenericObjectPoolConfig eSGenericObjectPoolConfig) {
		return new ESLowLevelHttpClientFactory() {
			private Logger logger = Logger.getLogger(getClass());
			private GenericObjectPool<RestClient> pool = new GenericObjectPool<RestClient>( new ESLowLevelHttpClientPool(eSClientPoolCommonConfiguration.getVipAddress(), eSClientPoolCommonConfiguration.getPort()), eSGenericObjectPoolConfig );

			@Override
			public RestClient getClient() {
				try {
					return pool.borrowObject();
				} catch (Exception e) {
					logger.error(ErrorCode.error(ErrorCode.CODE_9001), e);
					return null;
				}
			}

			@Override
			public void close(RestClient client) {
				if( client != null )
					pool.returnObject(client);
			}
			
		};
	}
	
	//@Bean
	public ESHighLevelHttpClientFactory eSHighLevelHttpClientFactory(GenericObjectPoolConfig eSGenericObjectPoolConfig) {
		return new ESHighLevelHttpClientFactory() {
			private Logger logger = Logger.getLogger(getClass());
			private GenericObjectPool<RestHighLevelClient> pool = new GenericObjectPool<RestHighLevelClient>( new ESHighLevelHttpClientPool(null), eSGenericObjectPoolConfig );

			@Override
			public RestHighLevelClient getClient() {
				try {
					return pool.borrowObject();
				} catch (Exception e) {
					logger.error(ErrorCode.error(ErrorCode.CODE_9001), e);
					return null;
				}
			}

			@Override
			public void close(RestHighLevelClient client) {
				if( client != null )
					pool.returnObject(client);
			}
			
		};
	}
}
