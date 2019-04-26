package day061;
/**
 * 
 * 编写一段代码，完成1+2+3+4+...+100 
 * 并输出结果。
 * 再这段代码中不得出现for,while关键字
 * 
 * @author soft01
 *
 */
public class Exercise {
	public static void main(String[] args) {
		int d=100;
		System.out.println(addTo(100));
		
	}
	
	static int addTo(int i){
		int tTotal=i;
		if(i>0){
			tTotal+=addTo(i-1);
		}
		return tTotal;
	}
}
