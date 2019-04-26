package basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FileOperator {
	
	/**
	 * //1.获取待处理文件路径
	 * 	//2.分析文件系统结构
	 * //3.获取目标存储目录路径
	 * //4.遍历所有mp3文件，以新的文件名存储到目标存储路径
	 * @param args
	 * @throws IOException
	 */
	private  File basePath;
	public  Map<File,String> map =new HashMap<File,String>();
	private File newPath;

	public static void main(String[] args) throws IOException {
		
		FileOperator sorter=new FileOperator();
		sorter.setSourcePath();
		sorter.analysisSourcePath();
		sorter.info();
		sorter.setNewPath();
		sorter.creatNewFiles();
		
	}
	
	public void setNewPath() {
		Scanner scan=new Scanner(System.in);
		System.out.println("输入目标路径：");
		String path=scan.nextLine();
		newPath=new File(path);
		if(!newPath.exists()) {
			
			return;
		}
		throw new RuntimeException("文件路径已经存在");
	}

	public void creatNewFiles() {
		
		newPath.mkdirs();
		int count=0;
		for(Entry<File,String> e: map.entrySet()) {
			//获取map中待新建的文件。
			File file=e.getKey();
			//根据新路经及待新建文件信息 生成新的文件
			this.generateNewFile(newPath,file);
			count++;
		}
		System.out.println("creatNewFiles:公创建"+count+"个新文件。");
	}

	private void generateNewFile(File newPath, File file) {
		String newPathStr=newPath.toString();
		String fileStr=file.toString();
		String newFileStr=newPathStr+"/"+fileStr.substring(fileStr.lastIndexOf(" ")+1);
		System.out.println(newFileStr);
		File newFile=new File(newFileStr);
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			newFile.createNewFile();
			fis=new FileInputStream(file);
			fos=new FileOutputStream(newFile);
			BufferedInputStream bis=new BufferedInputStream(fis);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			int b=bis.read();
			while(b!=-1){
				bos.write(b);
				b=bis.read();
		}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null) {
					fis.close();
				}
				if(fos!=null) {
					fos.flush();
					fos.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	//用于显示存放统计到的存放在map中的文件信息.
	public void info() {
		int totalLength=0;
		for(Entry<File,String> e: map.entrySet()) {
			System.out.println(e.getKey().length()/1000000+"MB--"+e);
			totalLength+=e.getKey().length();
		}
		System.out.println("total number:"+map.size());
		System.out.println("total size:"+totalLength/1000000+"MB");
	}

	public void analysisSourcePath() {
		resolveSubfiles(basePath);
	}
	/**
	 * 1.遍历路径中的文件
	 * 2.统计文件数量
	 * TODO 3.安装文件列表map <fileName,filePath>
	 * @param sourceFile
	 */
	private void resolveSubfiles(File sourceFile) {
		//取当前路径的下级目录情况
		File[] subFiles=sourceFile.listFiles();
		//如果下级路径为空，则记录当前路径
		if(subFiles==null) {
			//此文件夹已无子文件夹,则将此文件夹添加到列表中，返回.
			//System.out.println("resoulveSubfiles:"+sourceFile);
			map.put(sourceFile,null);
			return;
		}
		//如果还有子文件夹
		for(File f:subFiles) {
			resolveSubfiles(f);
		}
	}
	/**
	 *1. 接受用户输入的路径
	 *2.检查文件是否存在
	 *3.将有效文件路径保存到属性 sourcePath 中
	 */
	public void setSourcePath() {
		System.out.println("输入待处理的文件目录:");
		Scanner scan=new Scanner(System.in);
		String path=scan.nextLine();
		File file = new File(path);
		if(file.exists()) {
			//文件存在
			this.basePath=file;
			return;
		}
		//文件不存在
		throw new RuntimeException("文件路径不存在");
	}
}


