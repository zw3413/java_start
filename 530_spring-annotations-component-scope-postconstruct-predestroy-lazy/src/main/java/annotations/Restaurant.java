package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//setter方法和属性注入

@Component("rest")
public class Restaurant {
	
	@Autowired
	@Qualifier("wt")
	private Waiter wt;
	
//	@Autowired
//	public void setWt(@Qualifier("wt") Waiter wt) {
//		System.out.println("setWt"+wt);
//		this .wt=wt;
//	}
	public Restaurant() {
		System.out.println("Restaurant()");
	}
	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
}
