package cn.tedu.ttms.product.service;

import java.util.Map;

import org.springframework.stereotype.Service;

public interface TeamService {
	Map<String,Object> findPageObjects(
			Integer valid,
			String projectName,
			Integer pageCurrent);

	
}
