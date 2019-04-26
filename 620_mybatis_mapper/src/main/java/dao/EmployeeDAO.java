package dao;

import java.util.List;

import entity.Employee;

/*
 * Mapper映射器
 *  即符合影射文件要求的接口
 */
public interface EmployeeDAO {
	public void save(Employee e);
	public List<Employee> findAll();
	public Employee	findById(int id);
	public void update(Employee e);
	public void delete(int id);
}
