package controller;


import java.util.Observer;

import javax.swing.JFrame;

import MainGame.AudioPlayer;
import zombies.Zombie;

@SuppressWarnings({ "unused", "deprecation" })
public class ZombieController {
	
	private JFrame frame;
	public ZombieController(JFrame frame)
	{
		this.frame = frame;
		new Thread(new ControllerThread()).start();
		new Thread(new GroanThread()).start();
	}
	class ControllerThread implements Runnable{
		public int label = 0;

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			try {
			while(true)
			{
				Thread.sleep((int)(6000+Math.random()*(10000-6000+1)));
				//Thread.sleep(1000);
				new Zombie((int)(Math.random() * 5), frame);
			}
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}
	
	class GroanThread implements Runnable{
		public int label = 0;

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			
			while(true)
			{
				try {
					Thread.sleep(12000+(int)(Math.random()*(10000-6000+1)));
					label = (int)(Math.random()*6);
					switch (label) {
					case 0:
						AudioPlayer t1 = new AudioPlayer("Resource/audio/groan1.mp3");
						Thread T1 =new Thread(t1);
						T1.start();break;
					case 1:
						AudioPlayer t2 = new AudioPlayer("Resource/audio/groan2.mp3");
						Thread T2 =new Thread(t2);
						T2.start();break;
					case 2:
						AudioPlayer t3 = new AudioPlayer("Resource/audio/groan3.mp3");
						Thread T3 =new Thread(t3);
						T3.start();break;
					case 3:
						AudioPlayer t4 = new AudioPlayer("Resource/audio/groan4.mp3");
						Thread T4 =new Thread(t4);
						T4.start();break;
					case 4:
						AudioPlayer t5 = new AudioPlayer("Resource/audio/groan5.mp3");
						Thread T5 =new Thread(t5);
						T5.start();break;
					case 5:
						AudioPlayer t6 = new AudioPlayer("Resource/audio/groan6.mp3");
						Thread T6 =new Thread(t6);
						T6.start();break;
					}
				}catch(InterruptedException e) {
					System.out.println(e);
				}
			}
			
		}
		
	}
}
