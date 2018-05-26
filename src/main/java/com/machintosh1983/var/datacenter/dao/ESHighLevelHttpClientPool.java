package com.machintosh1983.var.datacenter.dao;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import com.machintosh1983.var.datacenter.research.common.configure.ESClusterNodeConfiguration;

public class ESHighLevelHttpClientPool extends BasePooledObjectFactory<RestHighLevelClient>  {
	
	private HttpHost[] nodes;
	
	public ESHighLevelHttpClientPool( List<ESClusterNodeConfiguration> nodes ) {
		//this.nodes = nodes;
		if( nodes != null )
			this.nodes = (HttpHost[])nodes.toArray();
		
	}
	
	public static void main(String[] args) throws IOException {
		
		RestClient restClient = RestClient.builder( new HttpHost("test-mhis-service.pingan.com.cn", 80, "http") ).build();
		Response response = restClient.performRequest("GET", "elasticsearch/_cat/nodes", Collections.singletonMap("pretty", "true"));
        System.out.println(EntityUtils.toString(response.getEntity()));
        restClient.close();
        
        /*
		ESHttpRestClientFactory factory = new ESHttpRestClientFactory();
		RestHighLevelClient client = factory.restHighLevelClient();
		MainResponse response = client.info();
		ClusterName clusterName = response.getClusterName(); 
		String clusterUuid = response.getClusterUuid(); 
		String nodeName = response.getNodeName(); 
		Version version = response.getVersion(); 
		Build build = response.getBuild(); 
		System.out.println(clusterName+", "+clusterUuid+", "+nodeName+", "+version+", "+build);
		
		CreateIndexRequest request = new CreateIndexRequest("twitter"); 
		request.settings(Settings.builder() 
			    .put("index.number_of_shards", 3)
			    .put("index.number_of_replicas", 1)
			);
		request.alias(
			    new Alias("twitter_alias")  
			);
		//Timeout to wait for the all the nodes to acknowledge the index creation
		request.timeout(TimeValue.timeValueMinutes(2)); 
		//request.timeout("2m");
		
		//Timeout to connect to the master node
		request.masterNodeTimeout(TimeValue.timeValueMinutes(1)); 
		CreateIndexResponse createIndexResponse = client.indices().create(request);
		boolean acknowledged = createIndexResponse.isAcknowledged(); 
		
		//Asynchronous execution of a create index request
//		ActionListener<CreateIndexResponse> listener = new ActionListener<CreateIndexResponse>() {
//		    @Override
//		    public void onResponse(CreateIndexResponse createIndexResponse) {
//		        
//		    }
//
//			@Override
//			public void onFailure(Throwable arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		};
		//client.indices().createAsync(request, listener); 
		*/
	}

	@Override
	public RestHighLevelClient create() throws Exception {
		RestHighLevelClient client = new RestHighLevelClient( RestClient.builder(nodes));
		return client;
	}

	@Override
	public PooledObject<RestHighLevelClient> wrap(RestHighLevelClient arg0) {
		return new DefaultPooledObject<RestHighLevelClient>(arg0);
	}

	@Override
	public void passivateObject(PooledObject<RestHighLevelClient> p) throws Exception {
		// TODO Auto-generated method stub
		super.passivateObject(p);
	}
	
}
