package com.machintosh1983.var.datacenter.research.controller.task;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.machintosh1983.var.datacenter.dao.ESLowLevelHttpClientFactory;
import com.machintosh1983.var.datacenter.research.common.Constant;
import com.machintosh1983.var.datacenter.research.common.ErrorCode;
import com.machintosh1983.var.datacenter.research.common.WebApplicationException;
import com.machintosh1983.var.datacenter.research.controller.BaseController;
import com.machintosh1983.var.datacenter.research.model.User;
import com.machintosh1983.var.datacenter.research.model.performance.Scenario;
import com.machintosh1983.var.datacenter.service.index.AbstractESIndexService;

/**
 * 
 * @author Machintosh1983
 *
 */
@RestController
@RequestMapping("/authorized/task")
public class SubmitUserCustomTaskController extends BaseController {
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private AbstractESIndexService abstractESIndexService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String submit(@RequestBody Scenario scenario, HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
		super.printHeaders(request);
		String result = null;
		
		return result;
	}
	
	
}
