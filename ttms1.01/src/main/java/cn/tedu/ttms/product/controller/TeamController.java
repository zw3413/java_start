package cn.tedu.ttms.product.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.web.JsonResult;
import cn.tedu.ttms.product.service.TeamService;


@Controller
@RequestMapping("/team/")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@RequestMapping("listUI")
	public String doListUI() {
		System.out.println("TeamController.doListUI()");
		return "product/team_list";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
			Integer valid,String projectName,Integer pageCurrent) {
		Map map=teamService.findPageObjects(valid, projectName, pageCurrent);
		return new JsonResult(map);
	}
	
}
