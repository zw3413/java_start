package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Teacher {
	private String name;
	private int age;
	private List<String> interest;
	private Set<String> city;
	private Map<String,Double> score;
	private Properties db;
	public Teacher() {
		System.out.println("Teacher()");
	}
	public void setDb(Properties db) {
		this.db = db;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public List<String> getInterest() {
		return interest;
	}
	public Set<String> getCity() {
		return city;
	}
	public Map<String, Double> getScore() {
		return score;
	}
	public Properties getDb() {
		return db;
	}
	public void setName(String name) {
		System.out.println("Teacher setName()"+name);
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("Teacher setAge()"+age);
		this.age = age;
	}
	public void setInterest(List<String> interest) {
		this.interest = interest;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", interest=" + interest + ", city=" + city + ", score="
				+ score + ", db=" + db + "]";
	}
	public void setScore(Map<String, Double> score) {
		this.score = score;
	}
	public void setCity(Set<String> city) {
		this.city = city;
	}
}
