package beans.product;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProductTypeService;
import cn.tedu.ttms.product.service.ProjectService;
import cn.tedu.ttms.product.service.TeamService;

import org.junit.Assert;

public class TestProjectService {

	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-mybatis.xml");
	}
	
	@Test
	public void testFindObjects() {
		//1.获取业务对象
		ProjectService projectService=ctx.getBean("projectService",ProjectService.class);
		//2.调用业务对象方法
		List<Project> list=projectService.findObjects();
		//3.测试结果是否正确
		Assert.assertNotSame(null,list);
		//当前表中数据总计有3条，检测数据是否都取到了
		Assert.assertEquals(3, list.size());
		System.out.println(list);
	}
	
	@Test
	public void testFindPageObjects() {
		ProjectService projectService=ctx.getBean("projectService",ProjectService.class);
		Map map=projectService.findPageObjects("环球",1,1);
		List list=(List) map.get("list");
		PageObject page=(PageObject)map.get("pageObject");
		System.out.println(map);
		System.out.println(page);
	}
	
	@Test
	public void testSaveObject() {
		ProjectService projectService=ctx.getBean("projectService",ProjectService.class);
		Project p=new Project();
		p.setName("东欧游");
		p.setCode("tt-20171116-CN-BJ-001");
		p.setBeginDate(new Date());
		p.setEndDate(new Date());
		p.setValid(1);
		p.setNote("东欧游...");
		projectService.saveObject(p);
		System.out.println("insert ok.");
	}
	
	@Test
	public void testFindObjectById() {
		ProjectService projectService=ctx.getBean("projectService",ProjectService.class);
		Project p=projectService.findObjectById(10);
		System.out.println("findObjectById:"+p);
	}
	
	@Test 
	public void testTeamFindObjects() {
		TeamService teamService=ctx.getBean("teamService",TeamService.class);
		Map map=teamService.findPageObjects(null, null, 1);
		System.out.println("map:"+map);
	}
	
	@Test
	public void testFindTreeGridNodes() {
		ProductTypeService productTypeService=ctx.getBean("productTypeService",ProductTypeService.class);
		List list=productTypeService.findTreeGridNodes();
		System.out.println(list);
	}
	@After
	public void destory() {
		ctx.close();
	}
	
}
