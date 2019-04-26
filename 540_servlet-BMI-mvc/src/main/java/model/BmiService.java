package model;
/*
 * 模型，封装业务逻辑的处理
 */
public class BmiService {
	public String bmi(double height,double weight) {
		String status="正常";
		double bmi=weight/height/height;
		System.out.println(weight);
		System.out.println(height);
		System.out.println(bmi);
		if(bmi<19) {
			status="过轻";
		}
		if(bmi>25) {
			status="过重";
		}
		return status;
	}
}
