package day07;

import java.io.Serializable;
import java.util.List;


/**
 * 使用该类的实例测试作为对象来进行对象流的读写
 * @author soft01
 *
 */
public class Person implements Serializable{
	/**
	 * 当一个类实现了serializable接口后，应当再当强类中添加一个常量：
	 * 序列化版本号serialVersionUID
	 * 
	 * 序列化版本号若不指定，那么编译器会再编译后的class文件中默认添加一个，而值是根据当前类结构生成。
	 * 但是这有一个问题，若当前类的结构发生了变化，那么这个版本号会发生变化。
	 * 所以建议自行指定版本号。
	 * 
	 * 版本号影响对象反序列化的结果：
	 * 当对象输入流读取一个对象并尝试进行反序列化时，会检查该对象的版本号与其所属类现有版本号是否一致，
	 * 一致则反序列话成功，不一致则反序列话失败。
	 * 版本号一致的情况下，若待反序列化的对象与当前类现有结构不一致时，则采用兼容模式，即：该对象的属性现有类依然有的则还原，没有的则被忽略。
	 * 
	 * 
	 * transient 关键字
	 * 该关键字用来修饰属性，那么当该对象进行序列化时，这个属性的值会被忽略。
	 * 从而达到对象“瘦身”的效果
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;//版本号直接影响对象是否能够反序列化成功,反序列化之前会首先检查类的版本号是否与待转对象版本号相同
	private String name;
	private int age;
	private transient List otherInfo;
	private String gender;
	public Person(){
		
	}
	public Person(String name, int age, String gender, List otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherInfo = otherInfo;
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
	public List getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(List otherInfo) {
		this.otherInfo = otherInfo;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", otherInfo=" + otherInfo + "]";
	}
	
}
