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

public abstract class AbstractESIndexService {

	private final String context = "elasticsearch";
	
	public abstract String getAllIndicesInfo() throws WebApplicationException ;

	public String getContext() {
		return context;
	}
	
	
}
