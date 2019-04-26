package day02;
/**
 * JDK1.5之后推出了一个新的特性：
 * 自动拆装箱
 * 该特性是编译器认可，而非虚拟机。
 * 该特新是编译器再编译源代码时补充了基本类型与包装类之间的转换代码。
 * 从而是程序员不用再为两者之间互相转换而编写转换代码。
 * 
 * 自动拆箱
 * 编译器会补充代码到class文件中：
 * int i=new Integer(123).intValue;
 * 
 * 
 * 自动装箱
 * 编译器会补充代码到class文件中：
 * Integer d=Integer.valueOf(i);
 * 
 * @author soft01
 *
 */



public class IntegerDemo3 {

	public static void main(String[] args) {
		int i=new Integer(123);
		Integer d= i;
	}

}
