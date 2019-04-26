package day02;
/**
 * 将字符串123,456,789,012根据","拆分，并输出拆分后的每一项
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {

		String str="123,456,789,012";
		String regex=",";
		String[] str1=str.split(regex);
		for(int i=0;i<str1.length;i++){
			System.out.println(str1[i]);
		}
	}
}
