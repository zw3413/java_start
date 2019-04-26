package day08;
/**
 * Exception API
 * 异常的一些方法。
 * @author soft01
 *
 */
public class Exception_API {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try{
			String str="abc";
			System.out.println(Integer.parseInt(str));
		}catch(Exception e){
			/*
			 * 输出错误堆栈信息，有助于定位操作的代码，以便debug
			 */
			e.printStackTrace();
			/*
			 * 获取错误消息，通常是该错误出现的原因
			 */
			String message=e.getMessage();
			System.out.println(message);
		}
		System.out.println("程序结束了");
	}
}
