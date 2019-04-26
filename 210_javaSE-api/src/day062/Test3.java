package day062;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 程序启动后，要求用户输入用户名，密码，年龄以及邮箱
 * 并将这些信息存入到user.dat文件中
 * 
 * 
 * @author soft01
 *
 */
public class Test3 {
	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		System.out.println("Input your name please :");
		String inputName=scan.nextLine().trim();
		System.out.println("Input your password please:");
		String inputPWD=scan.nextLine().trim();
		System.out.println("Input your age please:");
		String inputAge=scan.nextLine().trim();
		System.out.println("Input your e-mail address please:");
		String inputEmailAddress=scan.nextLine().trim();
		
		File file=new File("user.dat");
		if(!file.exists()){
			System.out.println("user.dat file is not exist, now create the file...");
			file.createNewFile();
			if(file.exists()){
				System.out.println("The user.dat has been created successfully");
			}else{
				System.out.println("Some problem happened, failed to create the user.dat.");
			}
		}
		RandomAccessFile raf=new RandomAccessFile("user.dat","rw");
		raf.write(("username="+inputName).getBytes("utf-8"));
		raf.write('\n');
		raf.write(("password="+inputPWD).getBytes("utf-8"));
		raf.write('\n');
		raf.write(("age="+inputAge).getBytes("utf-8"));
		raf.write('\n');
		raf.write(("e-mail="+inputEmailAddress).getBytes("utf-8"));
		raf.write('\n');
		raf.close();
		System.out.println("All informatin were writed to "+file.getPath());
	}
}
