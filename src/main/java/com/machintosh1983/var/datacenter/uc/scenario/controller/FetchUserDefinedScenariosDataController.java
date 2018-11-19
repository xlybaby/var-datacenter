package com.machintosh1983.var.datacenter.uc.scenario.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.machintosh1983.var.datacenter.research.common.Constant;
import com.machintosh1983.var.datacenter.research.common.ErrorCode;
import com.machintosh1983.var.datacenter.research.common.WebApplicationException;
import com.machintosh1983.var.datacenter.research.controller.BaseController;
import com.machintosh1983.var.datacenter.research.model.User;
import com.machintosh1983.var.datacenter.research.model.performance.Scenario;
import com.machintosh1983.var.datacenter.uc.scenario.vo.ScenarioQueryVO;

@RestController
@RequestMapping("/authorized/uc/s")
public class FetchUserDefinedScenariosDataController extends BaseController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping(value="/data", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, String> data( @RequestBody ScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		Map<Object, String> result = new HashMap<Object, String>();
		logger.info("Fetch scenario[id: " + scenarioQueryVO.getScenarioId() + "] data");
		String res = "[{\"value\":\"item1\", \"level\":\"1\"},"
				+ "{\"value\":\"item2\", \"level\":\"1\"},"
				+ "{\"value\":\"item3\", \"level\":\"1\"},"
				+ "{\"value\":\"item4\", \"level\":\"1\"},"
				+ "{\"value\":\"item15\", \"level\":\"1\"}]";//for test
		result.put("message", null);
		result.put("data", res);
		return result;
	}
}
