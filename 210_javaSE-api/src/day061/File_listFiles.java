package day061;
/**
 * 使用File获取一个目录的所有子项
 * @author soft01
 */
import java.io.File;
public class File_listFiles {
	public static void main(String[] args) {
		/*
		 * 获取当前目录的子项
		 */
		File dir=new File(".");
		/*
		 * 判断File表示的是文件还是目录
		 * boolean isFile()
		 * boolean isDirectory()
		 */
		if(dir.isDirectory()){
			File[] subFiles= dir.listFiles();
			for(File f:subFiles){
				if(f.isDirectory()){
					System.out.print("目录：");
				}
				if(f.isFile()){
					System.out.print("文件：");
				}
				System.out.println(f.getName());
			}
		}
	}
}
