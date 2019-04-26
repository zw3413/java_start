package cn.tedu.ttms.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.tedu.ttms.common.exception.ServiceException;
import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.product.dao.ProjectDao;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService{

//	@Resource// 默认先按照id来查找bean,然后按照类型来查找bean
	@Autowired //首先按照类型查找相应bean,假如需要按照id为属性赋值，需要借助@Qualifier注解实现, 采用java反射来将对象注入
//	@Qualifier("projectDao")
	private ProjectDao projectDao;
	@Override
	public List<Project> findObjects() {
		return projectDao.findObjects();
	}

	@Override
	public Map<String,Object> findPageObjects(String name,Integer valid,Integer pageCurrent) {
		//1.验证参数的有效性
		if(pageCurrent==null||pageCurrent<1)
			throw new ServiceException("参数值无效,pageCurrent:"+pageCurrent);
		
		//2.获取当前页数据
		//2.1计算startIndex的值
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		//2.2根据startIndex的值获取当前页数据
		List<Project> list=projectDao.findPageObjects(name,valid,startIndex,pageSize,"createdTime");
		//3.获取总记录数（根据此值计算总页数）
		int rowCount=projectDao.getRowCount(name,valid);
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);//可选
		//4.封装查询和计算结果到map对象
		//1)hashMap底层结构? (数组+链表+红黑树) --->jdk1.8
		//2)hashMap是否线程安全?(不安全，多线程共享）
		//3)hashMap是否能保证有序？（不能，加入希望保证有序性，可以选择LinkedHashMap)
		//4)hashMap在并发场景下面如何应用？（将其转化为同步集合）
		//  	a.Collection.sychronizedMap(m) 加锁 性能不好
		//		b.LinkedHashMap()  性能不好
		// 	c.HashTable()  整张表加锁，性能不好
		//		d.ConcurrentHashMap()  分段加锁技术 性能有所提升 推荐   jdk1.8后采用CAS（无锁化线程安全技术） 强烈推荐
		//LruCache 最近最少使用（缓存淘汰）  算法
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}

	@Override
	public void saveObject(Project entity) {
		//1.验证参数的有效性
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		//2.执行保存操作
		int rows=projectDao.insertObject(entity);
		//3.验证结果
		if(rows<=0) 
			throw new ServiceException("保存失败");
		
	}

	@Override
	public Project findObjectById(Integer id) {
		//1.验证id有效性
		if(id==null||id<1) {
			throw new ServiceException("id的值无效");
		}
		//2.根据id查找数据
		Project project=projectDao.findObjectById(id);
		//3.验证结果是否正确
		if(project==null) {
			throw new ServiceException("此记录已经不存在");
		}
		return project;
	}

	@Override
	public void updateObject(Project entity) {
		if(entity==null) throw new ServiceException("内容不能为空");
		System.out.println("projectServiceImpl.updateObject:"+entity);
		int rows=projectDao.updateObject(entity);
		if(rows<1) throw new ServiceException("修改失败");
	}

	@Override
	public void validById(String ids, Integer valid) {
		System.out.println("projectService.validById()");
		if(StringUtils.isEmpty(ids)) throw new ServiceException("没有选择任何项目");
		if(valid!=1&&valid!=0) throw new ServiceException("参数无效");
		String[] id=ids.split(",");
		System.out.println("id"+id);
		projectDao.validById(id,valid);
	}

}