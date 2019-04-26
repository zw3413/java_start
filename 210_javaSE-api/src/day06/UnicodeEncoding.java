package day06;

import java.io.UnsupportedEncodingException;

public class UnicodeEncoding {
	public static void main(String[] args) throws UnsupportedEncodingException {
		int n='中';

		//encoding
		int b3=0x80|n&0x3f;
		int b2= 0x80|n>>>6&0x3f;
		int b1=0xe0|n>>>12&0xf;
		System.out.println(Integer.toBinaryString(b1));
		
		//the the encoding with the java API
		byte b[]={(byte)b1,(byte)b2,(byte)b3,(byte)b1,(byte)b2,(byte)b3};
		String s=new String(b,"utf-8"); //按照utf-8编码方案，将编码解码为unicode。 
		System.out.println(s);
		
		//decoding
		int cc=(b1&0xf)<<12|(b2&0x3f)<<6|(b3&0x3f);
		char ch=(char)cc;
		System.out.println(ch);

	}
}
