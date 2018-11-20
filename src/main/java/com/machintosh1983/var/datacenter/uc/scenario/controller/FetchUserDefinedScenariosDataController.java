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
import com.machintosh1983.var.datacenter.uc.scenario.vo.CorpusScenarioQueryVO;
import com.machintosh1983.var.datacenter.uc.scenario.vo.ScenarioQueryVO;

@RestController
@RequestMapping("/authorized/uc/s")
public class FetchUserDefinedScenariosDataController extends BaseController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping(value="/data/corpus", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, String> dataCorpus( @RequestBody CorpusScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		Map<Object, String> result = new HashMap<Object, String>();
		int level = scenarioQueryVO.getLevel();
		String res = null;
		logger.info("Fetch scenario[id: " + scenarioQueryVO.getScenarioId() + "] data");
		if( level == 1 )
			res = "[{\"value\":\"item1\", \"level\":\"1\"},"
				+ "{\"value\":\"item2\", \"level\":\"1\"},"
				+ "{\"value\":\"item3\", \"level\":\"1\"},"
				+ "{\"value\":\"item4\", \"level\":\"1\"},"
				+ "{\"value\":\"item15\", \"level\":\"1\"}]";//for test
		if( level == 2 )
			res = "[{\"value\":\"subitem1\", \"level\":\"2\"},"
				+ "{\"value\":\"subitem2\", \"level\":\"2\"},"
				+ "{\"value\":\"subitem3\", \"level\":\"2\"},"
				+ "{\"value\":\"subitem4\", \"level\":\"2\"},"
				+ "{\"value\":\"subitem15\", \"level\":\"2\"}]";//for test
		if( level == 3 )
			res = "[{\"value\":\"child1\", \"level\":\"3\"},"
				+ "{\"value\":\"child2\", \"level\":\"3\"},"
				+ "{\"value\":\"child3\", \"level\":\"3\"},"
				+ "{\"value\":\"child4\", \"level\":\"3\"},"
				+ "{\"value\":\"child5\", \"level\":\"3\"}]";//for test
		
		result.put("message", null);
		result.put("data", res);
		return result;
	}
	
	@RequestMapping(value="/data/banner", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, String> dataBanner( @RequestBody CorpusScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		Map<Object, String> result = new HashMap<Object, String>();
		return result;
	}
	
	@RequestMapping(value="/data/ranklist", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, String> dataRanklist( @RequestBody CorpusScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		Map<Object, String> result = new HashMap<Object, String>();
		return result;
	}
	
	@RequestMapping(value="/data/timeseries", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, String> dataTimeseries( @RequestBody CorpusScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		Map<Object, String> result = new HashMap<Object, String>();
		return result;
	}
	
	@RequestMapping(value="/data/subscribe", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, String> dataSubscribe( @RequestBody CorpusScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		Map<Object, String> result = new HashMap<Object, String>();
		return result;
	}
	
}
