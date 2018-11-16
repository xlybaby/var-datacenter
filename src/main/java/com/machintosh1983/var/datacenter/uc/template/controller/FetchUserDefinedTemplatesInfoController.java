package com.machintosh1983.var.datacenter.uc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.machintosh1983.var.datacenter.research.common.Constant;
import com.machintosh1983.var.datacenter.research.common.ErrorCode;
import com.machintosh1983.var.datacenter.research.common.WebApplicationException;
import com.machintosh1983.var.datacenter.research.controller.BaseController;
import com.machintosh1983.var.datacenter.research.model.User;
import com.machintosh1983.var.datacenter.research.model.performance.Template;
import com.machintosh1983.var.datacenter.research.model.performance.TemplateSnapshot;

@RestController
@RequestMapping("/authorized/uc/t")
public class FetchUserDefinedTemplatesInfoController extends BaseController {

	@RequestMapping(value="/snap", method=RequestMethod.GET)
	public List<TemplateSnapshot> snap( HttpServletRequest request ) throws Exception {
		List<TemplateSnapshot> tempSnaps=null;
		
		return tempSnaps;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Template> templates( HttpServletRequest request ) throws Exception {
		List<Template> templates=null;
		
		return templates;
	}
	
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public List<Template> template( HttpServletRequest request ) throws Exception {
		List<Template> templates=null;
		
		return templates;
	}
}
