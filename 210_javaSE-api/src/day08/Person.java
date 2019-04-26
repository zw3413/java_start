package day08;
/**
 * 使用当前类测试异常抛出
 * @author soft01
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}
	/*
	 * 通常当一个方法使用throw抛出一个异常时，就需要再当前方法上使用throws定义该异常的抛出已通知调用者。
	 * 只有runtimeException及其子类异常抛出时可以不定义，否则必须定义。
	 */

	public void setAge(int age) throws IllegalAgeException{
		/*
		 * 当传入的参数不满足业务逻辑要求，比如年龄不再0-100之间的数字
		 * 认为不符合要求时，可以当作异常抛出给调用者
		 */
		if(age<0||age>100){
			throw new IllegalAgeException("年龄不合法");
		}
		this.age = age;
	}
	
}
