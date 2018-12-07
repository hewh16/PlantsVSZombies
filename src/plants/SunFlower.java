package plants;

import javax.swing.JFrame;

import sun.Sun;

public class SunFlower extends Plant {
	private JFrame frame;
	public SunFlower(int x,int y,JFrame frame)
	{
		super();
		super.x = x;
		super.y = y;
		super.cooldown_time = 2;
		super.cost= 50 ;
		super.hp = 70;
		this.frame = frame;
		new Thread(new SunFlowerThread()).start();
	}
	private void createSun()
	{
		Sun sun = new Sun(x, y, frame);
		Sun.suns.add(sun);
	}
	class SunFlowerThread implements Runnable{

		@Override
		public void run() {
			// TODO �Զ����ɵķ������
			try {
				while(hp > 0)
				{
					Thread.sleep(9000);
					if(hp > 0)
						createSun();
				}
			} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
			}
		
			
	}
}
