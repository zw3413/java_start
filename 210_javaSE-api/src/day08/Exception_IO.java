package day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 异常在IO操作中的处理方式
 * 
 *请简述：final,finally,finalize的作用 
 * 
 * 
 * @author soft01
 *
 */
public class Exception_IO {
	/**
	 * 当一个对象即将被GC释放前，GC会调用该对象的finalize方法，
	 * 调用后该对象即被释放。
	 * finalize方法是Object定义的方法。
	 * 
	 */
	protected void finalize(){
		System.out.println("finalize excuted.");
	}
	public static void main(String[] args){
		System.out.println("程序开始了");
		FileOutputStream fos=null;
		try{
			fos=new FileOutputStream("fos.txt");
			fos.write("你好".getBytes());
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(fos!=null){
					fos.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		int[] arr = new int[4];
		Exception_IO eio=new Exception_IO();
		eio=null;
		System.gc();
		
		System.out.println("程序结束了");
	}
}
