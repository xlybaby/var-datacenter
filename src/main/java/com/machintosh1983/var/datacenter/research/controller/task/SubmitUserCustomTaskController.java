package com.machintosh1983.var.datacenter.research.controller.task;

import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

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
import com.machintosh1983.var.datacenter.service.task.AbstractUserCustomTaskService;

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
	private AbstractUserCustomTaskService abstractUserCustomTaskService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public boolean submit(@RequestBody Scenario scenario, HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
		super.printHeaders(request);
		scenario.setUser(user);

		UUID uid = UUID.randomUUID();
		scenario.setScenarioId(uid.toString());
		
		//return abstractUserCustomTaskService.addTask(scenario);
		return abstractUserCustomTaskService.addTask(AbstractESIndexService.ES_INDEX_USER_CUSTOM_JOB_BASE, AbstractESIndexService.ES_INDEX_USER_CUSTOM_JOB_BASE_TYPE, scenario);
	}
	
	@RequestMapping(value="/multi-add", method=RequestMethod.POST)
	public boolean submitList(@RequestBody List<Scenario> scenarios, HttpServletRequest request ) throws Exception {
		User user = (User)request.getAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER);
		if( user == null ) {
			throw new WebApplicationException(ErrorCode.CODE_9000);
		}
		super.printHeaders(request);
		//scenario.setUser(user);
		return abstractUserCustomTaskService.addTasks( user, scenarios );
	}
	
//	public static void main( String[] args ) {
//		System.out.println(JSONObject.parse("{\"automation\":0,\"layout\":{\"backgroundColor\":\"#FFFFFF\",\"border\":0,\"borderColor\":\"#000000\",\"contentHeight\":100,\"contentWidth\":100,\"marginBottom\":0,\"marginLeft\":0,\"marginRight\":0,\"marginTop\":0,\"offsetParentLeft\":10,\"offsetParentTop\":10,\"opacity\":1.0,\"paddingBottom\":0,\"paddingLeft\":0,\"paddingRight\":0,\"paddingTop\":0,\"zindex\":1},\"maxDuration\":300,\"maxThreadNum\":3,\"scenarioId\":\"0d3e3b36-10a8-46c3-88cb-1e4b00136a6f\",\"scenarioType\":2,\"scenarioTypeName\":\"REFRESHBLOCK\",\"scenelist\":[{\"delay\":0,\"href\":\"http://www.zuanke8.com/forum-2-1.html\",\"pages\":[{\"actors\":[{\"properties\":{\"pageComponent\":[{\"containers\":[{\"iterators\":[{\"items\":[{\"extract\":0,\"img\":0,\"index\":0,\"label\":\"hash-item\",\"link\":0,\"selector\":{\"xpath\":\"tr[1]/th[1]/a[1]\"}},{\"extract\":0,\"img\":0,\"index\":0,\"label\":\"extract-link\",\"link\":1,\"selector\":{\"xpath\":\"tr[1]/th[1]/a[1]\"}}],\"selector\":{\"xpath\":\"tbody\"}}],\"selector\":{\"xpath\":\"//table[@id=\\\"threadlisttableid\\\"]\"}}]}]},\"selector\":{},\"type\":2}]}]}],\"schedule\":{\"interval\":1,\"unit\":\"MINUTES\"},\"title\":\"test subscriber scenario\",\"user\":{\"gender\":-1,\"roleId\":10001,\"userId\":10001,\"userName\":\"test\"}}"));
//	}
}
