package day061;

import java.io.File;

public class File_delete {
	public static void main(String[] args) {
		/*
		 * 删除test.txt文件
		 */
		File file=new File("test.txt");
		if(file.exists()){
			file.delete();
			System.out.println("文件已删除");
		}else{
			System.out.println("文件不存在");
		}
	}
}
