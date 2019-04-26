package cn.tedu.ttms.product.dao;

import java.util.List;
import java.util.Map;

public interface ProductTypeDAO {
/**查询所有分类及这些分类的夫类信息（只要获取父类名称即可）
 * 说明：此模块不做分页查询
 * */
	List<Map<String,Object>> findTreeGridNodes();
	
}
