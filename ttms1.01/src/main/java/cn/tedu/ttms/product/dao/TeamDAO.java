package cn.tedu.ttms.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDAO {

	List<Map<String,Object>> findPageObjects(
			@Param("valid") Integer valid,
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize,
			@Param("projectName") String projectName);
	
	Integer getRowCount(
			@Param("projectName") String projectName);

	List<Map<String,Object>> getTeamSort();
}
