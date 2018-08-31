package com.machintosh1983.var.datacenter.service.task;

import java.util.List;

import com.machintosh1983.var.datacenter.research.common.WebApplicationException;
import com.machintosh1983.var.datacenter.research.model.User;
import com.machintosh1983.var.datacenter.research.model.performance.Scenario;

public abstract class AbstractUserCustomTaskService {

	public abstract boolean addTask( Scenario scenario ) throws WebApplicationException ;
	
	public abstract boolean addTasks( User user, List<Scenario> scenarios ) throws WebApplicationException ;
	
	public abstract boolean addTask(String indice, String type, Scenario scenario) throws WebApplicationException ;
	
	public abstract boolean updateTask( Scenario scenario ) throws WebApplicationException ;
	
	public abstract boolean removeTask( Scenario scenario ) throws WebApplicationException ;
	
	public abstract List<Scenario> getUserTasks( User user ) throws WebApplicationException ;
	
	public abstract List<Scenario> getUserTask( User user, Scenario Scenario ) throws WebApplicationException ;
	
}
