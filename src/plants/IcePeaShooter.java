package plants;

import javax.swing.JFrame;

import bullet.Bullet;
import MainGame.GameGUI;
import zombies.Zombie;

@SuppressWarnings("unused")
public class IcePeaShooter extends Plant{
	private JFrame frame;
	public IcePeaShooter(int x,int y,JFrame frame)
	{
		super();
		super.x = x;
		super.y = y;
		super.cooldown_time = 3;
		super.cost= 100 ;
		super.hp = 100;
		this.frame = frame;
		new Thread(new PeaShooterThread()).start();
	}
	public void fireBullet()
	{
		boolean flag = false;
		for(Zombie zombie : Zombie.zombies[PeaShooter.getRow(y)])
		{
			if(zombie.getHit_Point() > 0)
				flag = true;
		}
		if(flag)
		{
			Bullet bullet = new Bullet(x, y, 1,frame);
			Bullet.bullets[PeaShooter.getRow(y)].add(bullet);
		}
	}
	class PeaShooterThread implements Runnable{

		@Override
		public void run() {
			// TODO �Զ����ɵķ������
			try {
				while(hp > 0)
				{
					Thread.sleep(3000);
					fireBullet();
				}
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
		}
		
	}
}
