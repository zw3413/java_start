package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		/*
		 * 绘图
		 */
		//创建内存映像对象(画布）
		BufferedImage image=new BufferedImage (80,30,BufferedImage.TYPE_INT_RGB);
		//获得画笔
		Graphics g=image.getGraphics();
		//给笔设置颜色
		g.setColor(new Color(255,255,255));
		//用笔给画布设置颜色
		g.fillRect(0,0,80,30);
		//重新给笔设置一个新的颜色
		Random r=new Random();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		//设置字体（字体类型，风格，大小）
		g.setFont(new Font(null,Font.ITALIC,24));
		//绘图(number)
		String number=getCode(5);
		
		//将随机数绑定到session对象上，
		session.setAttribute("number", number);
		
		
		g.drawString(number, 5, 25);
		//加一些干扰线
		for(int i=0;i<8;i++) {
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
		}
		/*
		 *将图片压缩，然后输出 (发送给浏览器)
		 */
		//设置MIME类型（告诉浏览器，服务器返回的是图片）
		response.setContentType("image/jpeg");
		//输出图片，应该使用字节输出流
		OutputStream os=response.getOutputStream();
		//压缩图片并输出
		javax.imageio.ImageIO.write(image, "jpeg", os);
		os.close();
		
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
