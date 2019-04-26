package day061;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyDemo1 {

		public static void main(String[] args) throws IOException {
			RandomAccessFile src=new RandomAccessFile("typer.zip","r");
			RandomAccessFile desc=new RandomAccessFile("typer_cp.zip","rw");
			
			long startTime=System.currentTimeMillis();
			int d=-1;
			while((d=src.read())!=-1){
				desc.write(d);
			}
			long endTime=System.currentTimeMillis();
			System.out.println("复制完毕，耗时："+(endTime-startTime)+"ms");
			
			src.close();
			desc.close();
		}
}
