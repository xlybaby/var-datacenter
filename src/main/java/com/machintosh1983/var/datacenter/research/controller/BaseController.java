package com.machintosh1983.var.datacenter.research.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.machintosh1983.var.datacenter.research.common.Constant;
import com.machintosh1983.var.datacenter.research.model.User;

public class BaseController {
	private Logger logger = Logger.getLogger(getClass());
	
	public void printHeaders( HttpServletRequest request ) {
		Enumeration<String> headers = request.getHeaderNames();
		while( headers.hasMoreElements() ) {
			String name = headers.nextElement();
			logger.info( name + ": " + request.getHeader(name) );
		}
		
	}
	
	public User getUser( HttpServletRequest request ) {
		User u = null;
		String token = request.getHeader(Constant.APPLICATION_COOKIE_NAME_TIME);
		u = new User();
		u.setUserId(10000);
		u.setUserName("test001");
		
		return u;
	}
	
	public Map<String, Object> response(int code, String message, Object data) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("retCode", code);
		result.put("retMsg", message);
		result.put("retData", data);
		return result;
	}
}
