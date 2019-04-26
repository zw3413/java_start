package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		OutputStream out=response.getOutputStream();
		
		BufferedImage image=new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, 80, 20);
		Random r=new Random();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.setFont(new Font(null,Font.ITALIC,20));
		String number=getCode(5);
		//将number绑定到session中
		HttpSession session=request.getSession();
		session.setAttribute("number", number);
		
		g.drawString(number,5,19);
		for(int i=0;i<8;i++) {
			g.drawLine(r.nextInt(80),r.nextInt(30),r.nextInt(80),r.nextInt(30));
		}
		response.setContentType("image/jpeg;charset=utf-8");
		javax.imageio.ImageIO.write(image,"jpeg",out);
		out.close();
		}

	private String getCode(int size) {
		String number="";
		String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random r=new Random();
		for(int i=0;i<size;i++) {
			number+=chars.charAt(r.nextInt(chars.length()));
		}
		return number;
	}



}
