package cn.tedu.ttms.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public interface ProductTypeService {
	List<Map<String,Object>> findTreeGridNodes();
}
