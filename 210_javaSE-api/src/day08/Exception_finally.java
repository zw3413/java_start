package day08;
/**
 * 异常捕获机制中的finally块:
 * finally块只能定义在异常捕获机制的最后，即：try之后或者最后一个catch之后。
 * finally块可以保证无论try语句块中的代码是否抛出异常，finally块中的代码都必将执行。
 * 所以通常会将无关乎异常都要指定的代码放入finally块中确保执行，比如IO操作中的关闭流操作。
 * @author soft01
 */
public class Exception_finally {
public static void main(String[] args) {
	System.out.println("程序开始了");
	
	try {
		String str=null;
		System.out.println(str.length());
		return;
	} catch (Exception e) {
		System.out.println("出错了");
	}finally{
		System.out.println("finally 执行了");
	}
	System.out.println("程序结束了");
}
}
