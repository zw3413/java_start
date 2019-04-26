package controller;

public class Body {
	private double height;
	private double weight;
	public double getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = Double.parseDouble(height);
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = Double.parseDouble(weight);
	}
}
