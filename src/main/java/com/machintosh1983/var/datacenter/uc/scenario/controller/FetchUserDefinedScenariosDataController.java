package com.machintosh1983.var.datacenter.uc.scenario.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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
	LinkedHashMap<String, LinkedHashMap<String,String>> testdata = null;
	
	{
		testdata = new LinkedHashMap<String, LinkedHashMap<String,String>>();
		
		LinkedHashMap<String,String> ary1 = new LinkedHashMap<String,String>();
		ary1.put("xiaohuadao","消化系统及代谢药");
		ary1.put("xueye","血液和造血系统药物");
		ary1.put("xinxueguan","心血管系统药物");
		ary1.put("pifubing","皮肤病用药");
		testdata.put("root", ary1);
		
		LinkedHashMap<String,String> ary2 = new LinkedHashMap<String,String>();
		ary2.put("kouqiang", "口腔科用药");
		ary2.put("zhitu","止吐药和止恶心药");
		ary2.put("zhixie","止泻药，肠道抗炎/抗感染药");
		ary2.put("changwei","胃肠解痉药，抗胆碱药和胃动力药");
		testdata.put("xiaohuadao", ary2);
		
		LinkedHashMap<String,String> ary3 = new LinkedHashMap<String,String>();
		ary3.put("yaoping11", "盐酸米诺环素胶囊");
		ary3.put("yaoping12", "盐酸米诺环素胶囊");
		ary3.put("yaoping13", "盐酸米诺环素胶囊");
		ary3.put("yaoping14", "盐酸多西环素片");
		ary3.put("yaoping15", "人工牛黄甲硝唑胶囊");
		ary3.put("yaoping16", "氨来呫诺糊剂");
		ary3.put("yaoping17", "注射用盐酸多西环素");
		ary3.put("yaoping18", "双氯芬酸钠喷雾剂");
		ary3.put("yaoping19", "盐酸多西环素片");
		ary3.put("yaoping111", "甲硝唑芬布芬胶囊");
		ary3.put("yaoping112", "人工牛黄甲硝唑胶囊");
		ary3.put("yaoping113", "甲硝唑缓释片");
		ary3.put("yaoping114", "甲硝唑缓释片");
		ary3.put("yaoping115", "甲硝唑缓释片");
		ary3.put("yaoping116", "甲硝唑缓释片");
		ary3.put("yaoping117", "甲硝唑缓释片");
		ary3.put("yaoping118", "人工牛黄甲硝唑胶囊");
		ary3.put("yaoping119", "氨来呫诺糊剂");
		ary3.put("yaoping120", "注射用盐酸多西环素");
		ary3.put("yaoping121", "双氯芬酸钠喷雾剂");
		ary3.put("yaoping122", "盐酸多西环素片");
		ary3.put("yaoping123", "甲硝唑芬布芬胶囊");
		ary3.put("yaoping124", "人工牛黄甲硝唑胶囊");
		ary3.put("yaoping125", "人工牛黄甲硝唑胶囊");
		ary3.put("yaoping126", "氨来呫诺糊剂");
		ary3.put("yaoping127", "注射用盐酸多西环素");
		ary3.put("yaoping128", "双氯芬酸钠喷雾剂");
		ary3.put("yaoping129", "盐酸多西环素片");
		ary3.put("yaoping130", "甲硝唑芬布芬胶囊");
		ary3.put("yaoping131", "人工牛黄甲硝唑胶囊");
		ary3.put("yaoping132", "人工牛黄甲硝唑胶囊");
		ary3.put("yaoping133", "氨来呫诺糊剂");
		ary3.put("yaoping134", "注射用盐酸多西环素");
		ary3.put("yaoping135", "双氯芬酸钠喷雾剂");
		ary3.put("yaoping136", "盐酸多西环素片");
		ary3.put("yaoping137", "甲硝唑芬布芬胶囊");
		ary3.put("yaoping138", "人工牛黄甲硝唑胶囊");
		
		testdata.put("kouqiang", ary3);
	}
	
	@RequestMapping(value="/data/corpus", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, String> dataCorpus( @RequestBody CorpusScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		Map<Object, String> result = new HashMap<Object, String>();
		String parentId = scenarioQueryVO.getParentId();
		int limit = scenarioQueryVO.getLimit();
		int offset = scenarioQueryVO.getOffset();
		
		Map<String,String> res = testdata.get(parentId);
		if( res == null ) res = new HashMap<String,String>();
		String jsonstr = "[";
		int point = 0;
		for(Iterator<String> keys = res.keySet().iterator(); keys.hasNext();) {
			if( point >= offset ) {
				String key = keys.next();
				String value = res.get(key);
				jsonstr += "{\"id\":\""+key+"\",\"value\":\""+value+"\"},";
			}
			point++;
			if( point == (offset+limit))
				break;
		}
		if(jsonstr.endsWith(","))
			jsonstr = jsonstr.substring(0, jsonstr.length()-1);
		jsonstr += "]";
		
		result.put("message", null);
		result.put("data", jsonstr);
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
