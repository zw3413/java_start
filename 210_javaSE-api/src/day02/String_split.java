package day02;

import org.junit.Test;
/**
 * 
 * String支持正则表达式方法二：
 * String[] split(String regex)
 * 将当前字符串的内容按照满足正则表达式的部分进行拆分，将拆分后的若干字符串存入一个数组后返回
 * @author soft01
 *
 */
public class String_split {
	public static void main(String[] args) {
		test();
	}
	@Test
	public static void test() {
		
		String str="abc123def456fd";
		
		/**
		 * 若在拆分的过程中发现连续匹配了拆分
		 * 部分，那么会在中间拆出一个空字符串。
		 * 但是若再字符串末尾连续匹配，则所有
		 * 拆分空字符串会被忽略。
		 */
		String[] data=str.split("\\d+");
		for(int i=0;i<data.length;i++){
			System.out.println(data[i]);
		}	
		
		System.out.println(data.length);
	}

}
