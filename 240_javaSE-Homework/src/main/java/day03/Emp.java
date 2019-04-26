package day03;
/**
 * 定义私有属性:
 * String name;
 * int age;
 * String gender;
 * int salary;
 * Date hiredate;//入职时间
 * 
 * 定义构造方法，以及属性get,set方法.
 * 定义toString方法，格式如:
 *    姓名:张三,年龄:25,性别:男,薪资:5000,入职时间:2006-02-15
 * 
 * 定义equals方法，要求只要名字相同，则认为内容一致。
 * @author Xiloer
 *
 */
import java.util.Date;
import java.text.SimpleDateFormat;
public class Emp {
	
	
	private String name;
	private int age;
	private String gender;
	private int salary;
	private Date hiredate;
	
	public Emp(){
		
	}
	public Emp(String name, int age, String gender, int salary, Date hiredte) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getHiredte() {
		return hiredate;
	}
	public void setHiredte(Date hiredte) {
		this.hiredate = hiredte;
	}
	public String toString(){
		//张三,年龄:25,性别:男,薪资:5000,入职时间:2006-02-15
		String format="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		String dateStr=sdf.format(hiredate);
		return name+","+"年龄："+age+","+"性别："+gender+",薪资："+salary+",入职时间："+dateStr;
	}
	public boolean equals(String name){
		//定义equals方法，要求只要名字相同，则认为内容一致。
		if(this.name==name){
			return true;
		}
		return false;
		
	}
	
}
