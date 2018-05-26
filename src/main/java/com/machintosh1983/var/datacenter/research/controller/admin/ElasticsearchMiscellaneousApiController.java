package com.machintosh1983.var.datacenter.research.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.machintosh1983.var.datacenter.service.index.AbstractESIndexService;

@RestController
@RequestMapping("/authorized/es-info")
public class ElasticsearchMiscellaneousApiController {

	@Autowired
	private AbstractESIndexService abstractESIndexService;
	
	@RequestMapping(value="/indices", method=RequestMethod.GET)
	public String submit() throws Exception {
		
		return abstractESIndexService.getAllIndicesInfo();
	}
	
}
