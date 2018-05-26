package com.machintosh1983.var.datacenter.service.index;

import java.io.IOException;
import java.util.Collections;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machintosh1983.var.datacenter.dao.ESLowLevelHttpClientFactory;
import com.machintosh1983.var.datacenter.research.common.ErrorCode;
import com.machintosh1983.var.datacenter.research.common.WebApplicationException;

@Service("abstractESIndexService")
public class AbstractESIndexServiceImpl extends AbstractESIndexService {

	@Autowired
	private ESLowLevelHttpClientFactory eSLowLevelHttpClientFactory;

	public String getAllIndicesInfo() throws WebApplicationException {
		RestClient client = null;
		try {
			client = eSLowLevelHttpClientFactory.getClient();
			Response response = client.performRequest("GET", "/"+getContext()+"/_cat/indices?v", Collections.singletonMap("pretty", "true"));
	        return EntityUtils.toString(response.getEntity());

		} catch (IOException e) {
			throw new WebApplicationException(ErrorCode.CODE_3001, e, "AbstractESIndexService.getAllIndicesInfo()");
		} finally {
			eSLowLevelHttpClientFactory.close(client);
		}
	}
}
