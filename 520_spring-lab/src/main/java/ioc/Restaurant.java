package ioc;

public class Restaurant {
	private Waiter waiter;
	public Restaurant() {
		System.out.println("Restaurant()");
	}
	public void setWaiter(Waiter waiter) {
		System.out.println("Restaurant's setWaiter()"+waiter);
		this.waiter=waiter;
	}
	public void service() {
		System.out.println("Restaurant's service()");
		waiter.service();
	}
	
}
