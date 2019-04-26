package mytest;

import java.net.URL;

public class GetResourceTest {

	public static void main(String[] args) {
		
		URL str=GetResourceTest.class.getResource("/mytest");
		System.out.println(str);

	}

}
