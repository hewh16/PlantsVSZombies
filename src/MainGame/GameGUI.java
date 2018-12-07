package MainGame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MainGame.SecondSurface.Thread1;
import bullet.Bullet;
import car.Car;
import controller.FlowSunController;
import controller.ZombieController;
import plants.IcePeaShooter;
import plants.PeaShooter;
import plants.Plant;
import plants.WallNut;
import plants.SunFlower;

import sun.Sun;
import zombies.Zombie;



@SuppressWarnings({ "deprecation", "unused", "serial" })
public class GameGUI extends javax.swing.JFrame implements Runnable{
	
	private final static ImageIcon background = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/interface/background1.jpg"));
	private final static ImageIcon SeedBank = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/interface/SeedBank.png"));
	private final static ImageIcon sun_flower = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Card/Plants/sunflower_on.jpg"));
	private final static ImageIcon single_bullet_plant = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Card/Plants/card_norbeen_on.jpg"));
	private final static ImageIcon movd_single_bullet_plant = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Plants/Peashooter/Peashooter.gif"));
	private final static ImageIcon move_sun_flower = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Plants/SunFlower/SunFlower1.gif"));
	private final static ImageIcon shovel = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/interface/shovel.png"));
	private final static ImageIcon shove = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/interface/shove.png"));
	private final static ImageIcon card_norbeen_off = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Card/Plants/card_norbeen_off.jpg"));
	private final static ImageIcon sunflower_off= new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Card/Plants/sunflower_off.jpg"));
	private final static ImageIcon card_icebeen_on = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Card/Plants/card_icebeen_on.jpg"));
	private final static ImageIcon card_icebeen_off = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Card/Plants/card_icebeen_off.jpg"));
	private final static ImageIcon moveIcebean = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Plants/SnowPea/SnowPea.gif"));
	private final static ImageIcon WallNut_on = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Card/Plants/WallNut_on.jpg"));
	private final static ImageIcon WallNut_off = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Card/Plants/WallNut_off.jpg"));
	private final static ImageIcon moveWallNut = new ImageIcon(
			GameGUI.class.getResource("/Resource/images/Plants/WallNut/WallNut.gif"));
	private final static ImageIcon zombie_win = new ImageIcon(
			Zombie.class.getResource("/Resource/images/interface/ZombiesWon.png"));
	
	public static Plant[][] plants = new Plant[5][10];
	public static JLabel[][] labels = new JLabel[5][10];
    private long PeaBeginTime = 0;  
    private long flowerBeginTime = 0;
    private long icePeaBeginTime = 0;
    private long WallNutBeginTime = 0;
	static JLabel barLabel;
	static JLabel sunFlowerLabel;
	static JLabel peaLabel;
	static JLabel icePeaLabel;
	static JLabel WallNutLabel;
	static JLabel sunCountLabel;
	static JLabel movePeaLabel;
	static JLabel moveFlowerLabel;
	static JLabel moveShovelLabel;
	static JLabel moveIcePeaLabel;
	static JLabel moveWallNutLabel;
	static JLabel plantLabel;
	static JLabel shovelLabel;
	static JLabel uIcePeaLabel;
	static JLabel uPeaLabel;
	static JLabel uFlowerLabel;
	static JLabel uWallNutLabel;
	Point movePeaPoint;
	Point moveFlowePoint;
	Point moveShovelPoint;
	Point moveIcePeaPoint;
	Point moveWallNutPoint;
	JLabel zombieWon = new JLabel(zombie_win);
	int species,count = 1000;
	boolean zombieWin = false;
	public static JFrame jFrame;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GameGUI() {
		AudioPlayer t1 = new AudioPlayer("Resource/audio/Grasswalk.mp3");
		Thread t =new Thread(t1);
		t.start();
		for(int i=0;i<5;i++)
		{
			Bullet.bullets[i] = new ArrayList<>();
		}
		for (int i = 0; i < 5; i++)
			Zombie.zombies[i] = new ArrayList();
		jFrame = this;
        setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,70, 1050, background.getIconHeight());
		setResizable(false);
		JLabel imgLabel = new JLabel(background);
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0,background.getIconWidth(), background.getIconHeight());
		Container cp = getContentPane();
		((JPanel) cp).setOpaque(false); 
		
		
		this.setVisible(true);
		
		uFlowerLabel = makeLabel(sunflower_off,300,0,100,100);
		uFlowerLabel.setVisible(false);
		add(uFlowerLabel);
		
		sunFlowerLabel = makeLabel(sun_flower,300,0,100,100);
		add(sunFlowerLabel);
		
	    uPeaLabel = makeLabel(card_norbeen_off,360,-2,100,100);
	    add(uPeaLabel);
	    uPeaLabel.setVisible(false);
	    
	    peaLabel = makeLabel(single_bullet_plant,360,-2,100,100);
	    add(peaLabel);
	    
	    uIcePeaLabel = makeLabel(card_icebeen_off,420,0,100,100);
	    add(uIcePeaLabel);
	    uIcePeaLabel.setVisible(false);
	    
        icePeaLabel = makeLabel(card_icebeen_on,420,0,100,100);
        add(icePeaLabel);
	    
        uWallNutLabel = makeLabel(WallNut_off,500,15,70,70);
        add(uWallNutLabel);
        uWallNutLabel.setVisible(false);
        
        WallNutLabel = makeLabel(WallNut_on,500,15,70,70);
        add(WallNutLabel);
                
	    sunCountLabel = new JLabel("0");
	    sunCountLabel.setBounds(270,50,50,50);
	    add(sunCountLabel);
	    
	    shovelLabel = makeLabel(shovel,700,0,100,100);
	    add(shovelLabel);
	    
		barLabel = makeLabel(SeedBank,220,0,500,100);
	    add(barLabel);
	    
	    zombieWon.setBounds(250, 80, zombie_win.getIconWidth(), zombie_win.getIconHeight());
	    zombieWon.setVisible(false);
	    add(zombieWon);
	    
		MouseHandler handler = new MouseHandler();
		this.addMouseMotionListener(handler);
		this.addMouseListener(handler);
		Thread gameThread = new Thread(this);
		gameThread.start();

		new FlowSunController(this);
		new ZombieController(this);
		new Car(170,80,0,jFrame);
		new Car(170,170,1,jFrame);
		new Car(170,270,2,jFrame);
		new Car(170,370,3,jFrame);
		new Car(170,470,4,jFrame);
		
	    
	}
	public JLabel makeLabel(ImageIcon im,int x,int y,int w,int h) {
		JLabel temp = new JLabel(im);
		temp.setBounds(x, y, w, h);
		return temp;
	}
	int isOk(int x,int y) {
		if(x >= sunFlowerLabel.getX() && x <= sunFlowerLabel.getX() + 80 && y >= sunFlowerLabel.getY() && y <= sunFlowerLabel.getY() + 100 && System.currentTimeMillis() - flowerBeginTime > 5000 && count >= 50)
			return 1;
		if(x >= peaLabel.getX() && x <= peaLabel.getX() + 80 && y >= peaLabel.getY() && y <= peaLabel.getY() + 100 && System.currentTimeMillis() - PeaBeginTime > 7000 && count >= 100) {
			return 2;
		}
		if(x >= shovelLabel.getX() && x <= shovelLabel.getX() + 100 && y >= shovelLabel.getY() && y <= shovelLabel.getY() + 100)
			return 3;
		if(Sun.suns != null) {
			for(int i = 0; i < Sun.suns.size();i++) {
				if(Math.abs(Sun.suns.get(i).getX() + 50 - x) <= 30 && Math.abs(Sun.suns.get(i).getY() + 60 - y) <= 30)
					return 4;
			}
		}
		if(x >= icePeaLabel.getX() && x <= icePeaLabel.getX() + 100 && y >= icePeaLabel.getY() && y <= icePeaLabel.getY() + 100 && System.currentTimeMillis() - icePeaBeginTime >= 10000 && count >= 170){
			return 5;
		}
		if(x >= WallNutLabel.getX() && x <= WallNutLabel.getX() + 70 && y >= WallNutLabel.getY() && y <= WallNutLabel.getY() + 70 && System.currentTimeMillis() - WallNutBeginTime >= 5000 && count >= 50) {
			return 6;
		}
		return 0;
	}
	class MouseHandler implements MouseMotionListener, MouseListener{
		@Override
		public void mouseDragged(MouseEvent e) {
			if(species == 1)
				moveFlowePoint = e.getPoint();
			if(species == 2)
			    movePeaPoint = e.getPoint();
            if(species == 3)
            	moveShovelPoint = e.getPoint();
            if(species == 5) {
            	moveIcePeaPoint = e.getPoint();
            }
            if(species == 6) {
            	moveWallNutPoint = e.getPoint();
            }
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if(isOk(e.getX(), e.getY()) > 0)
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			else setCursor(Cursor.getDefaultCursor());
			
		}

		@Override
		public void mouseClicked(MouseEvent e) { 
			
			for(int i = 0; i < Sun.suns.size();i++) {
				if(Sun.suns.get(i).isClicked() == false && 
					Math.abs(Sun.suns.get(i).getX() + 50 - e.getX()) <= 30 && 
					Math.abs(Sun.suns.get(i).getY() + 60 - e.getY()) <= 30) {
					Sun.suns.get(i).setClicked(true);
					count += 25;
					AudioPlayer t1 = new AudioPlayer("Resource/audio/bleep.mp3");
					Thread t =new Thread(t1);
			        t.start();
				}
						
				}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			species = isOk(e.getX(), e.getY());
			if(species == 1) {
				moveFlowerLabel.setVisible(true);
				count -= 50;
				flowerBeginTime = System.currentTimeMillis();
			    
			}
			if(species == 2) {
				movePeaLabel.setVisible(true);
				count -= 100;
				PeaBeginTime = System.currentTimeMillis();
			}
			if(species == 3) {
				moveShovelLabel.setVisible(true);
			}
			if(species == 5) {
				moveIcePeaLabel.setVisible(true);
				count -= 170;
				icePeaBeginTime = System.currentTimeMillis();
			}
			if(species == 6) {
				moveWallNutLabel.setVisible(true);
				count -= 50;
				WallNutBeginTime = System.currentTimeMillis();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			int x = ((int)e.getX() - 240) / 80;
			int y = ((int)e.getY() - 50) / 90;
			if(species > 0 &&  x >= 0 && x < 9 && y >= 0 && y < 5) {
				
				if(species == 1  && plants[y][x] == null) {

					plants[y][x]= new SunFlower(x * 80 + 240,y * 90 + 85,jFrame);
					plantLabel = makeLabel(move_sun_flower,x * 80 + 240 ,y * 90 + 85,100,100);
					labels[y][x] = plantLabel;
					add(plantLabel);
					AudioPlayer t1 = new AudioPlayer("Resource/audio/plant1.mp3");
					Thread t =new Thread(t1);
			        t.start();
				    
				}
				if(species == 2  && plants[y][x] == null) {
					
					plants[y][x]= new PeaShooter(x * 80 + 240,y * 90 + 85,jFrame);
				    plantLabel = makeLabel(movd_single_bullet_plant,x * 80 + 240 ,y * 90 + 85,100,100);
				    labels[y][x] = plantLabel;
				    add(plantLabel);
				    AudioPlayer t1 = new AudioPlayer("Resource/audio/plant1.mp3");
					Thread t =new Thread(t1);
			        t.start();
					
			    }
				if(species == 3) {
					if(plants[y][x] != null) {
						plants[y][x].setHp(0);
						AudioPlayer t1 = new AudioPlayer("Resource/audio/shovel.mp3");
						Thread t =new Thread(t1);
				        t.start();
						
					}
				}
				if(species == 5  && plants[y][x] == null) {
					plants[y][x] = new IcePeaShooter(x * 80 + 240,y * 90 + 85,jFrame);
					plantLabel = makeLabel(moveIcebean,x * 80 + 240 ,y * 90 + 85,100,100);
					labels[y][x] = plantLabel;
					add(plantLabel);
					AudioPlayer t1 = new AudioPlayer("Resource/audio/plant1.mp3");
					Thread t =new Thread(t1);
			        t.start();
				}
				if(species == 6 && plants[y][x] == null) {
					plants[y][x] = new WallNut(x * 80 + 240,y * 90 + 85);
					plantLabel = makeLabel(moveWallNut,x * 80 + 240 ,y * 90 + 85,100,100);
					labels[y][x] = plantLabel;
					add(plantLabel);
					AudioPlayer t1 = new AudioPlayer("Resource/audio/plant1.mp3");
					Thread t =new Thread(t1);
			        t.start();
				}
							
		    }
			species = 0;
			moveFlowePoint = new Point(300, 0);
			moveFlowerLabel.setVisible(false);
			movePeaPoint = new Point(360,-2);
			movePeaLabel.setVisible(false);
			moveShovelPoint = new Point(700,00);
			moveShovelLabel.setVisible(false);
			moveIcePeaPoint = new Point(420,0);
			moveIcePeaLabel.setVisible(false);
			moveWallNutPoint = new Point(480,0);
			moveWallNutLabel.setVisible(false);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	@Override
	public void run() {
	
		movePeaPoint = new Point(360,-2);
		movePeaLabel = makeLabel(movd_single_bullet_plant,360,-2,100,100);
		movePeaLabel.setVisible(false);
		add(movePeaLabel);
		
		moveFlowePoint = new Point(300, 0);
		moveFlowerLabel = makeLabel(move_sun_flower, 300, 0, 100, 100);
		moveFlowerLabel.setVisible(false);
		add(moveFlowerLabel);
		
		moveShovelPoint = new Point(700,0);
		moveShovelLabel = makeLabel(shove,700,0,100,100);
		moveShovelLabel.setVisible(false);
		add(moveShovelLabel);
		
		moveIcePeaPoint = new Point(420,0);
		moveIcePeaLabel = makeLabel(moveIcebean,420,0,100,100);
		moveIcePeaLabel.setVisible(false);
		add(moveIcePeaLabel);
		
		moveWallNutPoint = new Point(480,0);
		moveWallNutLabel = makeLabel(moveWallNut,480,0,100,100);
		moveWallNutLabel.setVisible(false);
		add(moveWallNutLabel);
				
		String sunName;

		while(true) {
		    movePeaLabel.setBounds((int)movePeaPoint.x - 40, (int)movePeaPoint.y - 40, 100,100);
		    moveFlowerLabel.setBounds((int)moveFlowePoint.getX() - 40, (int)moveFlowePoint.getY() - 40, 100,100);
		    moveShovelLabel.setBounds((int)moveShovelPoint.getX() - 40, (int)moveShovelPoint.getY() - 40, 80,80);
		    moveIcePeaLabel.setBounds((int)moveIcePeaPoint.x - 40 , (int)moveIcePeaPoint.y - 40, 100,100);
		    moveWallNutLabel.setBounds((int)moveWallNutPoint.x - 40 , (int)moveWallNutPoint.y - 40, 100,100);
		    sunName = "" + count;
		    sunCountLabel.setText(sunName);
		
		    if(System.currentTimeMillis() - PeaBeginTime <= 7000){
		    	uPeaLabel.setVisible(true);
		    }
		    else {
		    	uPeaLabel.setVisible(false);
		    }
		    
		    if(System.currentTimeMillis() - flowerBeginTime <= 5000) {
		    	uFlowerLabel.setVisible(true);
		    }else {
		    	uFlowerLabel.setVisible(false);
		    }
		    
		    if(System.currentTimeMillis() - icePeaBeginTime <= 10000) {
		    	uIcePeaLabel.setVisible(true);
		    }else {
		    	uIcePeaLabel.setVisible(false);
		    }
		    
		    if(System.currentTimeMillis() - WallNutBeginTime <= 5000) {
		    	uWallNutLabel.setVisible(true);
		    }else {
		    	
		    	uWallNutLabel.setVisible(false);
		    }
		    		    
		    for(int i = 0; i < 5;i++) {
		    	for(int j = 0; j < 9;j++) {
		    		if(labels[i][j] != null && plants[i][j] != null && plants[i][j].getHp() <= 0) {
		    		      remove(labels[i][j]);
		    		      plants[i][j] = null; 
		    		}
		    	}
		    }
		    for(int i = 0; i < 5;i++) {
		    	for(int j = 0; j < Zombie.zombies[i].size();j++) {
		    		if(Zombie.zombies[i] != null && Zombie.zombies[i].get(j).isGameOver() == true) {
		    		    zombieWin = true;
		    		}
		    	}
		    }
		    if(zombieWin == true) {
		    	zombieWon.setVisible(true);
		    	AudioPlayer t1 = new AudioPlayer("Resource/audio/scream.mp3");
				Thread t =new Thread(t1);
		        t.start();
		    	break;
		    }
            
            repaint();
		}
	}
}
