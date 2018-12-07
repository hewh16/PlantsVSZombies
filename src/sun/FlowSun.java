package sun;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlowSun extends Sun{
	private int flowSpeed = 1;
	private final static ImageIcon sun = new ImageIcon(Sun.class.getResource("/Resource/images/interface/Sun.gif"));
	private int randomNumber;
	public FlowSun(int x,int y,JFrame jFrame)
	{
		super();
		this.x = x;
		this.y = y;
		this.frame = jFrame;
		Random random  = new Random();
		randomNumber = random.nextInt(570);
		sunLabel = new JLabel(sun);
		sunLabel.setBounds(this.x, this.y, sun.getIconWidth(), sun.getIconHeight());
		this.frame.add(sunLabel);
		new Thread(new MoveSun()).start();
	}
	public boolean isClicked() {
		return isClicked;
	}
	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}
	private void move()
	{
		
		if(y < randomNumber)
		{
			sunLabel.setLocation(x, y);
			y += flowSpeed;
		}
	}
	class MoveSun implements Runnable{

		@Override
		public void run() {
			try {
				while(y < 570 )
				{
					System.out.print("");
					if(isClicked) {
						sunLabel.setVisible(false);
						frame.remove(sunLabel);
						frame.repaint();
						break;
					}
					Thread.sleep(25);
					move();
				} 
			} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		}
		
	}
}