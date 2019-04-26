package cn.tedu.ttms.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.ttms.common.exception.ServiceException;
import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.product.dao.TeamDAO;
import cn.tedu.ttms.product.service.TeamService;

@Service("teamService")
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamDAO teamDAO;

	@Override
	public Map<String, Object> findPageObjects(
			Integer valid, 
			String projectName, 
			Integer pageCurrent) {
		if(valid!=null) { 
			if(valid!=0&&valid!=1) throw new ServiceException("状态参数异常");
		}
		if(pageCurrent==null||pageCurrent<0) throw new ServiceException("当前页参数异常");
		
		int pageSize=2;
		int rowCount=teamDAO.getRowCount(projectName);
		int startIndex=pageSize*(pageCurrent-1);
		List<Map<String,Object>> list=teamDAO.findPageObjects(
				valid, startIndex,pageSize, projectName);
		
		PageObject pageObject=new PageObject();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setStartIndex(startIndex);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		
		return map;
	}

}
