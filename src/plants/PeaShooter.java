package plants;

import javax.swing.JFrame;

import bullet.Bullet;
import MainGame.GameGUI;
import zombies.Zombie;

@SuppressWarnings("unused")
public class PeaShooter extends Plant{
	private JFrame frame;
	public PeaShooter(int x,int y,JFrame frame)
	{
		super();
		super.x = x;
		super.y = y;
		super.cooldown_time = 2;
		super.cost= 100 ;
		super.hp = 100;
		this.frame = frame;
		new Thread(new PeaShooterThread()).start();
	}
	public void fireBullet()
	{
		boolean flag = false;
		for(Zombie zombie : Zombie.zombies[getRow(y)])
		{
			if(zombie.getHit_Point() > 0)
				flag = true;
		}
		if(flag)
		{
			Bullet bullet = new Bullet(x, y, 0,frame);
			Bullet.bullets[getRow(y)].add(bullet);
		}
	}
	public static int getRow(int y)
	{
		y += 10;
		if(y> 135 && y < 225) {
			return 1;
		}
			
		else if(y >= 225 && y < 315)
		{
			return 2;
		}
		else if(y >= 315 && y < 405){
			return 3;
		}
		else if(y >= 405 && y < 495){
			return 4;
		}
		else{
			return 0;
		}
	}
	class PeaShooterThread implements Runnable{

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			try {
				while(true)
				{
					if(hp > 0)
					{
						Thread.sleep(3000);
						fireBullet();
					}
					else
					{
						//除去plants
						break;
					}
				}
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		
	}
}
