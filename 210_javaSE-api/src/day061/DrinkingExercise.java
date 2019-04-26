package day061;
/**
* 买汽水，1块钱可以买一瓶汽水，2个空瓶可以换一瓶汽水，3个瓶盖可以换一瓶汽水，
* 问：20块钱可以买到多少瓶汽水？
*/
public class DrinkingExercise {
	public static void main(String[] args) {
		int i=1;
		while(Things.drinking>0||Things.cap>2||Things.emptyBottle>1){
			Things.open();
			System.out.println("Open   "+i+": "+"emptyBottle="+Things.emptyBottle+" cap="+Things.cap+" drinking="+Things.drinking+" total="+Things.total);
			Things.change();
			System.out.println("Change "+i+": "+"emptyBottle="+Things.emptyBottle+" cap="+Things.cap+" drinking="+Things.drinking+" total="+Things.total);
			i++;
		}
	}
}
class Things{
	static int cap=0;
	static int emptyBottle=0;
	static int drinking=20;
	static int total=0;
	public static void open(){
		cap+=drinking;
		emptyBottle+=drinking;
		total+=drinking;
		drinking=0;
	}
	public static void change(){
		if(emptyBottle>1){
			drinking+=emptyBottle/2;
			emptyBottle%=2;
		}
		if(cap>2){
			drinking+=cap/3;
			cap%=3;
		}
	}
}