package cn.tedu.ttms.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.ttms.product.dao.ProductTypeDAO;
import cn.tedu.ttms.product.service.ProductTypeService;

@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeDAO productTypeDAO;

	@Override
	public List<Map<String, Object>> findTreeGridNodes() {
		
		List list=productTypeDAO.findTreeGridNodes();
		
		return list;
	}

}
