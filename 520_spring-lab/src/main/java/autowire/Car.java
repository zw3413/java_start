package autowire;

public class Car {
	private Enginee enginee;
	public Car() {
		System.out.println("Car()");
	}
	public void setEnginee(Enginee enginee) {
		System.out.println("Car's setEnginee()"+enginee);
		this.enginee=enginee;
	}
	@Override
	public String toString() {
		return "Car [enginee=" + enginee + "]";
	}
}
