package sun;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Sun{
	protected JLabel sunLabel;
	protected int x, y; 
	protected int flowSpeed;
	protected boolean isClicked = false;
	public static ArrayList<Sun> suns = new ArrayList<>();
	protected final static ImageIcon sun = new ImageIcon(Sun.class.getResource("/Resource/images/interface/Sun.gif"));
	protected JFrame frame;
	public Sun()
	{
		
	}
	public Sun(int x,int y,JFrame frame) {
		this.x = x + 75;
		this.y = y + 20;
		this.frame = frame;
		this.flowSpeed = 5;
		sunLabel = new JLabel(sun);
		sunLabel.setBounds(this.x, this.y, sun.getIconWidth(), sun.getIconHeight());
		frame.add(sunLabel);
		new Thread(new SunClickedThread()).start();
	}

	class SunClickedThread implements Runnable{

		@Override
		public void run() {
			while(true)
			{
				System.out.print("");
				if(isClicked) {
					
					sunLabel.setVisible(false);
					frame.remove(sunLabel);
					frame.repaint();
					break;
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
	public boolean isClicked() {
		return isClicked;
	}
	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}
}