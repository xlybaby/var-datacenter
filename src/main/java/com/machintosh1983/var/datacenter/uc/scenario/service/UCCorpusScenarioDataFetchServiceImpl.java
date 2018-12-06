package com.machintosh1983.var.datacenter.uc.scenario.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.machintosh1983.var.datacenter.uc.scenario.vo.CorpusScenarioQueryVO;
import com.machintosh1983.var.datacenter.uc.scenario.vo.ScenarioQueryVO;

@Service("ucCorpusScenarioDataFetchService")
public class UCCorpusScenarioDataFetchServiceImpl implements UCScenarioDataFetchService {
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
	
	@Override
	public Object dataRetrieve(ScenarioQueryVO queryVO) {
		Map<Object, String> result = new HashMap<Object, String>();
		CorpusScenarioQueryVO scenarioQueryVO = (CorpusScenarioQueryVO)queryVO;
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
		return jsonstr;
	}

}
