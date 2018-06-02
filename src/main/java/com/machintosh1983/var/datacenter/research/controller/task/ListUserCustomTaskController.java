package com.machintosh1983.var.datacenter.research.controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.machintosh1983.var.datacenter.research.common.Constant;
import com.machintosh1983.var.datacenter.research.common.ErrorCode;
import com.machintosh1983.var.datacenter.research.common.WebApplicationException;
import com.machintosh1983.var.datacenter.research.model.User;
import com.machintosh1983.var.datacenter.research.model.performance.Scenario;
import com.machintosh1983.var.datacenter.service.task.AbstractUserCustomTaskService;

@RestController
@RequestMapping("/authorized/task")
public class ListUserCustomTaskController {
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private AbstractUserCustomTaskService abstractUserCustomTaskService;
	
	@RequestMapping(value="/query", method=RequestMethod.POST)
	public List<Scenario> query( @RequestBody Scenario scenario, HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
		return abstractUserCustomTaskService.getUserTask( scenario.getUser(), scenario );
	}
	
}
