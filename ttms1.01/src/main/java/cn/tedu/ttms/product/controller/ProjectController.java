package cn.tedu.ttms.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.web.JsonResult;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProjectService;

@RequestMapping("/project/")//请求资源映射
@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById (String ids,Integer valid) {
		System.out.println("doValidById()");
		projectService.validById(ids,valid);
		
		return new JsonResult();
	}
	
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		System.out.println("doFindObjectById()");
		return new JsonResult(projectService.findObjectById(id));
	}
	
	
	
	
	@RequestMapping("doFindObjects")
	@ResponseBody//spring发现方法由此注解修饰时，底层会启动第三方api将方法返回的数据，转换为JSON格式的字符串
	public List<Project> doFindObjects(){	
		List<Project> list=projectService.findObjects();
		return list;
	}//Spring通过整合第三方API(例如jackson)实现了JSON数据的转换
	/*
	 * 在浏览器中访问http://localhost:8080/ttms1.01/project/doFindPageObjects.do?pageCurrent=1
	 * springMVC会自动将请求中的参数数据按照指定类型，进行类型转换，然后赋值给对应参数
	 * (名字相同的参数，一般是通过反射获取参数信息）
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public Map<String,Object> doFindPageObjects(String name,Integer valid,Integer pageCurrent){
		return projectService.findPageObjects(name,valid,pageCurrent);
	}
	
	@RequestMapping("listUI")
	public String listUI() {
		return "product/project_list";
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject( Project entity) {
		System.out.println("doSaveObject");
		projectService.saveObject(entity);
		//当执行这个数据保存时出现了异常，spring mvc如何处理？
		//1>先检测当前控制层对象内容是否定义了这个异常的处理函数，
		//2>假如定义了就直接调用异常处理函数处理
		//3>假如没有定义要检测是否有全局的异常处理类（@ControllerAdvice）
		//然后在全局异常处理类中查找对应的异常处理函数处理异常
		return new JsonResult();
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(Project entity) {
		System.out.println("doUpdateObject");
		projectService.updateObject(entity);
		return new JsonResult();
	}
	
	@RequestMapping("editUI")
	public String editUI() {
		System.out.println("editUI.do");
		return "product/project_edit";
	}
}
