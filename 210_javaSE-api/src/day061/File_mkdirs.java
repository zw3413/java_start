package day061;

import java.io.File;

public class File_mkdirs {
	public static void main(String[] args) {
		/*
		 * 在当前目录下创建目录：a/b/c/d/e/f
		 */
		File dirs=new File("./a/b/c/d/e/f");
		if(!dirs.exists()){
			dirs.mkdirs();
			System.out.println("目录已创建");
		}else{
			System.out.println("目录已存在");
		}
	}
}
