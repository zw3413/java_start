package day09;

public class ThreadDemo4 {

	public static void main(String[] args) {
		
		Thread t1=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("我要查水表啊。");
				}
			}
		};
		t1.start();
		
		
		Runnable r2=new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("你是干嘛的？");
				}
			}
			
		};
		Thread t2=new Thread(r2);
		t2.start();
	}
}

