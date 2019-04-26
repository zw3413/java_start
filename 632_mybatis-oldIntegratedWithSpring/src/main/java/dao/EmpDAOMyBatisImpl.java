package dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import entity.Employee;
import entity.Employee2;

@Repository("empDAO")
public class EmpDAOMyBatisImpl implements EmpDAO{

	@Autowired
	@Qualifier("sst")
	private SqlSessionTemplate sst;
	
	public void save(Employee e) {
		sst.insert("dao.EmployeeDAO.save",e);
	}
	public List<Employee> findAll() {
		return sst.selectList("dao.EmployeeDAO.findAll");
	}
	public Employee findById(int id) {
		return sst.selectOne("dao.EmployeeDAO",id);
	}
	public void update(Employee e) {
		sst.update("dao.EmployeeDAO.update",e);
	}
	public void delete(int id) {
		sst.delete("dao.EmployeeDAO.delete",id);
	}
	public Map findById2(int id) {
		return sst.selectMap("dao.EmployeeDAO.findById2", String.valueOf(id));
	}
	public Employee2 findById3(int id) {
		return sst.selectOne("dao.EmployeeDAO.findById3",id);
	}

}
