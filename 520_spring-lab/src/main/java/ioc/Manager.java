package ioc;

public class Manager {
	private Waiter waiter;
	public Manager(Waiter waiter) {
		System.out.println("Manager()"+waiter);
		this.waiter=waiter;
	}
	public void action() {
		System.out.println("Manager's action()");
		waiter.service();
	}
}
