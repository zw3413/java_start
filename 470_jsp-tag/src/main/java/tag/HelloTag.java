package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	private String info;
	private int qty;
	public HelloTag() {
		System.out.println("Hello Tag()");
	}
	
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		System.out.println("setInfo()"+info);
		this.info = info;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		System.out.println("setQty()"+qty);
		this.qty = qty;
	}
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag()");
		//通过继承自SimpleTagSupport提供的getJspContext()方法来获得pageContext对象（该对象提供了获得其它多有隐含对象的方法)
		PageContext pc=(PageContext)getJspContext();
		JspWriter out=pc.getOut();
		for(int i=0;i<qty;i++) {
			out.println(info);
		}
	
	}

	
	
}
