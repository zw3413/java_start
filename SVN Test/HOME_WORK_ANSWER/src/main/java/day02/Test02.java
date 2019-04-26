package day02;
/**
 * 将字符串123,456,789,012根据","拆分，并输出拆分后的每一项
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		String str = "123,456,789,012";
		String[] arr = str.split(",");
		for(int i =0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
