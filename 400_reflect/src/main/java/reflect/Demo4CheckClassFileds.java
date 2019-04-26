package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo4CheckClassFileds {
	
	public static void main(String[] args) {
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("请输入所要动态加载的类名：");
			String className=scan.nextLine();
			try {
				Class cls=Class.forName(className);
				try {
					System.out.println("已通过Class Class.forName()方法动态加载类：");
					System.out.println(cls);
					Object obj=cls.newInstance();
					try {
						System.out.println("已通过Object class.newInstance()方法动态创建class类的对象：");
						System.out.println(obj);
						
						System.out.println("请输入下一步您要做什么：");
						System.out.println("1.查看所有的属性  2.查看所有的方法  3.查看所有的构造器  4.动态方法调用 5.动态属性读取  6.动态属性修改");
						
						int s=0;
						boolean flag=true;
						do {
							try {
								String sStr=scan.nextLine();
								s=Integer.parseInt(sStr);
								flag=false;
							}catch(NumberFormatException e) {
								System.out.println("输入格式有误，请重新输入：");
							}
						}while(flag);

						switch(s){
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								System.out.println("请输入要调用的方法名称：");
								String methodName=scan.nextLine();
								Method method=cls.getDeclaredMethod(methodName);
								System.out.println("通过"+methodName+".invoke(obj)方法调用结果如下：");
								method.invoke(obj);
								System.out.println("动态调用方法结束。");
								break;
							case 5:	
								{System.out.println("请输入要访问的属性名称：");
								String fieldName=scan.nextLine();
								Field field=cls.getDeclaredField(fieldName);
								System.out.println("通过"+fieldName+".get(obg)方法读取属性结果如下：");
								Object value=field.get(obj);
								System.out.println(value);
								break;}
							case 6:	
								modifyField(cls,obj);
								break;
								
							default:
								System.out.println("无此命令索引："+s);
						}
					}catch(NoSuchMethodException e) {
						System.out.println(e);
					}catch(InvocationTargetException e) {
						System.out.println(e);
					}catch(NoSuchFieldException e) {
						System.out.println(e);
					}catch(NumberFormatException e) {
						System.out.println(e);
					}catch(IllegalArgumentException e){
						System.out.println(e);
					}
					
					
				}catch(IllegalAccessException e) {
					System.out.println(e);
				}catch(InstantiationException e) {
					System.out.println(e);
				}finally {
				}
				
			}catch(ClassNotFoundException e) {
				System.out.println(e);
			}finally {
				System.out.println("---------------本次任务结束--------------------------");
			}
		}
	}

	private static void modifyField(Class cls, Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,NumberFormatException {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入要修改的属性名称为：");
		String fieldName=scan.nextLine();
		Field field=cls.getDeclaredField(fieldName);
		Class type=field.getType();
		System.out.println("此属性类型为："+type);
		System.out.println("请输入要将此属性修改为：");
		String valueStr=scan.nextLine();
		
		//根据属性类型转换属性值
		//如果属性信息中的类型是int则转换为int
		//如果属性信息中是String,就不用转换
		Object value=null;
		//type=int.class String.class
		if(type==int.class) {
			
			value=Integer.parseInt(valueStr);
			
		}else if(type==double.class) {
			
			value=Double.parseDouble(valueStr);
			
		}else {
			value=valueStr;
		}
		field.set(obj,value);
		System.out.println("通过"+fieldName+".set(obg)方法修改属性结果如下：");
		System.out.println(fieldName+"="+field.get(obj));
	}
}
