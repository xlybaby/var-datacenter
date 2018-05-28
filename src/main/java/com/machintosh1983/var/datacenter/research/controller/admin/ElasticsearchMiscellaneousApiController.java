package com.machintosh1983.var.datacenter.research.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.machintosh1983.var.datacenter.research.common.Constant;
import com.machintosh1983.var.datacenter.research.common.ErrorCode;
import com.machintosh1983.var.datacenter.research.common.WebApplicationException;
import com.machintosh1983.var.datacenter.research.model.User;
import com.machintosh1983.var.datacenter.research.model.elasticsearch.Field;
import com.machintosh1983.var.datacenter.service.index.AbstractESIndexService;

/**
 * 
 * @author Machintosh1983
 *
 */
@RestController
@RequestMapping("/authorized/es")
public class ElasticsearchMiscellaneousApiController {

	@Autowired
	private AbstractESIndexService abstractESIndexService;
	
	@RequestMapping(value="/indices", method=RequestMethod.GET)
	public String indices( HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
		
		return abstractESIndexService.getAllIndicesInfo();
	}
	
	/**
	 * Get one index info of current user
	 * 
	 * @param name
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/indice/{name}", method=RequestMethod.GET)
	public String indice( @PathVariable String name, HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
//		long userId = user.getUserId();
//		String idxname = userId + AbstractESIndexService.ES_INDEX_USER_BASE;
		return abstractESIndexService.getIndiceInfo(name);
	}
	
	/**
	 * Create an index of current user.
	 * 
	 * @param name
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/createidx/{name}", method=RequestMethod.GET)
	public boolean createIndex( @PathVariable String name, HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
		return abstractESIndexService.createIndex(name);
	}
	
	@RequestMapping(value="/createusridx", method=RequestMethod.GET)
	public boolean createUserIndexBase( HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
		long userId = user.getUserId();
		String idxname = "u"+userId + AbstractESIndexService.ES_INDEX_USER_BASE;
		return abstractESIndexService.createIndex(idxname);
	}
	
	@RequestMapping(value="/deleteidx/{name}", method=RequestMethod.GET)
	public boolean deleteIndex( @PathVariable String name, HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
		return abstractESIndexService.deleteIndex(name);
	}
	
	/**
	 * Add a type mapping of one index of current user.
	 * 
	 * @param name
	 * @param type
	 * @param fields
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addTypeMapping/{name}/{type}", method=RequestMethod.POST)
	public boolean addTypeMapping( @PathVariable String name, @PathVariable String type, @RequestBody List<Field> fields, HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
//		long userId = user.getUserId();
//		String idxname = userId + AbstractESIndexService.ES_INDEX_USER_BASE;
		return abstractESIndexService.addTypeMapping(name, type, fields);
	}
	
	@RequestMapping(value="/addComplexTypeMapping/{name}/{type}", method=RequestMethod.POST)
	public boolean addComplexTypeMapping( @PathVariable String name, @PathVariable String type, @RequestBody String mapping, HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
//		long userId = user.getUserId();
//		String idxname = userId + AbstractESIndexService.ES_INDEX_USER_BASE;
		return abstractESIndexService.addComplexTypeMapping(name, type, mapping);
	}
	
//	public static void main( String[] args ) {
//		List<Field> fields = new ArrayList<Field>();
//		for(int i=0; i<2; i++) {
//			Field field = new Field();
//			field.setName("title");
//			field.setType("type");
//			
//			fields.add(field);
//		}
//		System.out.println(JSONObject.toJSONString(fields));
//	}
	
}
