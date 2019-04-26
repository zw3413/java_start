import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Date;

public class Game extends JFrame {
	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(478, 361, 164, 51));
			jButton1.setText("重新开始");
			jButton1.setVisible(false);
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jButton1.setVisible(false);
					jLabel.setVisible(false);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO 自动生成 catch 块
							e1.printStackTrace();
						}
					reset();

				}
			});
		}
		return jButton1;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
		game.reset();
		game.gogo();
	}

	public void reset() {
		kup = false;
		kdown = false;
		kleft = false;
		kright = false;
		int chushihua = 0;
		while (chushihua < zidanshu) {
			((JButton) buttonal.get(chushihua)).setBounds(new Rectangle(-50,
					-50, 10, 10));
			chushihua++;
		}
		gamexunhuan = true;
		jButton.setIcon(new ImageIcon(fileLoc));
		jButton.setLocation(320, 320);
		p = jButton.getLocation();
		x=p.getX();
		y=p.getY();
		firsttime=new Date().getTime();
	}

	public void start() {
		int chushihua = 0;
		while (chushihua < zidanshu) {
			JButton jb = new JButton();
			jb.setBounds(new Rectangle(-50, -50, 10, 10));
			jb.setEnabled(false);
			Threads ths = new Threads(jb);
			Thread th = new Thread(ths);
			buttonal.add(jb);
			threadal.add(th);
			chushihua++;
		}
		Game.Move move = new Move();
		Thread tm = new Thread(move);
		tm.start();
	}

	public void gogo() {
		int chushihua = 0;
		while (chushihua < zidanshu) {
			((Thread) threadal.get(chushihua)).start();
			chushihua++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}
		}
	}

	// private static Game game;
	private long firsttime;
	private long lasttime;
	private static final long serialVersionUID = 1L;

	private JPanel jPanel = null;

	private JButton jButton = null;

	private boolean kup ;

	private boolean kdown ;

	private boolean kleft ;

	private boolean kright ;

	// 定义玩家的行走步伐，数值越大，移动速度越快
	private int step = 3;

	Point p; // @jve:decl-index=0:

	double x = 0.0;

	double y = 0.0;

	// 定义了子弹的个数
	int zidanshu = 70;

	// 定义子弹初始值，这个是不变的
	// int chushihua = 0;
	// 定义控制子弹行走的循环false就不走了
	private boolean gamexunhuan = true;

	private JLabel jLabel = null;

	private JButton jButton1 = null;

	private ArrayList buttonal = new ArrayList();

	private ArrayList threadal = new ArrayList();
	URLClassLoader urlLoader = (URLClassLoader)this.getClass().getClassLoader();
	URL fileLoc = urlLoader.findResource("MyGameIcons/gwl1.gif");  //  @jve:decl-index=0:
	URL fileLoc1 = urlLoader.findResource("MyGameIcons/gwls1.gif");

	/**
	 * This is the default constructor
	 */
	public Game() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(700, 700);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(1);
			}
		});
		this.setResizable(false);
		this.setContentPane(getJPanel());
		this.setTitle("范传奇的小游戏！(模拟撑过30秒的小DEMO)");
		this.setVisible(true);
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(42, -33, 595, 308));
			jLabel.setFont(new Font("Dialog", Font.BOLD, 24));
			jLabel.setForeground(new Color(250, 2, 2));
			jLabel.setEnabled(true);
			jLabel.setVisible(false);
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJButton(), null);
			jPanel.setForeground(new Color(1, 1, 1));
			jPanel.setBackground(new Color(1, 1, 1));
			jPanel.setVisible(true);
			jPanel.add(jLabel, null);
			jPanel.add(getJButton1(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	class Move implements Runnable {
		public void run() {
			while(true){
				while (gamexunhuan) {
					p = jButton.getLocation();
					if (kup) {
						if (kleft) {
							x = p.getX();
							y = p.getY();
							if (x > 0 && y > 0) {
								jButton.setLocation((int) x - step, (int) y
										- step);
							}
						} else if (kright) {
							x = p.getX();
							y = p.getY();
							if (x + 40 < 700 && y > 0) {
								jButton.setLocation((int) x + step, (int) y
										- step);
							}
						} else {
							x = p.getX();
							y = p.getY();
							if (y > 0) {
								jButton.setLocation((int) x, (int) y - step);
							}
						}
					}
					if (kdown) {
						if (kleft) {
							x = p.getX();
							y = p.getY();
							if (y + 60 < 700 && x > 0) {
								jButton.setLocation((int) x - step, (int) y
										+ step);
							}
						} else if (kright) {
							x = p.getX();
							y = p.getY();
							if (x + 40 < 700 && y + 60 < 700) {
								jButton.setLocation((int) x + step, (int) y
										+ step);
							}
						} else {
							x = p.getX();
							y = p.getY();
							if (y + 60 < 700) {
								jButton.setLocation((int) x, (int) y + step);
							}
						}
					}
					if (kleft) {
						if (kup) {
							x = p.getX();
							y = p.getY();
							if (x > 0 && y > 0) {
								jButton.setLocation((int) x - step, (int) y
										- step);
							}
						} else if (kdown) {
							x = p.getX();
							y = p.getY();
							if (y + 60 < 700 && x > 0) {
								jButton.setLocation((int) x - step, (int) y
										+ step);
							}
						} else {
							x = p.getX();
							y = p.getY();
							if (x > 0) {
								jButton.setLocation((int) x - step, (int) y);
							}
						}
					}
					if (kright) {
						if (kup) {
							x = p.getX();
							y = p.getY();
							if (x + 40 < 700 && y > 0) {
								jButton.setLocation((int) x + step, (int) y
										- step);
							}
						} else if (kdown) {
							x = p.getX();
							y = p.getY();
							if (x + 40 < 700 && y + 60 < 700) {
								jButton.setLocation((int) x + step, (int) y
										+ step);
							}
						} else {
							x = p.getX();
							y = p.getY();
							if (x + 40 < 700) {
								jButton.setLocation((int) x + step, (int) y);
							}
						}
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO 自动生成 catch 块
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO 自动生成 catch 块
					e.printStackTrace();
				}
			}
		}
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(320, 320, 30, 30));
			jButton.setBackground(new Color(1, 1, 1));
			p = jButton.getLocation();
			x = p.getX();
			y = p.getY();
			jButton.setIcon(new ImageIcon(fileLoc));
			jButton.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					if(e.getKeyCode()==10){
						if(!gamexunhuan){
							jButton1.setVisible(false);
							jLabel.setVisible(false);
							reset();
						}
					}
					if (e.getKeyCode() == 37) {
						kleft = false;
					}
					if (e.getKeyCode() == 38) {
						kup = false;
					}
					if (e.getKeyCode() == 39) {
						kright = false;
					}
					if (e.getKeyCode() == 40) {
						kdown = false;
					}
				}

				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == 37) {
						kleft = true;

					}
					if (e.getKeyCode() == 38) {
						kup = true;

					}
					// 触发按右键
					if (e.getKeyCode() == 39) {
						kright = true;

					}
					if (e.getKeyCode() == 40) {
						kdown = true;

					}
				}
			});
		}
		return jButton;
	}

	class Threads implements Runnable {
		public Threads(JButton jjb) {
			jb = jjb;
		}

		JButton jb = null;

		private boolean first = true;

		public void run() {
			while (gamexunhuan) {
				go();
			}
		}

		public void go() {
			int zzx = 0;
			int zzy = 0;
			int zx = 0;
			int zy = 0;
			while (true) {
				if(gamexunhuan){
				int fangxiang = (int) (Math.random() * 4 + 1);
				// 四个if随即从四个边发射子弹
				if (fangxiang == 1) {
					zx = 0;
					zy = (int) (Math.random() * 701);
				}
				if (fangxiang == 2) {
					zx = (int) (Math.random() * 701);
					zy = 0;
				}
				if (fangxiang == 3) {
					zx = 700;
					zy = (int) (Math.random() * 701);
				}
				if (fangxiang == 4) {
					zx = (int) (Math.random() * 701);
					zy = 700;
				}
				// 初始化子弹，有了就不在加了
				if (first) {
					jPanel.add(jb, null);
					first = false;
				}
				jb.setBounds(new Rectangle(zx, zy, 10, 10));
				// 定义子弹与物体之间的步长
				zzx = (int) (((x + 15) - zx) / 30);
				zzy = (int) (((y + 15) - zy) / 30);
				}
				while (gamexunhuan) {
					try {
						zx += zzx;
						zy += zzy;
						jb.setLocation(zx, zy);
						if (zx + 5 > x & zx + 5 < x + 30 & zy + 5 > y
								& zy + 5 < y + 30) {
							jButton.setIcon(new ImageIcon(fileLoc1));
							gamexunhuan = false;
							first = true;
							jButton1.setVisible(true);
							jLabel.setVisible(true);
							lasttime = new Date().getTime();
							Date gametime = new Date(lasttime-firsttime);
							int min =0; 
							int sec =0;
							min = gametime.getMinutes();
							sec = gametime.getSeconds();
							String endtime = "";
							if(min!=0){
									endtime=min + "分  " + sec + "秒";
							}else{
								endtime=sec + "秒";
							}
							jLabel.setText("                          GAME OVER!!! \n用时：" + endtime);
							break;
						}
						// 超出边线停止循环
						if (zx > 700 | zy > 700 | zx < 0 | zy < 0) {
							break;
						}
						Thread.sleep(60);
					} catch (InterruptedException e) {
						// TODO 自动生成 catch 块
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO 自动生成 catch 块
					e.printStackTrace();
				}
			}
		}
	}

} // @jve:decl-index=0:visual-constraint="10,10"
