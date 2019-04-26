package day061;

import java.io.File;
/**
 * 递归调用需要注意，必须要有分支进行判断，不能100%递归，否则是死循环
 * 递归应当尽量避免，递归层数越多内存消耗越大，并且执行速度越慢。
 * 
 * 
 * 
 * 编写方法，将给定的File表示的文件或目录删除
 * @author soft01
 *
 */




public class Test1 {
	public static void main(String[] args) {

		File dir=new File("a");
		deleteFile(dir);
	}

	private static void deleteFile(File dir) {
		
		if(dir.isDirectory()){
			File[] subDirs=dir.listFiles();
			for(File sub:subDirs){
				deleteFile(sub);
			}
		}
		dir.delete();
	}
	

}
