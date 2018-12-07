package car;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import bullet.Bullet;
import MainGame.AudioPlayer;
import MainGame.GameGUI;
import zombies.Zombie;

@SuppressWarnings("unused")
public class Car {
	int x,y,h;
	int flySpeed = 0;
	int width = 100,height = 100;
	JLabel carLabel;
	private final static ImageIcon car = new ImageIcon(Bullet.class.getResource("/Resource/images/interface/LawnCleaner.png"));
	
	AudioPlayer t1 = new AudioPlayer("Resource/audio/lawnmower.mp3");
	Thread t =new Thread(t1);
	
	public Car(int x,int y,int h,JFrame jframe){
		this.x = x;
		this.y = y;
		this.h = h;
		carLabel = new JLabel(car);
		carLabel.setBounds(x, y, width, height);
		jframe.add(carLabel);
	    new Thread(new moveCar()).start();
	}
	class moveCar implements Runnable {

		@Override
		public void run() {
			while(x <= 1050) {
				//if(flySpeed > 0) t.start();
				for(int i = 0; i < Zombie.zombies[h].size();i++) {
					
					if(Zombie.zombies[h].get(i).getX() - x <= 0) {
						Zombie.zombies[h].get(i).setHit_Point(0);
						flySpeed = 20;
					}
				}
				
				try {
					Thread.sleep(100);
					x += flySpeed;
					carLabel.setLocation(x,y);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
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
	
}
