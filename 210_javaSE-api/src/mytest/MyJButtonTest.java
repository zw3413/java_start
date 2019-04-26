package mytest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyJButtonTest {

	public static void main(String[] args) {
		JFrame frame=new JFrame();
		
		JPanel pan = new JPanel();
		pan.setLayout(null);
		frame.setBounds(0, 0, 500, 500);

		JLabel s = new JLabel("i");
		s.setBounds(0,0,800,700);
		pan.add(s);

		JButton tishi1;
		tishi1 = new JButton("查询成绩");
		tishi1.setBounds(122,55,12,13);
		pan.add(tishi1);

		frame.setContentPane(pan);
		frame.setVisible(true);
	}
}
