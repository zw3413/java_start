package cn.tedu.ttms.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.product.entity.Project;

/**
 * 持久层对象：负责数据的持久化操作
 */
public interface ProjectDao {
	
	int insertObject(Project entity);
	/**
	 * 从数据库查询所有数据（项目信息）
	 * 1）一行记录封装为一个project对象
	 * 2）多行记录对应的多个project对象再封装到list集合
	 */
	List<Project> findObjects();
	/**
	 * 定义分页查询函数
	 * @param startIndex 对应limit语句中offset,表示从哪个
	 * @param pageSize 每页最多显示多少条记录
	 * 
	 * @Param 是MyBatis中的一个用于定义参数的注解，
	 * 一般在dao方法中的参数个数多于一个时，建议使用此注解进行声明。
	 * 
	 * @return 表示当前页数据
	 * 
	 * @return
	 */
	/*
	 * 如果不适用@Param标注参数，则myBatis会抛出绑定异常，是在mybatis映射文件中通过#或$去取startIndex的值时，
	 * 没有找到这个参数，没有找到这个参数，找到的是[0，1，param1,param2].
	 */
	List<Project> findPageObjects(
			@Param("name") String name,
			@Param("valid") Integer valid,
			@Param("startIndex") int startIndex, 
			@Param("pageSize") int pageSize,
			@Param("orderBy") String orderBy);
	
	/**
	 * 获取记录的总行数,我们根据这个结果计算总页数
	 */
	int getRowCount(@Param("name") String name,@Param("valid") Integer valid);
	
	Project findObjectById(@Param("id") Integer id);
	int updateObject(Project entity);
	void validById(@Param("ids") String[] ids,@Param("valid") Integer valid);

}
