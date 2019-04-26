package json;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	/**
	 * 如何将java对象转换成JSON字符串
	 * @throws JsonProcessingException 
	 */

	public static void test1() throws JsonProcessingException {
		Stock s=new Stock();
		s.setCode("600877");
		s.setName("中国嘉陵");
		s.setPrice(6);
		//使用jackson提供的api来转换
		ObjectMapper om=new ObjectMapper();
		String jsonStr=om.writeValueAsString(s);
		System.out.println(jsonStr);
	}
	
	/**
	 * 将多个java对象组成的集合转换成JSON字符串
	 * @param args
	 * @throws JsonProcessingException
	 */
	public static void test2() throws JsonProcessingException {
		List<Stock> stocks=new ArrayList<Stock>();
		Random r=new Random();
		for(int i=0;i<3;i++) {
			Stock s=new Stock();
			s.setCode("60087"+r.nextInt(10));
			s.setName("中国嘉陵"+r.nextInt(10));
			s.setPrice(r.nextInt(1000));
			stocks.add(s);
		}
		//使用jackson提供的api来转换
		ObjectMapper om=new ObjectMapper();
		String jsonStr=om.writeValueAsString(stocks);
		System.out.println(jsonStr);
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		test2();
	}

}
