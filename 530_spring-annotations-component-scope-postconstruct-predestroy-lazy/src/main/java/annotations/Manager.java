package annotations;
//构造器注入

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mg") //组建扫描

public class Manager {
	private Waiter wt;
	
	@Autowired
	public Manager(@Qualifier("wt") Waiter wt) {
		System.out.println("Manager(Waiter)");
		this.wt=wt;
	}
	@Override
	public String toString() {
		return "Manager [wt=" + wt + "]";
	}
	
	
}
