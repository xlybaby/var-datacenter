package com.machintosh1983.var.datacenter.service.task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machintosh1983.var.datacenter.research.common.WebApplicationException;
import com.machintosh1983.var.datacenter.research.model.User;
import com.machintosh1983.var.datacenter.research.model.performance.Scenario;
import com.machintosh1983.var.datacenter.service.index.AbstractESIndexService;

@Service("abstractUserCustomTaskService")
public class AbstractUserCustomTaskServiceESImpl extends AbstractUserCustomTaskService {
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private AbstractESIndexService abstractESIndexService;
	
	@Override
	public boolean addTask(Scenario scenario) throws WebApplicationException {
		User user = scenario.getUser();
		if( user == null ) {
			
		}
		UUID uid = UUID.randomUUID();
		scenario.setScenarioId(uid.toString());
		abstractESIndexService.addScenario( "u"+user.getUserId() + AbstractESIndexService.ES_INDEX_USER_BASE, AbstractESIndexService.ES_TYPE_USER_CUSTOM_TASK, uid.toString(), scenario );
		return true;
	}

	@Override
	public boolean updateTask(Scenario scenario) throws WebApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTask(Scenario scenario) throws WebApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Scenario> getUserTasks(User user) throws WebApplicationException {
		long uid = user.getUserId();
		return abstractESIndexService.multiQuery( "u"+uid + AbstractESIndexService.ES_INDEX_USER_BASE, AbstractESIndexService.ES_TYPE_USER_CUSTOM_TASK, null, null, null, Scenario.class);

	}

	@Override
	public List<Scenario> getUserTask(User user, Scenario scenario) throws WebApplicationException {
		String scenarioId = scenario.getScenarioId();
		if ( scenarioId == null ) {
			return getUserTasks(user);
		}
		long uid = user.getUserId();
		List<String> fields = new ArrayList<String>();
		fields.add("scenarioId");
		
		return abstractESIndexService.multiQuery( "u"+uid + AbstractESIndexService.ES_INDEX_USER_BASE, AbstractESIndexService.ES_TYPE_USER_CUSTOM_TASK, null, fields, scenarioId, Scenario.class);
	}

}
