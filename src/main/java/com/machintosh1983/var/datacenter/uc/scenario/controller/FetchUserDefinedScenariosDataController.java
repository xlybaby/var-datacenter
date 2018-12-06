package com.machintosh1983.var.datacenter.uc.scenario.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.machintosh1983.var.datacenter.research.common.Constant;
import com.machintosh1983.var.datacenter.research.controller.BaseController;
import com.machintosh1983.var.datacenter.uc.scenario.service.UCScenarioDataFetchService;
import com.machintosh1983.var.datacenter.uc.scenario.vo.BannerScenarioQueryVO;
import com.machintosh1983.var.datacenter.uc.scenario.vo.CorpusScenarioQueryVO;
import com.machintosh1983.var.datacenter.uc.scenario.vo.RanklistScenarioQueryVO;
import com.machintosh1983.var.datacenter.uc.scenario.vo.SubscribeScenarioQueryVO;
import com.machintosh1983.var.datacenter.uc.scenario.vo.TimeseriesScenarioQueryVO;

@RestController
@RequestMapping("/authorized/uc/s")
public class FetchUserDefinedScenariosDataController extends BaseController {
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private UCScenarioDataFetchService ucCorpusScenarioDataFetchService;
	
	@Autowired
	private UCScenarioDataFetchService ucBannerScenarioDataFetchService;
	
	@Autowired
	private UCScenarioDataFetchService ucSubscribeScenarioDataFetchService;
	
	@Autowired
	private UCScenarioDataFetchService ucRanklistScenarioDataFetchService;
	
	@Autowired
	private UCScenarioDataFetchService ucTimeseriesScenarioDataFetchService;
	
	@RequestMapping(value="/data/corpus", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dataCorpus( @RequestBody CorpusScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		
		return response(Constant.APPLICATION_RESPONSE_STATUS_CODE_OK, "", ucCorpusScenarioDataFetchService.dataRetrieve(scenarioQueryVO));
	}
	
	@RequestMapping(value="/data/banner", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dataBanner( @RequestBody BannerScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		
		return response(Constant.APPLICATION_RESPONSE_STATUS_CODE_OK, "", ucBannerScenarioDataFetchService.dataRetrieve(scenarioQueryVO));
	}
	
	@RequestMapping(value="/data/ranklist", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dataRanklist( @RequestBody RanklistScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		
		return response(Constant.APPLICATION_RESPONSE_STATUS_CODE_OK, "", ucRanklistScenarioDataFetchService.dataRetrieve(scenarioQueryVO));
	}
	
	@RequestMapping(value="/data/timeseries", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dataTimeseries( @RequestBody TimeseriesScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		
		return response(Constant.APPLICATION_RESPONSE_STATUS_CODE_OK, "", ucTimeseriesScenarioDataFetchService.dataRetrieve(scenarioQueryVO));
	}
	
	@RequestMapping(value="/data/subscribe", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dataSubscribe( @RequestBody SubscribeScenarioQueryVO scenarioQueryVO, HttpServletRequest request ) throws Exception {
		
		return response(Constant.APPLICATION_RESPONSE_STATUS_CODE_OK, "", ucSubscribeScenarioDataFetchService.dataRetrieve(scenarioQueryVO));
	}
	
}
