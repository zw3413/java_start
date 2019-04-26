package dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import entity.Employee;
import entity.Employee2;

/*
 * DAO接口
 */
public interface EmpDAO {
	public void save(Employee e);
	public List<Employee> findAll();
	public Employee	findById(int id);
	public void update(Employee e);
	public void delete(int id);
	public Map findById2(int id);
	public Employee2 findById3(int id);
}
