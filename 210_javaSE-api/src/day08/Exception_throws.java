package day08;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 子类重写父类含有throws声明异常抛出的方法时的规则
 * @author soft01
 */
public class Exception_throws {
	
public void dosome1() throws IOException,AWTException{
	}
public void dosome2() throws IOException,AWTException{
}
public void dosome3() throws IOException,AWTException{
}
public void dosome4() throws IOException,AWTException{
}
public void dosome5() throws IOException,AWTException{
}
}
class Son extends Exception_throws{
	
	/*
	 * 1.允许不再抛出任何异常
	 * 2.允许仅抛出部分异常
	 * 3.允许抛出父类异常的子异常
	 * 4.不允许抛出其他不相关异常
	 * 5.不允许抛出父类异常的父异常
	 * 
	 * (non-Javadoc)
	 * @see day08.Exception_throws#dosome()
	 */
	public void dosome1(){
		
	}
	public void dosome2() throws IOException{
		
	}
	public void dosome3() throws FileNotFoundException{
		
	}
	/*
	public void dosome4() throws SQLException{
		
	}
	public void dosome5() throws Exception{
		
	}*/
	
}