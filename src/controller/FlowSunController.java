package controller;

import java.util.Random;

import javax.swing.JFrame;

import sun.FlowSun;
import sun.Sun;


public class FlowSunController {
	private JFrame frame;
	public FlowSunController(JFrame frame)
	{
		this.frame = frame;
		new Thread(new ControllerThread()).start();
	}
	private void randomCreateSun()
	{
		Random random = new Random();
		FlowSun sun = new FlowSun(250+random.nextInt(970), 150, frame);
		Sun.suns.add(sun);
	}
	class ControllerThread implements Runnable{

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			try {
			while(true)
			{
				Thread.sleep(10000);
				randomCreateSun();
			}
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}
}
