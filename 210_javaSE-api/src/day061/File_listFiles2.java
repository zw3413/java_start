package day061;
/**
 * File提供了一个重载的listFiles方法，允许传入一个过滤器，
 * 该方法只会将File表示的目录中满足该过滤器要求的子项返回。
 * 
 * 
 * @author soft01
 *
 */
import java.io.File;
import java.io.FileFilter;
public class File_listFiles2 {
	public static void main(String[] args) {
		File file=new File(".");
		File[] sub=file.listFiles(new FileFilter(){
			@Override
			public boolean accept(File pathname) {	
				
				return pathname.getName().endsWith(".txt");
			
			}
		});
		for(File f:sub){
			System.out.println(f.getName());
		}
	}
}
