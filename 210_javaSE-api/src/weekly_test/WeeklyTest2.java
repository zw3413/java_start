package weekly_test;

import java.util.Arrays;

public class WeeklyTest2 {	
	public static void main(String[] arg){
		
		
		ExtendedA.test();
		
		System.out.println("--------------------------");
		String s="";
		System.out.println(s);
		s+=0;
		System.out.println(s);
		
		
		/**
		2.
		(单选)下列代码的运行结果是（D） 
		public static void main(String[] args) { 
		String str = "420"; 
		str += 42; 
		System.out.print(str); 
		}
		 A.42
		 B.420
		 C.462
		D.  42042
		*/
		//D	
		/**String与int之间的数据类型转换*/
		String str="420";
		str+=42;
		System.out.println(str);
		/**总结：输出结果为“42042”，所以这里先将 int型的42强制类型转换为“42”，然后与str拼接。*/
		
		/**
		4.
		(单选)运行下列代码：
		int[] oneArr = { 2, 11, 26, 27, 37, 44, 48, 60 };
		int[] twoArr = { 19, 35, 49, 55, 58, 75, 83, 84, 91, 93 }; 
		int[] threeArr = new int[oneArr.length + twoArr.length]; 
		int p = 0, q = 0; 
		while (p < oneArr.length && q < twoArr.length) {
		threeArr[p + q] =  oneArr[p] < twoArr[q] ? oneArr[p++] : twoArr[q++];
		 } 
		if (p < oneArr.length) { 
		System.arraycopy(oneArr, p, threeArr, p + q, oneArr.length - p); }
		else if (q < twoArr.length) { System.arraycopy(twoArr, q, threeArr, p + q, twoArr.length - q);
		 } System.out.println(Arrays.toString(threeArr));  输出的结果是：（B）。
		 A.[2,11,26,27,37,44,48,60,19,35,49,55,58,75,83,84,91,93];
		 B.[2,11,19,26,27,35,37,44,48,49,55,58,60,75,83,84,91,93];
		 C.[19,35,49,55,58,75,83,84,91,93,2,11,26,27,37,44,48,60];
		 D.[2,19,11,35,26,49,27,55,37,58,44,75,48,83,60,84,91,93];
		*/
		
		/**数组之间的拼接成按顺序排列的数组*/
		int[] oneArr={2,11,26,27,37,44,48,60};
		int[] twoArr={19,35,49,55,58,75,83,84,91,93};
		int[] threeArr=new int[oneArr.length+twoArr.length];
		int p=0,q=0;
		while(p<oneArr.length&&q<twoArr.length){
			threeArr[p+q]=oneArr[p]<twoArr[q]?oneArr[p++]:twoArr[q++];
		}
		if(p<oneArr.length){
			System.arraycopy(oneArr, p, threeArr, p+q, oneArr.length-p);
		}else if(q<twoArr.length){
			System.arraycopy(twoArr, q, threeArr, p+q, twoArr.length-q);
		}
		System.out.println(Arrays.toString(threeArr));
	}
}
/**
1.
(单选)仔细分析下列代码，请指出错误的行（D）。
 public class SomeThing{ 
     private String str;
     public int addOne(final int x){ 
        return ++x; }}
 A.	public class SomeThing
 B.	private String str;
 C.	public int addOne(final int x)
 D.	return ++x;
*/
//D
/** Final 修饰符的用法*/
class SomeThing{
	private String str;
	public int addOne(final int x){
		//return ++x; //编译错误
		return x;
	}
	void test(){
		final int a;
		final int b=5;		
		a=10;
		//b=2;//编译错误，final变量再次赋值。
		//a=1;//编译错误，final变量再次赋值。
	}
/** 总结： final修饰的变量，声明的时候可以留空也可以初始化，如果留空后面还有一次机会进行初始化，一旦初始化，其值不能再改变。*/
	

/**
 * 3.
(单选)下面关于final说法正确的是：（C）。
 A.final修饰类时，该类能被继承。
 B.final修饰方法时，该方法能被重写。
 C.当使用static final 修饰的常量时，将采用编译期绑定的方式。
 D.当使用final和abstract共同修饰一个类时，final应至于abstract之前。//都是修饰词，所以没有前后
final: 
	修饰静态常量 final static
	修饰不可继承类 final class A{}
	修饰不可重写方法 final test()
 */
}


/**
5.
(单选)关于下列代码说法正确的是： D   AAAA
class ClassA { 
	public int numberOfinstances; 
	protected ClassA(int numberOfinstances) {
 		this.numberOfinstances = numberOfinstances; 
	} 
} 
public class ExtendedA extends ClassA {
	private ExtendedA(int numberOfinstances) { 
		super(numberOfinstances); 
	} 
	public static void main(String[] args) { 
		ExtendedA ext = new ExtendedA(420); 
		System.out.print(ext.numberOfinstances); 					                        System.out.print(ext.numberOfinstances); 
	} 
}
 A.运行后，输出420
 B.运行时抛出异常
 C.编译错误，所有的构造器必须是public的
 D.编译错误，构造器不能是private的
*构造函数声明修饰词，构造函数。
*/

class ClassA{
	public int numberOfinstances;
	public ClassA(int numberOfinstances){
		this.numberOfinstances= numberOfinstances;
	}
}
class ExtendedA extends ClassA{
	private ExtendedA(int numberOfinstances) { 
		super(numberOfinstances); 
	} 
	public static void test(){
		ExtendedA ext = new ExtendedA(420); 
		System.out.println(ext.numberOfinstances); 
	}
}














