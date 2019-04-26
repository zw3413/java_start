package day06;

public class BinaryTest {
	public static void main(String[] args) {
		for(int i=0;i<50;i++){
		System.out.println(i+" "+ Integer.toBinaryString(i));
		}
		//将2进制缩写为16进制，并且验证缩写的正确性。
		//01110101 11111101 10101111 01011110
		//0x75fdaf5e
		//5+16+32+64 13+16+32+64+128 15+64+32+128 13+16+64
		//21+96 29+96 79+160 29+64
		//117+125+239+93=242+332=574
		//01110101 11111101 10101111 01011110;
	}	
}	
	  /**
     * Places characters representing the integer i into the
     * character array buf. The characters are placed into
     * the buffer backwards starting with the least significant
     * digit at the specified index (exclusive), and working
     * backwards from there.
     *
     * Will fail if i == Integer.MIN_VALUE
     * 
     * 将字符代表整形的i放入字符型数组 buf
     * 字符会被放在缓存的后面，并以最后的符号为开始，
     */
	/*
    static void getChars(int i, int index, char[] buf) {
        int q, r;//局部变量 q r
        int charPos = index; // 局部变量接受参数，用来代表 字符在字符表中的位置。
        char sign = 0; //char型 局部变量sign=0;

        if (i < 0) {  //如果传入的需要转换为字符的整形数字小于0
            sign = '-'; //那么就让char(16)位的sign为字符"-"
            i = -i;// 并且将待转换的整形数i取负号
        }

        // Generate two digits per iteration 每一次遍历生成两位 
        while (i >= 65536) { // 直到i不大于65536
            q = i / 100; // 让q保存取过两位整形之后的数，待下次再取
        // really: r = i - (q * 100);  下面这句话代表了 r实际上存储的是这次取出来的两位十进制整形数
            r = i - ((q << 6) + (q << 5) + (q << 2)); //如上，这里是简化后的算法。
            i = q; //取过数之后，重置原始数，待下次循环
            buf [--charPos] = DigitOnes[r]; //将取出来的两位十进制数给到char型缓存器
            buf [--charPos] = DigitTens[r];
        }

        // Fall thru to fast mode for smaller numbers   当数字不大于65536，开始快速模式来转换
        // assert(i <= 65536, i);  
        for (;;) {  //无线循环
            q = (i * 52429) >>> (16+3);  
            r = i - ((q << 3) + (q << 1));  // r = i-(q*10) ...
            buf [--charPos] = digits [r];
            i = q;
            if (i == 0) break;
        }
        if (sign != 0) {//如果sign不是0的话（表示没有字符）
            buf [--charPos] = sign; //符号位
        }
    }
*/
	

