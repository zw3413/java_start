package value;

public class Student2 {
	private String name;
	private String interest;
	private double score;
	private int pageSize;
	
	public Student2() {
		System.out.println("Student()");
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", interest=" + interest + ", score=" + score + ", pageSize=" + pageSize + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
