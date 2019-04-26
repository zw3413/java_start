package annotations;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("ld")
public class Leader {
	@Resource(name="wt")
	private Waiter wt;
	public Leader() {
		System.out.println("Leader()");
	}
//	@Resource(name="wt")
	public void setWt(Waiter wt) {
		System.out.println("setWt(Waiter)");
		this.wt=wt;
	}
	@Override
	public String toString() {
		return "Leader [wt=" + wt + "]";
	}
	
}
