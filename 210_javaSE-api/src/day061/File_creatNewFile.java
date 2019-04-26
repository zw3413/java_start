package day061;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个新文件
 * 
 */
public class File_creatNewFile {
	public static void main(String[] args) throws IOException {
		/*
		 * 在当前目录下创建文件：test.txt
		 * 
		 */
		File file= new File("test.txt");
		if(!file.exists()){
			file.createNewFile();
			System.out.println("文件已创建");
		}else{
			System.out.println("该文件已存在");
		}
		
		//canRead();
		//canWrite();
		//isHidden();
		
	}
}
