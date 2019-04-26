package ioc;

public class Phone {
	private Cpu cpu;

	public Phone(Cpu cpu) {
		System.out.println("Phone()"+cpu);
		this.cpu = cpu;
	}
	
	@Override
	public String toString() {
		return "Phone [cup=" + cpu + "]";
	}
}
