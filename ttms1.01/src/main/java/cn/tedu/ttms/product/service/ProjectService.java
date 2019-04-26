package cn.tedu.ttms.product.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.product.entity.Project;

/**
 * 业务层接口对象（负责业务的处理）
 * 1）业务逻辑的验证
 * 2）事务的处理
 * 3）日志的处理
 * 4）缓存的处理
 * 5）权限的处理
 * 6）...
 * @author soft01
 */
public interface ProjectService {
	/**
	 * 保存项目信息
	 * @return
	 */
	void saveObject(Project project);
	List<Project> findObjects();
	/**
	 * @param pageCurrent 当前页吗的值
	 * @return 返回当前页面数据以及分页信息
	 */
	Map<String, Object> findPageObjects(String name,Integer valid,Integer pageCurrent);
	Project findObjectById(Integer id);
	void updateObject(Project entity);
	void validById(String ids, Integer valid);
}
