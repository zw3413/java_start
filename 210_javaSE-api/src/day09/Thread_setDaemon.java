package day09;
/**
 * 
 * @author soft01
 *
 */
public class Thread_setDaemon {
	public static void main(String[] args) {
		Thread jack=new Thread(){
			public void run(){
				while(true){
					System.out.println("Jack:you jump,i jump");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		};
		Thread rose=new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("Rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Rose:ahhhhhh....");
			}
		};
		
		jack.setDaemon(true);
		
		jack.start();
		rose.start();
	}
}
