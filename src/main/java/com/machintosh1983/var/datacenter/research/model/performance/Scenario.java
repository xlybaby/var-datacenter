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
	
	private String scenarioId;
	private int scenarioType;
	private String title;
	private Schedule schedule;
	private int publish;
	private int automation;
	private UILayout layout;
	
	private int maxDuration=5*60;
	private int maxThreadNum=3;
	
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

	public String getScenarioId() {
		return scenarioId;
	}

	public void setScenarioId(String scenarioId) {
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

	public String getScenarioTypeName() {
		
		switch (this.scenarioType) {
		case Constant.VAR_SCENARIO_TYPE_TIMESERIES:
			return "TIMESERIES";
		case Constant.VAR_SCENARIO_TYPE_REFRESHBLOCK:
			return "REFRESHBLOCK";
		case Constant.VAR_SCENARIO_TYPE_RANKLIST:
			return "RANKLIST";
		case Constant.VAR_SCENARIO_TYPE_CORPUSCOLLECT:
			return "CORPUSCOLLECT";
		case Constant.VAR_SCENARIO_TYPE_BANNER:
			return "BANNER";
			
		default: return "UNKNOWN";
		}
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

	public int isPublish() {
		return publish;
	}

	public void setPublish(int publish) {
		this.publish = publish;
	}

	public UILayout getLayout() {
		return layout;
	}

	public void setLayout(UILayout layout) {
		this.layout = layout;
	}
	
	public int getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	public int getMaxThreadNum() {
		return maxThreadNum;
	}

	public void setMaxThreadNum(int maxThreadNum) {
		this.maxThreadNum = maxThreadNum;
	}
	
	
	public int getAutomation() {
		return automation;
	}

	public void setAutomation(int automation) {
		this.automation = automation;
	}


	public static void main( String[] args ) {
		
		Scenario scenario = new Scenario();
		
		scenario.setScenarioId("0d3e3b36-10a8-46c3-88cb-1e4b00136a6f");
		scenario.setPublish(0);
		scenario.setScenarioType(Constant.VAR_SCENARIO_TYPE_CORPUSCOLLECT);
		scenario.setTitle("test scenario");
		
		Schedule schedule = new Schedule();
		schedule.setInterval(3);
		schedule.setUnit(TimeUnit.SECONDS);
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
			for(int j=0; j<2;j++) {
				if(j==1 ) {
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
						//selcon.setName("cate_div");
						selcon.setClazz("common_main");
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
								itemsel.setTag("a");;
								item.setLink(1);
								item.setExtract(1);
								
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
				if( j==0 ) {
				Page page = new Page();
				//pageComponent.setTaskId(scenario.getScenarioId());
				page.setPageId(scenario.getScenarioId() + "_page" + j);
				
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
							itemsel.setTag("a");;
							item.setLink(1);
							item.setExtract(1);
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
			
			}
			scene.setPages(pages);
			scenelist.add(scene);

		}
		
		scenario.setScenelist(scenelist);
		System.out.println(JSONObject.toJSONString(scenario));
	}

	/**
public static void main( String[] args ) {

		
		Scenario scenario = new Scenario();
		
		scenario.setPublish(0);
		scenario.setScenarioType(Constant.VAR_SCENARIO_TYPE_TIMESERIES);
		scenario.setTitle("test scenario");
		scenario.setAutomation(1);
		
//		Schedule schedule = new Schedule();
//		schedule.setInterval(3);
//		schedule.setUnit(TimeUnit.SECONDS);
//		scenario.setSchedule(schedule);
		
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
			scene.setHref("https://www.cngold.org/crude/shanghai.html");
			scene.setDelay(3);
			List<Page> pages = new ArrayList<Page>();
			
					Page page = new Page();
					//pageComponent.setTaskId(scenario.getScenarioId());
					//page.setPageId(scenario.getScenarioId() + "_page0");
					
					List<Actor> actors = new ArrayList<Actor>();
					//Add one actor
					Actor act = new Actor();
					Map<String, Object> actproperties = new HashMap<String, Object>();
					act.setType(Constant.VAR_ACTOR_TYPE_ELEMENT);
					Selector selector = new Selector();
					act.setSelector(selector);
					
					
					List<Map<String, Map<String,Map<String, Selector>>>> kvmappings = new ArrayList<Map<String, Map<String,Map<String, Selector>>>>();
					for(int mm=0;mm<4;mm++) {
						Map<String, Map<String,Map<String, Selector>>> mapping = new HashMap<String, Map<String,Map<String, Selector>>>();
						Map<String,Map<String, Selector>> kv = new HashMap<String,Map<String, Selector>>();
						Selector ksel = new Selector();
						ksel.setXpath("/html/body/div[5]/div[1]/div[1]/div[3]/table/thead/tr/th["+(mm+1)+"]");
						Map<String, Selector> mksel = new HashMap<String, Selector>();
						mksel.put("selector", ksel);
						
						Selector vsel = new Selector();
						vsel.setXpath("/html/body/div[5]/div[1]/div[1]/div[3]/table/tbody/tr/td["+(mm+1)+"]");
						Map<String, Selector> mvsel = new HashMap<String, Selector>();
						mvsel.put("selector", vsel);
						
						kv.put("fieldsel", mksel);
						kv.put("datasel", mvsel);
						mapping.put("mapping", kv);
						
						kvmappings.add(mapping);
					}
					actproperties.put("kv-mappings", kvmappings);
					act.setProperties(actproperties);
					actors.add(act);
					//end add one actor
					
					page.setActors(actors);
					pages.add(page);
				
			scene.setPages(pages);
			scenelist.add(scene);
		}
		
		scenario.setScenelist(scenelist);
		System.out.println(JSONObject.toJSONString(scenario));
	}
	*/
/**
public static void main( String[] args ) {
		
		Scenario scenario = new Scenario();
		
		scenario.setScenarioId("0d3e3b36-10a8-46c3-88cb-1e4b00136a6f");
		scenario.setPublish(0);
		scenario.setAutomation(1);
		scenario.setScenarioType(Constant.VAR_SCENARIO_TYPE_TIMESERIES);
		scenario.setTitle("test timeseries scenario");
		
//		Schedule schedule = new Schedule();
//		schedule.setInterval(3);
//		schedule.setUnit(TimeUnit.SECONDS);
//		scenario.setSchedule(schedule);
		
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
			scene.setHref("http://quote.eastmoney.com/f1.html?code=000005&market=2");
			scene.setDelay(5);
			List<Page> pages = new ArrayList<Page>();
			for(int j=0; j<1;j++) {
				Page page = new Page();
				
				List<Actor> actors = new ArrayList<Actor>();
				//Add one actor
				Actor act = new Actor();
				Map<String, Object> actproperties = new HashMap<String, Object>();
				act.setType(Constant.VAR_ACTOR_TYPE_RECORDINGKV);
				Selector selector = new Selector();
				act.setSelector(selector);
				
				Map<String, Object> kvvmapping = new HashMap<String, Object>();
				Map<String, Object> kvv = new HashMap<String, Object>();
				kvvmapping.put("kvv-mapping", kvv);
				
				Map<String, Object> key = new HashMap<String, Object>();
				key.put("label", "day_rate");
				key.put("value", "日成交价");
				kvv.put("key", key);
				
				Map<String, Object> values = new HashMap<String, Object>();
				kvv.put("values", values);
				
				Map<String, Object> val_rate = new HashMap<String, Object>();
				Map<String, Object> val_timepoint = new HashMap<String, Object>();
				values.put("rate", val_rate);
				values.put("timepoint", val_timepoint);
				
				List<Container> val_rate_component = new ArrayList<Container>();
				List<Container> val_timepoint_component = new ArrayList<Container>();

				val_rate.put("label", "rate");
				val_rate.put("components", val_rate_component);
				val_rate.put("type", "number");
				
				val_timepoint.put("label", "timepoint");
				val_timepoint.put("components", val_timepoint_component);
				val_timepoint.put("type", "date");
				
				for(int c=0; c<4; c++) {
					Container container = new Container();
					Selector selcon = new Selector();
					selcon.setXpath("//*[@id=\"listTable"+(c+1)+"\"]/tbody");
					container.setSelector(selcon);
					List<Iterator> iterators = new ArrayList<Iterator>();
					for(int it=0; it<1; it++) {
						Iterator iterator = new Iterator();
						Selector itersel = new Selector();
						itersel.setXpath("tr");;
						iterator.setSelector(itersel);
						List<Item> items = new ArrayList<Item>();
						for(int t=0;t<1;t++) {
							Item item = new Item();
							Selector itemsel = new Selector();
							itemsel.setXpath("td[2]");							
							item.setSelector(itemsel);
							items.add(item);
						}
						iterator.setItems(items);
						iterators.add(iterator);
					}
					container.setIterators(iterators);
					
					val_rate_component.add(container);
					
				}
				
				for(int c=0; c<4; c++) {
					Container container = new Container();
					Selector selcon = new Selector();
					selcon.setXpath("//*[@id=\"listTable"+(c+1)+"\"]/tbody");;
					container.setSelector(selcon);
					List<Iterator> iterators = new ArrayList<Iterator>();
					for(int it=0; it<1; it++) {
						Iterator iterator = new Iterator();
						Selector itersel = new Selector();
						itersel.setXpath("tr");;
						iterator.setSelector(itersel);
						List<Item> items = new ArrayList<Item>();
						for(int t=0;t<1;t++) {
							Item item = new Item();
							Selector itemsel = new Selector();
							itemsel.setXpath("td[1]");							
							item.setSelector(itemsel);
							items.add(item);
						}
						iterator.setItems(items);
						iterators.add(iterator);
					}
					container.setIterators(iterators);
					
					val_timepoint_component.add(container);
					
				}
				
				Map<String, Object> timepoint = new HashMap<String, Object>();
				timepoint.put("format", "HH:mi:ss");
				actproperties.put("pageComponent", kvvmapping);
				actproperties.put("timepoint", timepoint);

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
	}
*/
	
//	public static void main( String[] args ) {
//		
//		Scenario scenario = new Scenario();
//		
//		scenario.setScenarioId("0d3e3b36-10a8-46c3-88cb-1e4b00136a6f");
//		scenario.setPublish(0);
//		scenario.setAutomation(1);
//		scenario.setScenarioType(Constant.VAR_SCENARIO_TYPE_RANKLIST);
//		scenario.setTitle("test ranker scenario");
//		
////		Schedule schedule = new Schedule();
////		schedule.setInterval(3);
////		schedule.setUnit(TimeUnit.SECONDS);
////		scenario.setSchedule(schedule);
//		
//		UILayout layout = new UILayout();
//		layout.setContentHeight(100);
//		layout.setContentWidth(100);
//		layout.setOffsetParentLeft(10);
//		layout.setOffsetParentTop(10);
//		scenario.setLayout(layout);
//		
//		User usr = new User();
//		usr.setUserId(10001);
//		usr.setUserName("test");
//		usr.setRoleId(10001);
//		scenario.setUser(usr);
//		
//		List<Scene> scenelist = new ArrayList<Scene>();
//		for(int i=0; i<1; i++) {
//			/*
//			Scene scene = new Scene();
//			//scene.setDelay(5);
//			scene.setHref("http://www.cmbc.com.cn/channelApp/finance/financial.jsp");
//			
//			List<Page> pages = new ArrayList<Page>();
//			for(int j=0; j<1;j++) {
//					Page page = new Page();
//					
////					Pagination pagination = new Pagination();
////					Selector pagisel = new Selector();
////					pagisel.setTag("a");
////					Map<String, String> attrs = new HashMap<String, String>();
////					attrs.put("title", "下一页");
////					pagisel.setAttributes(attrs);
////					Selector pagiprntsel = new Selector();
////					pagiprntsel.setClazz("pagination");
////					pagiprntsel.setTag("div");
////					pagination.setSelector(pagisel);
////					pagination.setParent(pagiprntsel);
////					page.setPagination(pagination);
//					
//					List<Actor> actors = new ArrayList<Actor>();
//					//Add one actor
//					Actor act = new Actor();
//					Map<String, Object> actproperties = new HashMap<String, Object>();
//					act.setType(Constant.VAR_ACTOR_TYPE_RECORDING);
//					Selector selector = new Selector();
//					act.setSelector(selector);
//					
//					
//					List<RecordComponent> reccomps = new ArrayList<RecordComponent>();
//					RecordComponent recorder = new RecordComponent();
//					List<Container> containers = new ArrayList<Container>();
//					for(int c=0; c<1; c++) {
//						Container container = new Container();
//						Selector selcon = new Selector();
//						selcon.setXpath("//*[@id=\"tableSingle\"]/tbody");
//						container.setSelector(selcon);
//						List<Iterator> iterators = new ArrayList<Iterator>();
//						for(int it=0; it<1; it++) {
//							Iterator iterator = new Iterator();
//							Selector itersel = new Selector();
//							//itersel.setTag("li");
//							itersel.setXpath("tr");
//							iterator.setSelector(itersel);
//							List<Item> items = new ArrayList<Item>();
//							for(int t=0;t<3;t++) {
//								Item item = new Item();
//								if(t==0) {
//									Selector itemsel = new Selector();
//									//itemsel.setTag("a");
//									itemsel.setXpath("td[1]/a");
//									item.setLabel("y-axis-label");
//									
//									item.setSelector(itemsel);
//								}
//								if(t==1) {
//									Selector itemsel = new Selector();
//									itemsel.setXpath("td[4]");
//									item.setLabel("x-axis-value");
//
//									item.setSelector(itemsel);
//								}
//								if(t==2) {
//									Selector itemsel = new Selector();
//									itemsel.setXpath("td[1]/a");
//									item.setLabel("item-external-link");
//									item.setValueattr("href");
//									item.setSelector(itemsel);
//								}
//								items.add(item);
//							}
//							iterator.setItems(items);
//							iterators.add(iterator);
//						}
//						container.setIterators(iterators);
//						containers.add(container);
//						
//					}
//					
//					recorder.setContainers(containers);
//					reccomps.add(recorder);
//					actproperties.put("pageComponent", reccomps);
//					act.setProperties(actproperties);
//					actors.add(act);
//					//end add one actor
//					
//					page.setActors(actors);
//					pages.add(page);
//				
//				
//			
//			}
//			scene.setPages(pages);
//			scenelist.add(scene);
//			*/
//			/*
//			Scene scene = new Scene();
//			//scene.setDelay(5);
//			scene.setHref("http://finance.ccb.com/cn/finance/product.html");
//			
//			List<Page> pages = new ArrayList<Page>();
//			for(int j=0; j<1;j++) {
//					Page page = new Page();
//					
////					Pagination pagination = new Pagination();
////					Selector pagisel = new Selector();
////					pagisel.setTag("a");
////					Map<String, String> attrs = new HashMap<String, String>();
////					attrs.put("title", "下一页");
////					pagisel.setAttributes(attrs);
////					Selector pagiprntsel = new Selector();
////					pagiprntsel.setClazz("pagination");
////					pagiprntsel.setTag("div");
////					pagination.setSelector(pagisel);
////					pagination.setParent(pagiprntsel);
////					page.setPagination(pagination);
//					
//					List<Actor> actors = new ArrayList<Actor>();
//					//Add one actor
//					Actor act = new Actor();
//					Map<String, Object> actproperties = new HashMap<String, Object>();
//					act.setType(Constant.VAR_ACTOR_TYPE_RECORDING);
//					Selector selector = new Selector();
//					act.setSelector(selector);
//					
//					
//					List<RecordComponent> reccomps = new ArrayList<RecordComponent>();
//					RecordComponent recorder = new RecordComponent();
//					List<Container> containers = new ArrayList<Container>();
//					for(int c=0; c<1; c++) {
//						Container container = new Container();
//						Selector selcon = new Selector();
//						selcon.setXpath("//*[@id=\"list1\"]/table/tbody");
//						container.setSelector(selcon);
//						List<Iterator> iterators = new ArrayList<Iterator>();
//						for(int it=0; it<1; it++) {
//							Iterator iterator = new Iterator();
//							Selector itersel = new Selector();
//							//itersel.setTag("li");
//							itersel.setXpath("tr");
//							iterator.setSelector(itersel);
//							List<Item> items = new ArrayList<Item>();
//							for(int t=0;t<3;t++) {
//								Item item = new Item();
//								if(t==0) {
//									Selector itemsel = new Selector();
//									//itemsel.setTag("a");
//									itemsel.setXpath("td[1]/div/div/a");
//									item.setLabel("y-axis-label");
//									
//									item.setSelector(itemsel);
//								}
//								if(t==1) {
//									Selector itemsel = new Selector();
//									itemsel.setXpath("td[5]");
//									item.setLabel("x-axis-value");
//
//									item.setSelector(itemsel);
//								}
//								if(t==2) {
//									Selector itemsel = new Selector();
//									itemsel.setXpath("td[1]/div/div/a");
//									item.setLabel("item-external-link");
//									//item.setValueattr("href");
//									item.setLink(1);
//									item.setSelector(itemsel);
//								}
//								items.add(item);
//							}
//							iterator.setItems(items);
//							iterators.add(iterator);
//						}
//						container.setIterators(iterators);
//						containers.add(container);
//						
//					}
//					
//					recorder.setContainers(containers);
//					reccomps.add(recorder);
//					actproperties.put("pageComponent", reccomps);
//					act.setProperties(actproperties);
//					actors.add(act);
//					//end add one actor
//					
//					page.setActors(actors);
//					pages.add(page);
//				
//				
//			
//			}
//			scene.setPages(pages);
//			scenelist.add(scene);
//			*/
//			Scene scene = new Scene();
//			//scene.setDelay(5);
//			scene.setHref("https://bank.pingan.com.cn/m/aum/finance/finance-prolist/index.html");
//			
//			List<Page> pages = new ArrayList<Page>();
//			for(int j=0; j<1;j++) {
//					Page page = new Page();
//					
////					Pagination pagination = new Pagination();
////					Selector pagisel = new Selector();
////					pagisel.setTag("a");
////					Map<String, String> attrs = new HashMap<String, String>();
////					attrs.put("title", "下一页");
////					pagisel.setAttributes(attrs);
////					Selector pagiprntsel = new Selector();
////					pagiprntsel.setClazz("pagination");
////					pagiprntsel.setTag("div");
////					pagination.setSelector(pagisel);
////					pagination.setParent(pagiprntsel);
////					page.setPagination(pagination);
//					
//					List<Actor> actors = new ArrayList<Actor>();
//					//Add one actor
//					Actor act = new Actor();
//					Map<String, Object> actproperties = new HashMap<String, Object>();
//					act.setType(Constant.VAR_ACTOR_TYPE_RECORDING);
//					Selector selector = new Selector();
//					act.setSelector(selector);
//
//					List<RecordComponent> reccomps = new ArrayList<RecordComponent>();
//					RecordComponent recorder = new RecordComponent();
//					List<Container> containers = new ArrayList<Container>();
//					for(int c=0; c<1; c++) {
//						Container container = new Container();
//						Selector selcon = new Selector();
//						selcon.setXpath("//table[@class=\"product-list\"]/tbody");
//						container.setSelector(selcon);
//						List<Iterator> iterators = new ArrayList<Iterator>();
//						for(int it=0; it<1; it++) {
//							Iterator iterator = new Iterator();
//							Selector itersel = new Selector();
//							//itersel.setTag("li");
//							itersel.setXpath("tr");
//							iterator.setSelector(itersel);
//							List<Item> items = new ArrayList<Item>();
//							for(int t=0;t<3;t++) {
//								Item item = new Item();
//								if(t==0) {
//									Selector itemsel = new Selector();
//									//itemsel.setTag("a");
//									itemsel.setXpath("td[4]/h6");
//									item.setLabel("y-axis-label");
//									
//									item.setSelector(itemsel);
//								}
//								if(t==1) {
//									Selector itemsel = new Selector();
//									itemsel.setXpath("td[1]/h6");
//									item.setLabel("x-axis-value");
//
//									item.setSelector(itemsel);
//								}
//								if(t==2) {
//									Selector itemsel = new Selector();
//									itemsel.setXpath("td[6]/a");
//									item.setLabel("item-external-link");
//									//item.setValueattr("href");
//									item.setLink(1);
//									item.setSelector(itemsel);
//								}
//								items.add(item);
//							}
//							iterator.setItems(items);
//							iterators.add(iterator);
//						}
//						container.setIterators(iterators);
//						containers.add(container);
//						
//					}
//					
//					recorder.setContainers(containers);
//					reccomps.add(recorder);
//					actproperties.put("pageComponent", reccomps);
//					act.setProperties(actproperties);
//					actors.add(act);
//					//end add one actor
//					
//					page.setActors(actors);
//					pages.add(page);
//				
//				
//			
//			}
//			scene.setPages(pages);
//			scenelist.add(scene);
//		}
//		
//		scenario.setScenelist(scenelist);
//		System.out.println(JSONObject.toJSONString(scenario));
//	}
	
/*
public static void main( String[] args ) {
		
		Scenario scenario = new Scenario();
		
		scenario.setScenarioId("0d3e3b36-10a8-46c3-88cb-1e4b00136a6f");
		scenario.setPublish(0);
		//scenario.setAutomation(1);
		scenario.setScenarioType(Constant.VAR_SCENARIO_TYPE_REFRESHBLOCK);
		scenario.setTitle("test subscriber scenario");
		
		Schedule schedule = new Schedule();
		schedule.setInterval(1);
		schedule.setUnit(TimeUnit.MINUTES);
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
			scene.setHref("http://www.zuanke8.com/forum-2-1.html");
			//scene.setDelay(5);
			List<Page> pages = new ArrayList<Page>();
			for(int j=0; j<1;j++) {
				Page page = new Page();
				
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
					selcon.setXpath("//table[@id=\"threadlisttableid\"]");
					container.setSelector(selcon);
					List<Iterator> iterators = new ArrayList<Iterator>();
					for(int it=0; it<1; it++) {
						Iterator iterator = new Iterator();
						Selector itersel = new Selector();
						itersel.setXpath("tbody");;
						iterator.setSelector(itersel);
						List<Item> items = new ArrayList<Item>();
						for(int t=0;t<2;t++) {
							if(t==0) {
								Item item = new Item();
								Selector itemsel = new Selector();
								itemsel.setXpath("tr[1]/th[1]/a[1]");
								item.setLabel("hash-item");
								item.setSelector(itemsel);
								items.add(item);
							}
							if(t==1) {
								Item item = new Item();
								Selector itemsel = new Selector();
								itemsel.setXpath("tr[1]/th[1]/a[1]");
								item.setLabel("extract-link");
								item.setLink(1);
	
								item.setSelector(itemsel);
								items.add(item);
							}
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
	}
*/
	
}
