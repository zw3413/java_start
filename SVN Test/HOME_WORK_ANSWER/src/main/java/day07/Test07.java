package day07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 要求用户输入一个文件，该文件应当是Test07程序生成的文件，然后将该文件中所有字符读取
 * 出来，并以UTF-8编码写入到另一个文件中，实现文件转码工作，该文件取名格式:原文件名_utf-8.txt。
 * @author Xiloer
 *
 */
public class Test07 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要转码的文件名:");
		String fileName = scanner.nextLine();
		File file = new File(fileName);
		if(!file.exists()){
			System.out.println(file+"不存在!");
		}else{
			changeCharSet(file,"GBK","UTF-8");

		}
	}
	/**
	 * 将指定文件转码
	 * @param file 要转码的文件
	 * @param srcCSN 文件现编码
	 * @param desCSN 要转换的编码
	 * @throws IOException 
	 */
	public static void changeCharSet(File file,String srcCSN,String desCSN) throws IOException{
		String fileName = file.getName();
		String name = fileName.substring(0, fileName.indexOf("."));
		String postfix = fileName.substring(fileName.indexOf(".")+1);
		BufferedReader br = new BufferedReader(
			new InputStreamReader(
				new FileInputStream(file),srcCSN	
			)	
		);
		PrintWriter pw = new PrintWriter(
			new OutputStreamWriter(
				new FileOutputStream(name+"_"+desCSN+"."+postfix),desCSN	
			)	
		);
		String line = null;
		while((line = br.readLine())!=null){
			pw.println(line);
		}
		System.out.println("转码完毕!");
		br.close();
		pw.close();
	}
}
