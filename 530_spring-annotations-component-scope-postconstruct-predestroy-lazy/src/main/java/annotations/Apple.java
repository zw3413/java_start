package annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("a1")
@Scope("singleton")
@Lazy(true)
public class Apple {
	
	
	public Apple() {
		System.out.println("Apple()");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init()");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("destroy()");
	}
	
}
