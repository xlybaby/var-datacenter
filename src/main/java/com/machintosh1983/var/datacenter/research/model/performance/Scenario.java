package com.machintosh1983.var.datacenter.research.model.performance;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;
import com.machintosh1983.var.datacenter.research.common.Constant;
import com.machintosh1983.var.datacenter.research.model.UILayout;
import com.machintosh1983.var.datacenter.research.model.User;
import com.machintosh1983.var.datacenter.research.model.recorder.Container;
import com.machintosh1983.var.datacenter.research.model.recorder.Item;
import com.machintosh1983.var.datacenter.research.model.recorder.Iterator;
import com.machintosh1983.var.datacenter.research.model.recorder.Pagination;
import com.machintosh1983.var.datacenter.research.model.recorder.RecordComponent;

/**
 * 
 * @author Machintosh1983
 *
 */
public class Scenario {

	private User user;
	
	private long scenarioId;
	private int scenarioType;
	private String title;
	private Schedule schedule;
	private boolean publish;
	private UILayout layout;
	
	private List<Scene> scenelist;

	private Date createTime;
	private Date lastUpdateTime;
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public long getScenarioId() {
		return scenarioId;
	}

	public void setScenarioId(long scenarioId) {
		this.scenarioId = scenarioId;
	}

	public List<Scene> getScenelist() {
		return scenelist;
	}

	public void setScenelist(List<Scene> scenelist) {
		this.scenelist = scenelist;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getScenarioType() {
		return scenarioType;
	}

	public void setScenarioType(int scenarioType) {
		this.scenarioType = scenarioType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public UILayout getLayout() {
		return layout;
	}

	public void setLayout(UILayout layout) {
		this.layout = layout;
	}
	/*
	public static void main( String[] args ) {
		
		Scenario scenario = new Scenario();
		
		scenario.setScenarioId(341232323);
		scenario.setPublish(false);
		scenario.setScenarioType(Constant.VAR_SCENARIO_TYPE_CORPUSCOLLECT);
		scenario.setTitle("test scenario");
		
		Schedule schedule = new Schedule();
		schedule.setInterval(1);
		schedule.setUnit(TimeUnit.HOURS);
		scenario.setSchedule(schedule);
		
		UILayout layout = new UILayout();
		layout.setContentHeight(100);
		layout.setContentWidth(100);
		layout.setOffsetParentLeft(10);
		layout.setOffsetParentTop(10);
		scenario.setLayout(layout);
		
		User usr = new User();
		usr.setUserId(10001);
		usr.setUserName("test");
		usr.setRoleId(10001);
		scenario.setUser(usr);
		
		List<Scene> scenelist = new ArrayList<Scene>();
		for(int i=0; i<1; i++) {
			Scene scene = new Scene();
			scene.setHref("http://drugs.dxy.cn/index.htm");
			
			List<Page> pages = new ArrayList<Page>();
			for(int j=0; j<1;j++) {
				Page page = new Page();
				//pageComponent.setTaskId(scenario.getScenarioId());
				page.setPageId(scenario.getScenarioId() + "_page" + j);
				
				Pagination pagination = new Pagination();
				Selector pagisel = new Selector();
				pagisel.setTag("a");
				Map<String, String> attrs = new HashMap<String, String>();
				attrs.put("title", "下一页");
				pagisel.setAttributes(attrs);
				Selector pagiprntsel = new Selector();
				pagiprntsel.setClazz("pagination");
				pagiprntsel.setTag("div");
				pagination.setSelector(pagisel);
				pagination.setParent(pagiprntsel);
				page.setPagination(pagination);
				
				List<Actor> actors = new ArrayList<Actor>();
				//Add one actor
				Actor act = new Actor();
				Map<String, Object> actproperties = new HashMap<String, Object>();
				act.setType(Constant.VAR_ACTOR_TYPE_RECORDING);
				Selector selector = new Selector();
				act.setSelector(selector);
				
				
				List<RecordComponent> reccomps = new ArrayList<RecordComponent>();
				RecordComponent recorder = new RecordComponent();
				List<Container> containers = new ArrayList<Container>();
				for(int c=0; c<1; c++) {
					Container container = new Container();
					Selector selcon = new Selector();
					selcon.setName("cate_div");
					container.setSelector(selcon);
					List<Iterator> iterators = new ArrayList<Iterator>();
					for(int it=0; it<1; it++) {
						Iterator iterator = new Iterator();
						Selector itersel = new Selector();
						itersel.setTag("li");
						iterator.setSelector(itersel);
						List<Item> items = new ArrayList<Item>();
						for(int t=0;t<1;t++) {
							Item item = new Item();
							Selector itemsel = new Selector();
							itemsel.setXpath("h3/a");
							item.setLink(true);
							item.setLinkExtract(true);
							item.setIndex(1);
							
							item.setSelector(itemsel);
							items.add(item);
						}
						iterator.setItems(items);
						iterators.add(iterator);
					}
					container.setIterators(iterators);
					containers.add(container);
				}
				
				recorder.setContainers(containers);
				reccomps.add(recorder);
				actproperties.put("pageComponent", reccomps);
				act.setProperties(actproperties);
				actors.add(act);
				//end add one actor
				
				page.setActors(actors);
				pages.add(page);
			}
			
			scene.setPages(pages);
			scenelist.add(scene);
		}
		
		scenario.setScenelist(scenelist);
		System.out.println(JSONObject.toJSONString(scenario));
	}*/
	
	
}
