package MainGame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SecondSurface extends JFrame {
	
	AudioPlayer t1 = new AudioPlayer("Resource/audio/Look up at the Sky.mp3");
	Thread t =new Thread(t1);

    AudioPlayer t3 = new AudioPlayer("Resource/audio/evillaugh.mp3");
	Thread t2 =new Thread(t3);
	
	private final static ImageIcon Surface = new ImageIcon(
			SecondSurface.class.getResource("/Resource/images/interface/Surface.png"));
	private final static ImageIcon SecondStart = new ImageIcon(
			SecondSurface.class.getResource("/Resource/images/interface/StartGame.png"));
	private final static ImageIcon SecondStartOver = new ImageIcon(
			SecondSurface.class.getResource("/Resource/images/interface/StartGameOver.png"));
	private final static ImageIcon Hand1 = new ImageIcon(
			SecondSurface.class.getResource("/Resource/images/interface/hand1.png"));
	private final static ImageIcon Hand2 = new ImageIcon(
			SecondSurface.class.getResource("/Resource/images/interface/hand2.png"));
	private final static ImageIcon Hand3 = new ImageIcon(
			SecondSurface.class.getResource("/Resource/images/interface/hand3.png"));
	private final static ImageIcon Hand4 = new ImageIcon(
			SecondSurface.class.getResource("/Resource/images/interface/hand4.png"));
	private final static ImageIcon Hand5 = new ImageIcon(
			SecondSurface.class.getResource("/Resource/images/interface/hand5.png"));
	private final static ImageIcon Hand6 = new ImageIcon(
			SecondSurface.class.getResource("/Resource/images/interface/hand6.png"));
		
	JFrame secondStartFrame = this;
	JLabel startLabel = new JLabel(SecondStart);
	JLabel startOverLabel = new JLabel(SecondStartOver);
	JLabel zombieHand1 = new JLabel(Hand1);
	JLabel zombieHand2 = new JLabel(Hand2);
	JLabel zombieHand3 = new JLabel(Hand3);
	JLabel zombieHand4 = new JLabel(Hand4);
	JLabel zombieHand5 = new JLabel(Hand5);
	JLabel zombieHand6 = new JLabel(Hand6);
	
	@SuppressWarnings("deprecation")
	public SecondSurface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.setResizable(false);
		setLayout(null);
		setBounds(220, 10, Surface.getIconWidth(), Surface.getIconHeight() + 30);
		
		JLabel backgroundLabel = new JLabel(Surface);
		getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));
		backgroundLabel.setBounds(0, 0, Surface.getIconWidth(), Surface.getIconHeight());
		Container cp = getContentPane();
		((JPanel) cp).setOpaque(false);
		
		startLabel.setBounds(480, 80, SecondStart.getIconWidth(), SecondStart.getIconHeight());
		startLabel.setVisible(true);
		add(startLabel);
		
		startOverLabel.setBounds(480, 80, SecondStartOver.getIconWidth(), SecondStartOver.getIconHeight());
		startOverLabel.setVisible(false);
		add(startOverLabel);
		
		t.start();
		
		zombieHand1.setBounds(200, 260, Hand1.getIconWidth(), Hand1.getIconHeight());
		zombieHand2.setBounds(200, 260, Hand2.getIconWidth(), Hand2.getIconHeight());
		zombieHand3.setBounds(200, 260, Hand3.getIconWidth(), Hand3.getIconHeight());
		zombieHand4.setBounds(200, 260, Hand4.getIconWidth(), Hand4.getIconHeight());
		zombieHand5.setBounds(200, 260, Hand5.getIconWidth(), Hand5.getIconHeight());
		zombieHand6.setBounds(200, 260, Hand6.getIconWidth(), Hand6.getIconHeight());
		zombieHand1.setVisible(false);
		zombieHand2.setVisible(false);
		zombieHand3.setVisible(false);
		zombieHand4.setVisible(false);
		zombieHand5.setVisible(false);
		zombieHand6.setVisible(false);
		add(zombieHand1);
		add(zombieHand2);
		add(zombieHand3);
		add(zombieHand4);
		add(zombieHand5);
		add(zombieHand6);
		
		
		MouseHandler handler = new MouseHandler();
		this.addMouseMotionListener(handler);
		this.addMouseListener(handler);
	}
	
	class MouseHandler implements MouseMotionListener, MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = startLabel.getX();
			int y = startLabel.getY() + 25;
			int w = 340;
			int h = 150;
			if(e.getX() >= x && e.getX() <= x + w && e.getY() >= y && e.getY() <= y + h){
				Thread1 t1 = new Thread1(zombieHand1, zombieHand2, zombieHand3, 
						zombieHand4, zombieHand5, zombieHand6);
				Thread t =new Thread(t1);
		        t.start();
		        t2.start();
				setCursor(new Cursor(Cursor.HAND_CURSOR));
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
			int w = 340;
			int h = 150;
			if(e.getX() >= x && e.getX() <= x + w && e.getY() >= y && e.getY() <= y + h){
				startLabel.setVisible(false);
				startOverLabel.setVisible(true);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}else {
				startLabel.setVisible(true);
				startOverLabel.setVisible(false);
				setCursor(Cursor.getDefaultCursor());
			}
		}
	}
	class Thread1 implements Runnable{
	JLabel zombieHand1;
	JLabel zombieHand2;
	JLabel zombieHand3;
	JLabel zombieHand4;
	JLabel zombieHand5;
	JLabel zombieHand6;
	
	public Thread1(JLabel zombieHand1, JLabel zombieHand2, JLabel zombieHand3, 
			JLabel zombieHand4, JLabel zombieHand5, JLabel zombieHand6) {
		this.zombieHand1 = zombieHand1;
		this.zombieHand2 = zombieHand2;
		this.zombieHand3 = zombieHand3;
		this.zombieHand4 = zombieHand4;
		this.zombieHand5 = zombieHand5;
		this.zombieHand6 = zombieHand6;
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		zombieHand1.setVisible(true);
		try{Thread.sleep(100);} catch(Exception e1){}
		zombieHand1.setVisible(false);
		zombieHand2.setVisible(true);
		try{Thread.sleep(100);} catch(Exception e1){}
		zombieHand2.setVisible(false);
		zombieHand3.setVisible(true);
		try{Thread.sleep(100);} catch(Exception e1){}
		zombieHand3.setVisible(false);
		zombieHand4.setVisible(true);
		try{Thread.sleep(100);} catch(Exception e1){}
		zombieHand4.setVisible(false);
		zombieHand5.setVisible(true);
		try{Thread.sleep(100);} catch(Exception e1){}
		zombieHand5.setVisible(false);
		zombieHand6.setVisible(true);
		try{Thread.sleep(3000);} catch(Exception e1){}

		t.stop();
		new GameGUI();
		secondStartFrame.dispose();
	}
	}
}
