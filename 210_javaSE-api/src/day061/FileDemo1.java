package day061;
/**
 * 
 * java.io.File
 * File用于表示文件系统中的一个文件或目录
 * 通过File可以：
 * 1.访问该文件或目录的属性信息（名字，大小，修改时间）
 * 2.操作文件或目录（创建，删除）
 * 3.访问一个目录的子项
 * 但是不能读取文件数据
 * 
 * 
 * 当前目录值得是，当前项目的根目录
 * 层级分隔符：
 * windows \
 * Linux /
 * JAVA提供的自适应 File.sparator
 * @author soft01
 *
 */
import java.io.File;
import java.util.Date;
public class FileDemo1 {
	public static void main(String[] args) {
		File file=new File("."+File.separator+"demo.txt");
		System.out.println("path:"+file.getPath());
		System.out.println("name:"+file.getName());
		long length=file.length();
		System.out.println("len:"+length);
		long time=file.lastModified();
		System.out.println(time);
		Date d=new Date(time);
		System.out.println(d);
	}
}
