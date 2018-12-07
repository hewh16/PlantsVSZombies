package MainGame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class StartGame extends JFrame {
	private final static ImageIcon MainStart = new ImageIcon(
			StartGame.class.getResource("/Resource/images/interface/MainStart.png"));
	private final static ImageIcon StartButton = new ImageIcon(
			StartGame.class.getResource("/Resource/images/interface/start_over.png"));
	
	JFrame startFrame = this;
	JLabel startLabel = new JLabel(StartButton);
	AudioPlayer t1 = new AudioPlayer("Resource/audio/Faster.mp3");
	Thread t =new Thread(t1);
	
	@SuppressWarnings("deprecation")
	public StartGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.setResizable(false);
		setLayout(null);
		setBounds(220, 10, MainStart.getIconWidth(), MainStart.getIconHeight() + 30);
		
		JLabel backgroundLabel = new JLabel(MainStart);
		getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));
		backgroundLabel.setBounds(0, 0, MainStart.getIconWidth(), MainStart.getIconHeight());
		Container cp = getContentPane();
		((JPanel) cp).setOpaque(false);
		
		startLabel.setBounds(248, 544, StartButton.getIconWidth(), StartButton.getIconHeight());
		
		startLabel.setVisible(false);
		add(startLabel);
		MouseHandler handler = new MouseHandler();
		this.addMouseMotionListener(handler);
		this.addMouseListener(handler);
		
        t.start();
	}
	
	class MouseHandler implements MouseMotionListener, MouseListener{

		@SuppressWarnings("deprecation")
		@Override
		public void mouseClicked(MouseEvent e) {
			int x = startLabel.getX();
			int y = startLabel.getY() + 25;
			int w = 310;
			int h = 40;
			if(e.getX() >= x && e.getX() <= x + w && e.getY() >= y && e.getY() <= y + h){
				new SecondSurface();
				startFrame.dispose();
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				t.stop();
			}else {
				
				setCursor(Cursor.getDefaultCursor());
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			int x = startLabel.getX();
			int y = startLabel.getY() + 25;
			int w = 310;
			int h = 40;
			if(e.getX() >= x && e.getX() <= x + w && e.getY() >= y && e.getY() <= y + h){
				startLabel.setVisible(true);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}else {
				startLabel.setVisible(false);
				setCursor(Cursor.getDefaultCursor());
			}
		}
	}
}



