package annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("stu")
public class Student {
	@Value("楚乔")//属性 注入值
	private String name;
	private int age;
	private int pageSize;
	public Student() {
		System.out.println("Student()");
	}
	public void setName(String name) {
		this.name = name;
	}
	@Value("22")//setter方法注入值
	public void setAge(int age) {
		this.age = age;
	}
	@Value("#{config.pagesize}")//使用spring语句来使用Value
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", pageSize=" + pageSize + "]";
	}
}
