package cn.tedu.ttms.product.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.web.JsonResult;
import cn.tedu.ttms.product.service.ProductTypeService;


@Controller
@RequestMapping("/type/")
public class ProductTypeController {
	@Resource
	private ProductTypeService productTypeService;
//	doFindTreeGridNodes.do
	@RequestMapping("doFindTreeGridNodes.do")
	@ResponseBody
	public JsonResult doFindTreeGridNodes() {
		System.out.println("doFindTreeGridNodes()");
		List<Map<String,Object>> list=productTypeService.findTreeGridNodes();
		return new JsonResult(list);
	}
	
	@RequestMapping("listUI")
	public String listUI() {
		System.out.println("listUI()");
		return "product/type_list";
	}
}
