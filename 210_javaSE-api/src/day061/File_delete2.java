package day061;

import java.io.File;

public class File_delete2 {
	public static void main(String[] args) {
		/*
		 * 删除当前目录下的demo目录
		 * 
		 * 使用File的delete方法删除目录时要求该目录必须是一个空目录
		 * 
		 */
		File file=new File("a");
		if(file.exists()){
			file.delete();
			System.out.println("目录已删除");
		}else{
			System.out.println("目录不存在");
		}
	}
}
