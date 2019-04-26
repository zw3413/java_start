package day061;

import java.io.File;

/**
 * 编写方法，将给定的File表示的文件或目录删除
 * @author soft01
 *
 */
public class Test {
	public static void main(String[] args) {
		File dir=new File("a");
		deleteFile(dir);		
	}
	private static void deleteFile(File dir) {
		File[] dirs=dir.listFiles();
		System.out.println(dirs+" "+dirs.length);
		long len=dirs.length;
		if(dirs.length>0){
			for(int i=0;i<dirs.length;i++){
				if(dirs[i].isFile()){
					dirs[i].delete();
					System.out.println("Delete file of:"+dirs[i]);
				}
				if(dirs[i].isDirectory()){
					System.out.println("enter:"+dirs[i].getPath());
					deleteFile(dirs[i]);
					dirs=dir.listFiles();
					if(dirs.length<1){
						break;
					}
				}
			}
		}
		if(dirs.length<1){
			dir.delete();
			System.out.println("Delete directory of:"+ dir);
		}
	}
}
