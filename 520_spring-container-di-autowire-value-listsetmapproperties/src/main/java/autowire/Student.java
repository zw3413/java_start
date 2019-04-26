package autowire;

public class Student {
	private Computer cp;

	public void setCp(Computer cp) {
		System.out.println("setCp()"+cp);
		this.cp = cp;
	}
	
	public Student() {
		System.out.println("Student()");
	}

	@Override
	public String toString() {
		return "Student [cp=" + cp + "]";
	}
	
}
