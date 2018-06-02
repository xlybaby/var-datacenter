package com.machintosh1983.var.datacenter.service.index;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machintosh1983.var.datacenter.dao.ESLowLevelHttpClientFactory;
import com.machintosh1983.var.datacenter.research.common.ErrorCode;
import com.machintosh1983.var.datacenter.research.common.WebApplicationException;
import com.machintosh1983.var.datacenter.research.model.User;
import com.machintosh1983.var.datacenter.research.model.elasticsearch.Field;
import com.machintosh1983.var.datacenter.research.model.performance.Scenario;

public abstract class AbstractESIndexService {

	private final String context = "elasticsearch";
	
	public static final String ES_INDEX_USER_BASE = "_indice_base";
	public static final String ES_TYPE_USER_CUSTOM_TASK = "custom_task";
	
	public abstract String getAllIndicesInfo() throws WebApplicationException ;

	public abstract String getIndiceInfo( String name ) throws WebApplicationException ;

	public abstract boolean createIndex( String name ) throws WebApplicationException ;
	public abstract boolean deleteIndex( String name ) throws WebApplicationException ;

	public abstract boolean addTypeMapping( String name, String type, List<Field> mapping ) throws WebApplicationException ;
	public abstract boolean addComplexTypeMapping( String name, String type, String mapping ) throws WebApplicationException ;

	public abstract boolean generalPut( String idx, String type, String id, Object document ) throws WebApplicationException ;
	public abstract boolean addScenario( String idx, String type, String id, Scenario scenario ) throws WebApplicationException ;

	public abstract <T> List<T> multiQuery( String idx, String type, String id, List<String> fields, Object qtext, Class<T> clazz ) throws WebApplicationException ;
	
	public abstract <T> List<T> multiFilter( String idx, String type, String id, Map<String, Object> filters, Class<T> clazz ) throws WebApplicationException ;

	public String getContext() {
		return context;
	}
	
}
