package com.machintosh1983.var.datacenter.service.index;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.machintosh1983.var.datacenter.dao.ESLowLevelHttpClientFactory;
import com.machintosh1983.var.datacenter.research.common.ErrorCode;
import com.machintosh1983.var.datacenter.research.common.WebApplicationException;
import com.machintosh1983.var.datacenter.research.model.User;
import com.machintosh1983.var.datacenter.research.model.elasticsearch.Field;
import com.machintosh1983.var.datacenter.research.model.performance.Scenario;

@Service("abstractESIndexService")
public class AbstractESIndexServiceImpl extends AbstractESIndexService {
	private Logger logger = Logger.getLogger(getClass());
	
	@Value("${var.datacenter.esclient.api.createIdx.numberOfShards:3}")
	private int default_index_shards;
	
	@Value("${var.datacenter.esclient.api.createIdx.numberOfReplicas:2}")
	private int default_index_replicas;
	
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

	@Override
	public boolean createIndex(String name) throws WebApplicationException {
		RestClient client = null;
		try {
			client = eSLowLevelHttpClientFactory.getClient();
			Map<String, String> params = Collections.emptyMap();
			String settings = "{\"settings\": {\"number_of_shards\":"+default_index_shards+", \"number_of_replicas\":"+default_index_replicas+"} }";
			logger.info(settings);
			HttpEntity entity = new NStringEntity(settings, ContentType.APPLICATION_JSON);
			//Header contentType =  new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");
			
			Response response = client.performRequest("PUT", "/"+getContext()+"/"+name, params, entity);
			logger.info( EntityUtils.toString(response.getEntity()) );
			
	        return true;
		} catch (IOException e) {
			throw new WebApplicationException(ErrorCode.CODE_3001, e, "AbstractESIndexService.createIndex()");
		} finally {
			eSLowLevelHttpClientFactory.close(client);
		}
	}

	@Override
	public boolean generalPut(String idx, String type, String id, Object document) throws WebApplicationException {
		RestClient client = null;
		try {
			client = eSLowLevelHttpClientFactory.getClient();
			Map<String, String> params = Collections.singletonMap("pretty", "true");
			String idstr = "";
			if( id != null ) {
				idstr = "/"+id;
			}
			String jsonstr = JSONObject.toJSONString(document);
			logger.info(jsonstr);
			HttpEntity entity = new NStringEntity(jsonstr, ContentType.APPLICATION_JSON);

			Response response = client.performRequest("POST", "/"+getContext()+"/"+idx+"/"+type+idstr, params, entity);
			logger.info( EntityUtils.toString(response.getEntity()) );
	        return true;

		} catch (IOException e) {
			throw new WebApplicationException(ErrorCode.CODE_3001, e, "AbstractESIndexService.generalPut()");
		} finally {
			eSLowLevelHttpClientFactory.close(client);
		}
	}

	@Override
	public String getIndiceInfo(String name) throws WebApplicationException {
		RestClient client = null;
		try {
			client = eSLowLevelHttpClientFactory.getClient();
			Response response = client.performRequest("GET", "/"+getContext()+"/"+name+"/_mapping", Collections.singletonMap("pretty", "true"));
	        return EntityUtils.toString(response.getEntity());

		} catch (IOException e) {
			throw new WebApplicationException(ErrorCode.CODE_3001, e, "AbstractESIndexService.getIndiceInfo()");
		} finally {
			eSLowLevelHttpClientFactory.close(client);
		}
	}

	@Override
	public boolean addTypeMapping(String name, String type, List<Field> mapping) throws WebApplicationException {
		RestClient client = null;
		try {
			client = eSLowLevelHttpClientFactory.getClient();
			Map<String, String> params = Collections.singletonMap("pretty", "true");
			String mappingstarts = "{\n" + 
											"    \""+type+"\": {\n" + 
											"            \"properties\": {\n";
											
			String mappingends = "            }\n" + 
											"        }\n" + 
											"  }";
			StringBuffer mappingbody = new StringBuffer("");
			
			if( mapping != null ) {
				for( int i = 0; i < mapping.size(); i++ ) {
					if( i > 0 ) {
						mappingbody.append(",");
					}
					Field field = mapping.get(i);
					mappingbody.append("\"").append(field.getName()).append("\": {\"type\": \"").append(field.getType()).append("\"");
					if( field.getStore() != null ) {
						mappingbody.append(", \"store\": \"").append(field.getStore()).append("\"");
					}
					if( field.getIndex() != null ) {
						mappingbody.append(", \"index\": \"").append(field.getIndex()).append("\"");
					}
					if( field.getFormat() != null ) {
						mappingbody.append(", \"format\": \"").append(field.getFormat()).append("\"");
					}
					mappingbody.append("}");
				}					
				mappingbody.append("\n");
			}
			logger.info(mappingstarts+mappingbody+mappingends);
			HttpEntity entity = new NStringEntity(mappingstarts+mappingbody+mappingends, ContentType.APPLICATION_JSON);
			
			Response response = client.performRequest("POST", "/"+getContext()+"/"+name+"/"+type+"/_mapping", params, entity);
			logger.info( EntityUtils.toString(response.getEntity()) );
	        return true;

		} catch (IOException e) {
			throw new WebApplicationException(ErrorCode.CODE_3001, e, "AbstractESIndexService.generalPut()");
		} finally {
			eSLowLevelHttpClientFactory.close(client);
		}
	}

	@Override
	public boolean deleteIndex(String name) throws WebApplicationException {
		RestClient client = null;
		try {
			client = eSLowLevelHttpClientFactory.getClient();
			Map<String, String> params = Collections.emptyMap();
			Response response = client.performRequest("DELETE", "/"+getContext()+"/"+name, params);
			logger.info( EntityUtils.toString(response.getEntity()) );
			
	        return true;
		} catch (IOException e) {
			throw new WebApplicationException(ErrorCode.CODE_3001, e, "AbstractESIndexService.createIndex()");
		} finally {
			eSLowLevelHttpClientFactory.close(client);
		}
	}

	@Override
	public boolean addComplexTypeMapping(String name, String type, String mapping) throws WebApplicationException {
		RestClient client = null;
		try {
			client = eSLowLevelHttpClientFactory.getClient();
			Map<String, String> params = Collections.singletonMap("pretty", "true");
			
			logger.info(mapping);
			HttpEntity entity = new NStringEntity(mapping, ContentType.APPLICATION_JSON);
			
			Response response = client.performRequest("POST", "/"+getContext()+"/"+name+"/"+type+"/_mapping", params, entity);
			logger.info( EntityUtils.toString(response.getEntity()) );
	        return true;

		} catch (IOException e) {
			throw new WebApplicationException(ErrorCode.CODE_3001, e, "AbstractESIndexService.generalPut()");
		} finally {
			eSLowLevelHttpClientFactory.close(client);
		}
		
	}

	@Override
	public boolean addScenario(String idx, String type, String id, Scenario scenario) throws WebApplicationException {
		RestClient client = null;
		try {
			client = eSLowLevelHttpClientFactory.getClient();
			Map<String, String> params = Collections.singletonMap("pretty", "true");
			String idstr = "";
			if( id != null ) {
				idstr = "/"+id;
			}
//			String scenelist = JSONObject.toJSONString(scenario.getScenelist());
//			String layout = JSONObject.toJSONString(scenario.getLayout());
//			String schedule = JSONObject.toJSONString(scenario.getSchedule());
//			
//			StringBuffer jsonstr = new StringBuffer();
//			jsonstr.append("{");
//			jsonstr.append("\"scenarioId\":\""+scenario.getScenarioId()+"\",");
//			jsonstr.append("\"scenarioType\": "+scenario.getScenarioType()+",");
//
//			jsonstr.append("\"title\":\""+scenario.getTitle()+"\",");
//			jsonstr.append("\"publish\": "+scenario.isPublish()+",");
//			jsonstr.append("\"available\": 1,");
//			jsonstr.append("\"scenelist\": "+scenelist+",");
//			jsonstr.append("\"layout\": "+layout+",");
//			jsonstr.append("\"schedule\": "+schedule);
//			jsonstr.append("}");
//			logger.info(jsonstr);
			
			HttpEntity entity = new NStringEntity(JSONObject.toJSONString(scenario), ContentType.APPLICATION_JSON);

			Response response = client.performRequest("POST", "/"+getContext()+"/"+idx+"/"+type+idstr, params, entity);
			logger.info( EntityUtils.toString(response.getEntity()) );
	        return true;

		} catch (IOException e) {
			throw new WebApplicationException(ErrorCode.CODE_3001, e, "AbstractESIndexService.generalPut()");
		} finally {
			eSLowLevelHttpClientFactory.close(client);
		}
	}

	@Override
	public <T> List<T> multiQuery(String idx, String type, String id, List<String> fields, Object qtext, Class<T> clazz)
			throws WebApplicationException {
		List<T> list = null;
		RestClient client = null;
		try {
			client = eSLowLevelHttpClientFactory.getClient();
			//Map<String, String> param = Collections.singletonMap("pretty", "true");
			StringBuffer jsonstr = new StringBuffer();
			if( fields == null ) {
				jsonstr.append("{\n" + 
						"    \"query\": {\n" + 
						"        \"match_all\": {}\n" + 
						"    }\n" + 
						"}");
			} else {
				jsonstr.append("{\"query\": {");
				jsonstr.append("\"multi_match\": {");
				jsonstr.append("\"query\": ");
				if( qtext instanceof String ) {
					jsonstr.append("\""+qtext+"\"");
				} else
					jsonstr.append(qtext);
				jsonstr.append(", \"fields\": [");
				for(int i=0; i<fields.size(); i++) {
					if( i > 0 )
						jsonstr.append(",");
					String field = fields.get(i);
					jsonstr.append("\""+field+"\"");
				}
				jsonstr.append("]");
				jsonstr.append("}}}");
			}
			logger.info(jsonstr);
			
			HttpEntity entity = new NStringEntity(jsonstr.toString(), ContentType.APPLICATION_JSON);

			Response response = client.performRequest("GET", "/"+getContext()+"/"+idx+"/"+type+"/_search", Collections.singletonMap("pretty", "true"), entity);
			JSONObject json = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));

			JSONObject hits = json.getJSONObject("hits");
			int total = hits.getInteger("total");
			if( total > 0 ) {
				list = new LinkedList<T>();
				JSONArray array = hits.getJSONArray("hits");
				for( int j=0; j<array.size(); j++ ) {
					JSONObject obj = (JSONObject)array.get(j);
					T t = obj.getObject("_source", clazz);
					if( t != null )
						list.add(t);
				}
			}
			return list;
		} catch (IOException e) {
			throw new WebApplicationException(ErrorCode.CODE_3001, e, "AbstractESIndexService.generalPut()");
		} finally {
			eSLowLevelHttpClientFactory.close(client);
		}
		
	}

	@Override
	public <T> List<T> multiFilter(String idx, String type, String id, Map<String, Object> filters, Class<T> clazz)
			throws WebApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
