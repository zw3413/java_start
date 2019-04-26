package day06;

import java.io.UnsupportedEncodingException;

public class EncodingTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		/*
		 * UTF-8： 	0x63
		 * 			0110 0011	
		 * Unicode:	0010 0011
		 * 			32+3=35
		 * 4*16+3=64+3=67
		 */
		
		int c='C';
		System.out.println(c);
		System.out.println((int)c);
		System.out.println(Integer.toBinaryString(c));
		byte[] b= encodingFromCharUTF8(c);
		for(int i=0;i<b.length;i++){
			System.out.println(Integer.toBinaryString(b[i]));
		}
		
		String str=new String(b,"utf-8");
		System.out.println(str);
		
	}
	
	public static byte[] encodingFromCharUTF8(int c){
		
		//0~63  1byte 6bit编码
		if(c<64){
			byte[] b=new byte[1];
			b[0]=(byte)(0x80|c&0x3f);
			return b;
		}
		//64~2047 2byte 6+5=11bit编码
		if(c>=64&&c<2048){
			byte[] b=new byte[2];
			b[1]=(byte)(0x80|c&0x3f);
			b[0]=(byte)(0xc0|c>>>6&0x3f);
			return b;
		}
		//2048~65535   3byte 6+6+4=16bit编码
		if(c>=2048&&c<65536){
			byte[] b=new byte[3];
			b[2]=(byte)(0x80|c&0x3f);
			b[1]=(byte)(0x80|c>>>6&0x3f);
			b[0]=(byte)(0xe0|c>>>12&0xf);
			return b;
		}	
		return new byte[0];
	}
	
	public static char decodingUTF8(byte[] b){
		char c = 0;
		
		return c;
	}
}
