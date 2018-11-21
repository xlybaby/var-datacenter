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
		String parentId = scenarioQueryVO.getParentId();
		
		String res = null;
		logger.info("Fetch scenario[id: " + scenarioQueryVO.getScenarioId() + "] data");
		if( level == 1 )
			res = "[{\"id\":\"item1\", \"parentId\":\"\", \"value\":\"item1\", \"level\":\"1\"},"
					+ "{\"id\":\"item2\", \"parentId\":\"\", \"value\":\"item2\", \"level\":\"1\"},"
					+ "{\"id\":\"item3\", \"parentId\":\"\", \"value\":\"item3\", \"level\":\"1\"},"
					+ "{\"id\":\"item4\", \"parentId\":\"\", \"value\":\"item4\", \"level\":\"1\"},"
					+ "{\"id\":\"item5\", \"parentId\":\"\", \"value\":\"item5\", \"level\":\"1\"}]";//for test
		
		if( level == 2 ) {
			if(parentId.equals("item1"))
				res =  "[{\"id\":\"subitem1\", \"parentId\":\"item1\", \"value\":\"subitem1\", \"level\":\"2\"},"
						+ "{\"id\":\"subitem2\", \"parentId\":\"item1\", \"value\":\"subitem2\", \"level\":\"2\"},"
						+ "{\"id\":\"subitem3\", \"parentId\":\"item1\", \"value\":\"subitem3\", \"level\":\"2\"},"
						+ "{\"id\":\"subitem4\", \"parentId\":\"item1\", \"value\":\"subitem4\", \"level\":\"2\"},"
						+ "{\"id\":\"subitem5\", \"parentId\":\"item1\", \"value\":\"subitem5\", \"level\":\"2\"}]";//for test
			if(parentId.equals("item2"))
				res = "[{\"id\":\"sublist1\", \"parentId\":\"item2\", \"value\":\"sublist1\", \"level\":\"2\"},"
						+ "{\"id\":\"sublist2\", \"parentId\":\"item2\", \"value\":\"sublist2\", \"level\":\"2\"},"
						+ "{\"id\":\"sublist3\", \"parentId\":\"item2\", \"value\":\"sublist3\", \"level\":\"2\"},"
						+ "{\"id\":\"sublist4\", \"parentId\":\"item2\", \"value\":\"sublist4\", \"level\":\"2\"},"
						+ "{\"id\":\"sublist5\", \"parentId\":\"item2\", \"value\":\"sublist5\", \"level\":\"2\"}]";//for test
			if(parentId.equals("item4"))
				res = "[{\"id\":\"subchild1\", \"parentId\":\"item4\", \"value\":\"subchild1\", \"level\":\"2\"},"
						+ "{\"id\":\"subchild2\", \"parentId\":\"item4\", \"value\":\"subchild2\", \"level\":\"2\"},";
		}
		
		if( level == 3 ) {
			if(parentId.equals("subitem1"))
				res = "[{\"id\":\"subitem1-child1\", \"parentId\":\"subitem1\", \"value\":\"subitem1-child1\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem1-child2\", \"parentId\":\"subitem1\", \"value\":\"subitem1-child2\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem1-child3\", \"parentId\":\"subitem1\", \"value\":\"subitem1-child3\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem1-child4\", \"parentId\":\"subitem1\", \"value\":\"subitem1-child4\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem1-child5\", \"parentId\":\"subitem1\", \"value\":\"subitem1-child5\", \"level\":\"3\"}]";//for test
			if(parentId.equals("subitem3"))
				res = "[{\"id\":\"subitem3-child1\", \"parentId\":\"subitem3\", \"value\":\"subitem3-child1\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem3-child2\", \"parentId\":\"subitem3\", \"value\":\"subitem3-child2\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem3-child3\", \"parentId\":\"subitem3\", \"value\":\"subitem3-child3\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem3-child4\", \"parentId\":\"subitem3\", \"value\":\"subitem3-child4\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem3-child5\", \"parentId\":\"subitem3\", \"value\":\"subitem3-child5\", \"level\":\"3\"}]";//for test
			if(parentId.equals("subitem5"))
				res = "[{\"id\":\"subitem5-child1\", \"parentId\":\"subitem5\", \"value\":\"subitem5-child1\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem5-child2\", \"parentId\":\"subitem5\", \"value\":\"subitem5-child2\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem5-child3\", \"parentId\":\"subitem5\", \"value\":\"subitem5-child3\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem5-child4\", \"parentId\":\"subitem5\", \"value\":\"subitem5-child4\", \"level\":\"3\"},"
						+ "{\"id\":\"subitem5-child5\", \"parentId\":\"subitem5\", \"value\":\"subitem5-child5\", \"level\":\"3\"}]";//for test
			
			if(parentId.equals("sublist2"))
				res = "[{\"id\":\"sublist2-child1\", \"parentId\":\"sublist2\", \"value\":\"sublist2-child1\", \"level\":\"3\"},"
						+ "{\"id\":\"sublist2-child2\", \"parentId\":\"sublist2\", \"value\":\"sublist2-child2\", \"level\":\"3\"},"
						+ "{\"id\":\"sublist2-child3\", \"parentId\":\"sublist2\", \"value\":\"sublist2-child3\", \"level\":\"3\"},"
						+ "{\"id\":\"sublist2-child4\", \"parentId\":\"sublist2\", \"value\":\"sublist2-child4\", \"level\":\"3\"},"
						+ "{\"id\":\"sublist2-child5\", \"parentId\":\"sublist2\", \"value\":\"sublist2-child5\", \"level\":\"3\"}]";//for test
			
			if(parentId.equals("subchild1"))
				res = "[{\"id\":\"subchild1-child1\", \"parentId\":\"subchild1\", \"value\":\"subchild1-child1\", \"level\":\"3\"},"
						+ "{\"id\":\"subchild1-child2\", \"parentId\":\"subchild1\", \"value\":\"subchild1-child2\", \"level\":\"3\"},"
						+ "{\"id\":\"subchild1-child3\", \"parentId\":\"subchild1\", \"value\":\"subchild1-child3\", \"level\":\"3\"},"
						+ "{\"id\":\"subchild1-child4\", \"parentId\":\"subchild1\", \"value\":\"subchild1-child4\", \"level\":\"3\"},"
						+ "{\"id\":\"subchild1-child5\", \"parentId\":\"subchild1\", \"value\":\"subchild1-child5\", \"level\":\"3\"}]";//for test
			
		}
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
