
//	private final static ImageIcon bb = new ImageIcon(Bullet.class.getResource("/images/bb_20.png"));
//	private final static ImageIcon bb_blue = new ImageIcon(Bullet.class.getResource("/images/bb_20_BLUE.png"));
//	private final static ImageIcon bb_hit = new ImageIcon(Bullet.class.getResource("/images/bullet_hit.png"));
package bullet;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.x500.X500Principal;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import MainGame.AudioPlayer;
import plants.PeaShooter;
import plants.Plant;
import zombies.Zombie;

@SuppressWarnings({ "serial", "unused" })
public class Bullet extends JLabel {
	private int x, y;           
	private int attack_Point;   
	private int fly_Speed;      
	private boolean slow_Down;  

	private JLabel m;
	private static int WIDTH = 26;
	private static int HEIGHT = 26;
	private final static ImageIcon bb = new ImageIcon(Bullet.class.getResource("/Resource/images/Plants/PB011.png"));
	private final static ImageIcon bb_blue = new ImageIcon(Bullet.class.getResource("/Resource/images/Plants/PB-101.png"));
	private final static ImageIcon bb_hit = new ImageIcon(Bullet.class.getResource("/Resource/images/Plants/PeaBulletHit.png"));
	private JFrame frame;
	private Bullet bullet;
	@SuppressWarnings("unchecked")
	public static ArrayList<Bullet>[] bullets = new ArrayList[5];
	private Zombie zombie;
	boolean ok = true;
	public Bullet(int x,int y,int type,JFrame frame)
	{
		bullet = this;
		this.frame = frame;
		this.x = x+65;
		this.y = y+20;
		this.attack_Point = 50;
		this.fly_Speed = 4;
		if(type == 0)
		{
			this.slow_Down = false;
			m = new JLabel(bb);
		}
		else if(type == 1){
			this.slow_Down = true;
			m = new JLabel(bb_blue);
		}
		
		
		m.setBounds(this.x, this.y, WIDTH, HEIGHT);
		frame.add(m);
		new Thread(new moveBullet()).start();
	}
	public void move()
	{
		m.setLocation(x, y);
		x += fly_Speed;
		if(isMeet() && zombie.getHit_Point() >= 0)
		{
			bullets[PeaShooter.getRow(y - 20)].remove(bullet);
			frame.remove(m);
			frame.repaint();
			m.setIcon(bb_hit);
			m.setBounds(x - 20, y, 51, 45);
			m.setVisible(true);
			hitZom(zombie);
			AudioPlayer t1 = new AudioPlayer("Resource/audio/firepea.mp3");
			Thread t =new Thread(t1);
	        t.start();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
			
			ok = false;
		}
			
	}
	public void hitZom(Zombie z){
		
			z.setHit_Point(z.getHit_Point() - attack_Point);
	}
	public boolean isMeet()
	{
		for(Zombie z : Zombie.zombies[PeaShooter.getRow(y-20)])
		{
			
			if(z.getX()+50<x && z.getX()+120>x) {
				this.zombie = z;
				return true;
			}
		}
		return false;
	}
	public static boolean outOfBounds(int x)
	{
		if(x > 1200)
			return false;
		else
			return true;
	}
	class moveBullet implements Runnable{

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while(outOfBounds(x) && ok == true)
			{
				try {
					Thread.sleep(20);
					move();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
			bullets[PeaShooter.getRow(y - 20)].remove(bullet);
			frame.remove(m);
			frame.repaint();
		}
		
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAttack_Point() {
		return attack_Point;
	}

	public void setAttack_Point(int attack_Point) {
		this.attack_Point = attack_Point;
	}

	public int getFly_Speed() {
		return fly_Speed;
	}

	public void setFly_Speed(int fly_Speed) {
		this.fly_Speed = fly_Speed;
	}

	public boolean isSlow_Down() {
		return slow_Down;
	}

	public void setSlow_Down(boolean slow_Down) {
		this.slow_Down = slow_Down;
	}
	
	
}
