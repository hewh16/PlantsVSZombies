package zombies;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import MainGame.GameGUI;
import MainGame.AudioPlayer;
import MainGame.eatMusic;
import MainGame.GameGUI;
import zombies.Zombie.moveZombie;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings({ "unused", "deprecation", "serial" })
public class Zombie extends JPanel{
	
	private int x, y;           
	private int attack_Point;   
	private int move_Speed;     
	private int hit_Point;      
	private boolean isSlow;     
	private boolean isMove;     
	private static int NormalW = 166;
	private static int NormalH = 144;
	private static int NewspaperW = 216;
	private static int NewspaperH = 164;
	private static int FootballW = 154;
	private static int FootballH = 160;
	private static int FootballDieW = 236;
	private static int FootballDieH = 170;
	private boolean isBurned = false;
	
	private final static ImageIcon NormalZombie0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalMove/Zombie0000.png"));
	private final static ImageIcon NormalZombie1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalMove/Zombie0002.png"));
	private final static ImageIcon NormalZombie2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalMove/Zombie0004.png"));
	private final static ImageIcon NormalZombie3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalMove/Zombie0006.png"));
	private final static ImageIcon NormalZombie4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalMove/Zombie0008.png"));
	private final static ImageIcon NormalZombie5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalMove/Zombie0012.png"));
	private final static ImageIcon NormalZombie6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalMove/Zombie0014.png"));
	private final static ImageIcon NormalZombie7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalMove/Zombie0016.png"));
	private final static ImageIcon NormalZombie8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalMove/Zombie0018.png"));
	private final static ImageIcon NormalZombie9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalMove/Zombie0020.png"));
	
	private final static ImageIcon NormalAttack0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalAttack/ZombieAttack0000.png"));
	private final static ImageIcon NormalAttack1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalAttack/ZombieAttack0002.png"));
	private final static ImageIcon NormalAttack2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalAttack/ZombieAttack0004.png"));
	private final static ImageIcon NormalAttack3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalAttack/ZombieAttack0006.png"));
	private final static ImageIcon NormalAttack4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalAttack/ZombieAttack0008.png"));
	private final static ImageIcon NormalAttack5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalAttack/ZombieAttack0012.png"));
	private final static ImageIcon NormalAttack6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalAttack/ZombieAttack0014.png"));
	private final static ImageIcon NormalAttack7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalAttack/ZombieAttack0016.png"));
	private final static ImageIcon NormalAttack8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalAttack/ZombieAttack0018.png"));
	private final static ImageIcon NormalAttack9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalAttack/ZombieAttack0020.png"));
	
	private final static ImageIcon NormalDie0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalDie/ZombieDie0000.png"));
	private final static ImageIcon NormalDie1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalDie/ZombieDie0001.png"));
	private final static ImageIcon NormalDie2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalDie/ZombieDie0002.png"));
	private final static ImageIcon NormalDie3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalDie/ZombieDie0003.png"));
	private final static ImageIcon NormalDie4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalDie/ZombieDie0004.png"));
	private final static ImageIcon NormalDie5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalDie/ZombieDie0005.png"));
	private final static ImageIcon NormalDie6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalDie/ZombieDie0006.png"));
	private final static ImageIcon NormalDie7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalDie/ZombieDie0007.png"));
	private final static ImageIcon NormalDie8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalDie/ZombieDie0008.png"));
	private final static ImageIcon NormalDie9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/Zombie/NormalDie/ZombieDie0009.png"));
	
	private final static ImageIcon ConeheadMove0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadMove/ConeheadZombie0000.png"));
	private final static ImageIcon ConeheadMove1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadMove/ConeheadZombie0003.png"));
	private final static ImageIcon ConeheadMove2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadMove/ConeheadZombie0006.png"));
	private final static ImageIcon ConeheadMove3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadMove/ConeheadZombie0009.png"));
	private final static ImageIcon ConeheadMove4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadMove/ConeheadZombie0015.png"));
	private final static ImageIcon ConeheadMove5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadMove/ConeheadZombie0018.png"));
	private final static ImageIcon ConeheadMove6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadMove/ConeheadZombie0021.png"));
	private final static ImageIcon ConeheadMove7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadMove/ConeheadZombie0027.png"));
	private final static ImageIcon ConeheadMove8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadMove/ConeheadZombie0030.png"));
	private final static ImageIcon ConeheadMove9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadMove/ConeheadZombie0033.png"));
	
	private final static ImageIcon ConeheadAttack0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadAttack/ConeheadZombieAttack0000.png"));
	private final static ImageIcon ConeheadAttack1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadAttack/ConeheadZombieAttack0001.png"));
	private final static ImageIcon ConeheadAttack2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadAttack/ConeheadZombieAttack0002.png"));
	private final static ImageIcon ConeheadAttack3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadAttack/ConeheadZombieAttack0003.png"));
	private final static ImageIcon ConeheadAttack4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadAttack/ConeheadZombieAttack0004.png"));
	private final static ImageIcon ConeheadAttack5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadAttack/ConeheadZombieAttack0005.png"));
	private final static ImageIcon ConeheadAttack6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadAttack/ConeheadZombieAttack0006.png"));
	private final static ImageIcon ConeheadAttack7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadAttack/ConeheadZombieAttack0007.png"));
	private final static ImageIcon ConeheadAttack8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadAttack/ConeheadZombieAttack0008.png"));
	private final static ImageIcon ConeheadAttack9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/ConeheadZombie/ConeheadAttack/ConeheadZombieAttack0010.png"));
	
	private final static ImageIcon BucketheadMove0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadMove/BucketheadZombie0000.png"));
	private final static ImageIcon BucketheadMove1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadMove/BucketheadZombie0003.png"));
	private final static ImageIcon BucketheadMove2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadMove/BucketheadZombie0005.png"));
	private final static ImageIcon BucketheadMove3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadMove/BucketheadZombie0007.png"));
	private final static ImageIcon BucketheadMove4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadMove/BucketheadZombie0010.png"));
	private final static ImageIcon BucketheadMove5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadMove/BucketheadZombie0013.png"));
	private final static ImageIcon BucketheadMove6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadMove/BucketheadZombie0015.png"));
	private final static ImageIcon BucketheadMove7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadMove/BucketheadZombie0017.png"));
	private final static ImageIcon BucketheadMove8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadMove/BucketheadZombie0020.png"));
	private final static ImageIcon BucketheadMove9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadMove/BucketheadZombie0022.png"));
	
	private final static ImageIcon BucketheadAttack0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadAttack/BucketheadZombieAttack0000.png"));
	private final static ImageIcon BucketheadAttack1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadAttack/BucketheadZombieAttack0001.png"));
	private final static ImageIcon BucketheadAttack2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadAttack/BucketheadZombieAttack0002.png"));
	private final static ImageIcon BucketheadAttack3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadAttack/BucketheadZombieAttack0003.png"));
	private final static ImageIcon BucketheadAttack4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadAttack/BucketheadZombieAttack0004.png"));
	private final static ImageIcon BucketheadAttack5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadAttack/BucketheadZombieAttack0005.png"));
	private final static ImageIcon BucketheadAttack6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadAttack/BucketheadZombieAttack0006.png"));
	private final static ImageIcon BucketheadAttack7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadAttack/BucketheadZombieAttack0007.png"));
	private final static ImageIcon BucketheadAttack8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadAttack/BucketheadZombieAttack0008.png"));
	private final static ImageIcon BucketheadAttack9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/BucketheadZombie/BucketheadAttack/BucketheadZombieAttack0010.png"));
	
	private final static ImageIcon FootballMove0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballMove/FootballZombie0000.png"));
	private final static ImageIcon FootballMove1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballMove/FootballZombie0001.png"));
	private final static ImageIcon FootballMove2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballMove/FootballZombie0002.png"));
	private final static ImageIcon FootballMove3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballMove/FootballZombie0003.png"));
	private final static ImageIcon FootballMove4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballMove/FootballZombie0004.png"));
	private final static ImageIcon FootballMove5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballMove/FootballZombie0006.png"));
	private final static ImageIcon FootballMove6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballMove/FootballZombie0007.png"));
	private final static ImageIcon FootballMove7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballMove/FootballZombie0008.png"));
	private final static ImageIcon FootballMove8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballMove/FootballZombie0009.png"));
	private final static ImageIcon FootballMove9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballMove/FootballZombie0010.png"));
	
	private final static ImageIcon FootballAttack0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballAttack/FootballZombieAttack0000.png"));
	private final static ImageIcon FootballAttack1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballAttack/FootballZombieAttack0001.png"));
	private final static ImageIcon FootballAttack2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballAttack/FootballZombieAttack0002.png"));
	private final static ImageIcon FootballAttack3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballAttack/FootballZombieAttack0003.png"));
	private final static ImageIcon FootballAttack4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballAttack/FootballZombieAttack0004.png"));
	private final static ImageIcon FootballAttack5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballAttack/FootballZombieAttack0005.png"));
	private final static ImageIcon FootballAttack6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballAttack/FootballZombieAttack0006.png"));
	private final static ImageIcon FootballAttack7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballAttack/FootballZombieAttack0007.png"));
	private final static ImageIcon FootballAttack8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballAttack/FootballZombieAttack0008.png"));
	private final static ImageIcon FootballAttack9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballAttack/FootballZombieAttack0009.png"));
	
	private final static ImageIcon FootballDie0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballDie/FootballDie0000.png"));
	private final static ImageIcon FootballDie1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballDie/FootballDie0001.png"));
	private final static ImageIcon FootballDie2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballDie/FootballDie0002.png"));
	private final static ImageIcon FootballDie3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballDie/FootballDie0003.png"));
	private final static ImageIcon FootballDie4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballDie/FootballDie0004.png"));
	private final static ImageIcon FootballDie5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballDie/FootballDie0005.png"));
	private final static ImageIcon FootballDie6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballDie/FootballDie0006.png"));
	private final static ImageIcon FootballDie7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballDie/FootballDie0007.png"));
	private final static ImageIcon FootballDie8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballDie/FootballDie0008.png"));
	private final static ImageIcon FootballDie9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/FootballZombie/FootballDie/FootballDie0009.png"));
	
	private final static ImageIcon NewspaperMove0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperMove/NewspaperZombie0000.png"));
	private final static ImageIcon NewspaperMove1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperMove/NewspaperZombie0004.png"));
	private final static ImageIcon NewspaperMove2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperMove/NewspaperZombie0007.png"));
	private final static ImageIcon NewspaperMove3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperMove/NewspaperZombie0011.png"));
	private final static ImageIcon NewspaperMove4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperMove/NewspaperZombie0014.png"));
	private final static ImageIcon NewspaperMove5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperMove/NewspaperZombie0018.png"));
	private final static ImageIcon NewspaperMove6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperMove/NewspaperZombie0021.png"));
	private final static ImageIcon NewspaperMove7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperMove/NewspaperZombie0025.png"));
	private final static ImageIcon NewspaperMove8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperMove/NewspaperZombie0029.png"));
	private final static ImageIcon NewspaperMove9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperMove/NewspaperZombie0033.png"));
	
	private final static ImageIcon NewspaperAttack0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperAttack/NewspaperAttack0000.png"));
	private final static ImageIcon NewspaperAttack1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperAttack/NewspaperAttack0001.png"));
	private final static ImageIcon NewspaperAttack2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperAttack/NewspaperAttack0002.png"));
	private final static ImageIcon NewspaperAttack3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperAttack/NewspaperAttack0003.png"));
	private final static ImageIcon NewspaperAttack4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperAttack/NewspaperAttack0004.png"));
	private final static ImageIcon NewspaperAttack5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperAttack/NewspaperAttack0005.png"));
	private final static ImageIcon NewspaperAttack6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperAttack/NewspaperAttack0006.png"));
	private final static ImageIcon NewspaperAttack7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperAttack/NewspaperAttack0007.png"));
	private final static ImageIcon NewspaperAttack8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperAttack/NewspaperAttack0008.png"));
	private final static ImageIcon NewspaperAttack9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperAttack/NewspaperAttack0008.png"));
	
	private final static ImageIcon NewspaperDie0 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperDie/NewspaperDie0000.png"));
	private final static ImageIcon NewspaperDie1 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperDie/NewspaperDie0001.png"));
	private final static ImageIcon NewspaperDie2 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperDie/NewspaperDie0002.png"));
	private final static ImageIcon NewspaperDie3 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperDie/NewspaperDie0003.png"));
	private final static ImageIcon NewspaperDie4 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperDie/NewspaperDie0004.png"));
	private final static ImageIcon NewspaperDie5 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperDie/NewspaperDie0005.png"));
	private final static ImageIcon NewspaperDie6 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperDie/NewspaperDie0006.png"));
	private final static ImageIcon NewspaperDie7 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperDie/NewspaperDie0007.png"));
	private final static ImageIcon NewspaperDie8 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperDie/NewspaperDie0008.png"));
	private final static ImageIcon NewspaperDie9 = new ImageIcon(
			Zombie.class.getResource("/Resource/images/Zombies/NewspaperZombie/NewspaperDie/NewspaperDie0009.png"));
	
	private JLabel z0,z1,z2,z3,z4,z5,z6,z7,z8,z9,
	zAttack0,zAttack1,zAttack2,zAttack3,zAttack4,zAttack5,zAttack6,zAttack7,zAttack8,zAttack9,
	zDie0,zDie1,zDie2,zDie3,zDie4,zDie5,zDie6,zDie7,zDie8,zDie9;
	private JFrame zFrame;
	@SuppressWarnings("unchecked")
	public static ArrayList<Zombie>[] zombies = new ArrayList[5];
	private boolean gameOver,eat = false;
	public Zombie(int type, JFrame frame){
		zFrame = frame;
		x = 950;
		y = (int)(Math.random() * 5);
		attack_Point = 10;
		if(type == 0) move_Speed = 11;
		
		else move_Speed = 8 + type * 3;
		hit_Point = (type + 1) * 100;
		isSlow = false;
		isMove = true;
		gameOver = false;
		if (type == 0) {
			
			z0 = new JLabel(NormalZombie0);
			z1 = new JLabel(NormalZombie1);
			z2 = new JLabel(NormalZombie2);
			z3 = new JLabel(NormalZombie3);
			z4 = new JLabel(NormalZombie4);
			z5 = new JLabel(NormalZombie5);
			z6 = new JLabel(NormalZombie6);
			z7 = new JLabel(NormalZombie7);
			z8 = new JLabel(NormalZombie8);
			z9 = new JLabel(NormalZombie9);
			zAttack0 = new JLabel(NormalAttack0);
			zAttack1 = new JLabel(NormalAttack1);
			zAttack2 = new JLabel(NormalAttack2);
			zAttack3 = new JLabel(NormalAttack3);
			zAttack4 = new JLabel(NormalAttack4);
			zAttack5 = new JLabel(NormalAttack5);
			zAttack6 = new JLabel(NormalAttack6);
			zAttack7 = new JLabel(NormalAttack7);
			zAttack8 = new JLabel(NormalAttack8);
			zAttack9 = new JLabel(NormalAttack9);
			zDie0 = new JLabel(NormalDie0);
			zDie1 = new JLabel(NormalDie1);
			zDie2 = new JLabel(NormalDie2);
			zDie3 = new JLabel(NormalDie3);
			zDie4 = new JLabel(NormalDie4);
			zDie5 = new JLabel(NormalDie5);
			zDie6 = new JLabel(NormalDie6);
			zDie7 = new JLabel(NormalDie7);
			zDie8 = new JLabel(NormalDie8);
			zDie9 = new JLabel(NormalDie9);
			
			
			z0.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z1.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z2.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z3.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z4.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z5.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z6.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z7.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z8.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z9.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack0.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack1.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack2.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack3.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack4.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack5.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack6.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack7.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack8.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack9.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie0.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie1.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie2.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie3.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie4.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie5.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie6.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie7.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie8.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie9.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			
			z0.setVisible(false);
			z1.setVisible(false);
			z2.setVisible(false);
			z3.setVisible(false);
			z4.setVisible(false);
			z5.setVisible(false);
			z6.setVisible(false);
			z7.setVisible(false);
			z8.setVisible(false);
			z9.setVisible(false);
			zAttack0.setVisible(false);
			zAttack1.setVisible(false);
			zAttack2.setVisible(false);
			zAttack3.setVisible(false);
			zAttack4.setVisible(false);
			zAttack5.setVisible(false);
			zAttack6.setVisible(false);
			zAttack7.setVisible(false);
			zAttack8.setVisible(false);
			zAttack9.setVisible(false);
			zDie0.setVisible(false);
			zDie1.setVisible(false);
			zDie2.setVisible(false);
			zDie3.setVisible(false);
			zDie4.setVisible(false);
			zDie5.setVisible(false);
			zDie6.setVisible(false);
			zDie7.setVisible(false);
			zDie8.setVisible(false);
			zDie9.setVisible(false);
			
			zFrame.add(z0);
			zFrame.add(z1);
			zFrame.add(z2);
			zFrame.add(z3);
			zFrame.add(z4);
			zFrame.add(z5);
			zFrame.add(z6);
			zFrame.add(z7);
			zFrame.add(z8);
			zFrame.add(z9);
			zFrame.add(zAttack0);
			zFrame.add(zAttack1);
			zFrame.add(zAttack2);
			zFrame.add(zAttack3);
			zFrame.add(zAttack4);
			zFrame.add(zAttack5);
			zFrame.add(zAttack6);
			zFrame.add(zAttack7);
			zFrame.add(zAttack8);
			zFrame.add(zAttack9);
			zFrame.add(zDie0);
			zFrame.add(zDie1);
			zFrame.add(zDie2);
			zFrame.add(zDie3);
			zFrame.add(zDie4);
			zFrame.add(zDie5);
			zFrame.add(zDie6);
			zFrame.add(zDie7);
			zFrame.add(zDie8);
			zFrame.add(zDie9);
		
		}

		if(type == 1) {

			z0 = new JLabel(ConeheadMove0);
			z1 = new JLabel(ConeheadMove1);
			z2 = new JLabel(ConeheadMove2);
			z3 = new JLabel(ConeheadMove3);
			z4 = new JLabel(ConeheadMove4);
			z5 = new JLabel(ConeheadMove5);
			z6 = new JLabel(ConeheadMove6);
			z7 = new JLabel(ConeheadMove7);
			z8 = new JLabel(ConeheadMove8);
			z9 = new JLabel(ConeheadMove9);
			zAttack0 = new JLabel(ConeheadAttack0);
			zAttack1 = new JLabel(ConeheadAttack1);
			zAttack2 = new JLabel(ConeheadAttack2);
			zAttack3 = new JLabel(ConeheadAttack3);
			zAttack4 = new JLabel(ConeheadAttack4);
			zAttack5 = new JLabel(ConeheadAttack5);
			zAttack6 = new JLabel(ConeheadAttack6);
			zAttack7 = new JLabel(ConeheadAttack7);
			zAttack8 = new JLabel(ConeheadAttack8);
			zAttack9 = new JLabel(ConeheadAttack9);
			zDie0 = new JLabel(NormalDie0);
			zDie1 = new JLabel(NormalDie1);
			zDie2 = new JLabel(NormalDie2);
			zDie3 = new JLabel(NormalDie3);
			zDie4 = new JLabel(NormalDie4);
			zDie5 = new JLabel(NormalDie5);
			zDie6 = new JLabel(NormalDie6);
			zDie7 = new JLabel(NormalDie7);
			zDie8 = new JLabel(NormalDie8);
			zDie9 = new JLabel(NormalDie9);
			
			
			z0.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z1.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z2.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z3.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z4.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z5.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z6.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z7.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z8.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z9.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack0.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack1.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack2.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack3.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack4.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack5.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack6.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack7.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack8.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack9.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie0.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie1.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie2.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie3.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie4.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie5.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie6.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie7.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie8.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie9.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			
			z0.setVisible(false);
			z1.setVisible(false);
			z2.setVisible(false);
			z3.setVisible(false);
			z4.setVisible(false);
			z5.setVisible(false);
			z6.setVisible(false);
			z7.setVisible(false);
			z8.setVisible(false);
			z9.setVisible(false);
			zAttack0.setVisible(false);
			zAttack1.setVisible(false);
			zAttack2.setVisible(false);
			zAttack3.setVisible(false);
			zAttack4.setVisible(false);
			zAttack5.setVisible(false);
			zAttack6.setVisible(false);
			zAttack7.setVisible(false);
			zAttack8.setVisible(false);
			zAttack9.setVisible(false);
			zDie0.setVisible(false);
			zDie1.setVisible(false);
			zDie2.setVisible(false);
			zDie3.setVisible(false);
			zDie4.setVisible(false);
			zDie5.setVisible(false);
			zDie6.setVisible(false);
			zDie7.setVisible(false);
			zDie8.setVisible(false);
			zDie9.setVisible(false);
			
			zFrame.add(z0);
			zFrame.add(z1);
			zFrame.add(z2);
			zFrame.add(z3);
			zFrame.add(z4);
			zFrame.add(z5);
			zFrame.add(z6);
			zFrame.add(z7);
			zFrame.add(z8);
			zFrame.add(z9);
			zFrame.add(zAttack0);
			zFrame.add(zAttack1);
			zFrame.add(zAttack2);
			zFrame.add(zAttack3);
			zFrame.add(zAttack4);
			zFrame.add(zAttack5);
			zFrame.add(zAttack6);
			zFrame.add(zAttack7);
			zFrame.add(zAttack8);
			zFrame.add(zAttack9);
			zFrame.add(zDie0);
			zFrame.add(zDie1);
			zFrame.add(zDie2);
			zFrame.add(zDie3);
			zFrame.add(zDie4);
			zFrame.add(zDie5);
			zFrame.add(zDie6);
			zFrame.add(zDie7);
			zFrame.add(zDie8);
			zFrame.add(zDie9);
		
		}
		if(type == 2) {

			z0 = new JLabel(BucketheadMove0);
			z1 = new JLabel(BucketheadMove1);
			z2 = new JLabel(BucketheadMove2);
			z3 = new JLabel(BucketheadMove3);
			z4 = new JLabel(BucketheadMove4);
			z5 = new JLabel(BucketheadMove5);
			z6 = new JLabel(BucketheadMove6);
			z7 = new JLabel(BucketheadMove7);
			z8 = new JLabel(BucketheadMove8);
			z9 = new JLabel(BucketheadMove9);
			zAttack0 = new JLabel(BucketheadAttack0);
			zAttack1 = new JLabel(BucketheadAttack1);
			zAttack2 = new JLabel(BucketheadAttack2);
			zAttack3 = new JLabel(BucketheadAttack3);
			zAttack4 = new JLabel(BucketheadAttack4);
			zAttack5 = new JLabel(BucketheadAttack5);
			zAttack6 = new JLabel(BucketheadAttack6);
			zAttack7 = new JLabel(BucketheadAttack7);
			zAttack8 = new JLabel(BucketheadAttack8);
			zAttack9 = new JLabel(BucketheadAttack9);
			zDie0 = new JLabel(NormalDie0);
			zDie1 = new JLabel(NormalDie1);
			zDie2 = new JLabel(NormalDie2);
			zDie3 = new JLabel(NormalDie3);
			zDie4 = new JLabel(NormalDie4);
			zDie5 = new JLabel(NormalDie5);
			zDie6 = new JLabel(NormalDie6);
			zDie7 = new JLabel(NormalDie7);
			zDie8 = new JLabel(NormalDie8);
			zDie9 = new JLabel(NormalDie9);
			
			
			z0.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z1.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z2.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z3.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z4.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z5.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z6.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z7.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z8.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			z9.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack0.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack1.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack2.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack3.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack4.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack5.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack6.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack7.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack8.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zAttack9.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie0.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie1.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie2.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie3.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie4.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie5.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie6.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie7.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie8.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			zDie9.setBounds(this.x, 40 + y * 90, NormalW, NormalH);
			
			z0.setVisible(false);
			z1.setVisible(false);
			z2.setVisible(false);
			z3.setVisible(false);
			z4.setVisible(false);
			z5.setVisible(false);
			z6.setVisible(false);
			z7.setVisible(false);
			z8.setVisible(false);
			z9.setVisible(false);
			zAttack0.setVisible(false);
			zAttack1.setVisible(false);
			zAttack2.setVisible(false);
			zAttack3.setVisible(false);
			zAttack4.setVisible(false);
			zAttack5.setVisible(false);
			zAttack6.setVisible(false);
			zAttack7.setVisible(false);
			zAttack8.setVisible(false);
			zAttack9.setVisible(false);
			zDie0.setVisible(false);
			zDie1.setVisible(false);
			zDie2.setVisible(false);
			zDie3.setVisible(false);
			zDie4.setVisible(false);
			zDie5.setVisible(false);
			zDie6.setVisible(false);
			zDie7.setVisible(false);
			zDie8.setVisible(false);
			zDie9.setVisible(false);
			
			zFrame.add(z0);
			zFrame.add(z1);
			zFrame.add(z2);
			zFrame.add(z3);
			zFrame.add(z4);
			zFrame.add(z5);
			zFrame.add(z6);
			zFrame.add(z7);
			zFrame.add(z8);
			zFrame.add(z9);
			zFrame.add(zAttack0);
			zFrame.add(zAttack1);
			zFrame.add(zAttack2);
			zFrame.add(zAttack3);
			zFrame.add(zAttack4);
			zFrame.add(zAttack5);
			zFrame.add(zAttack6);
			zFrame.add(zAttack7);
			zFrame.add(zAttack8);
			zFrame.add(zAttack9);
			zFrame.add(zDie0);
			zFrame.add(zDie1);
			zFrame.add(zDie2);
			zFrame.add(zDie3);
			zFrame.add(zDie4);
			zFrame.add(zDie5);
			zFrame.add(zDie6);
			zFrame.add(zDie7);
			zFrame.add(zDie8);
			zFrame.add(zDie9);
		
		}
		if(type == 3) {

			z0 = new JLabel(NewspaperMove0);
			z1 = new JLabel(NewspaperMove1);
			z2 = new JLabel(NewspaperMove2);
			z3 = new JLabel(NewspaperMove3);
			z4 = new JLabel(NewspaperMove4);
			z5 = new JLabel(NewspaperMove5);
			z6 = new JLabel(NewspaperMove6);
			z7 = new JLabel(NewspaperMove7);
			z8 = new JLabel(NewspaperMove8);
			z9 = new JLabel(NewspaperMove9);
			zAttack0 = new JLabel(NewspaperAttack0);
			zAttack1 = new JLabel(NewspaperAttack1);
			zAttack2 = new JLabel(NewspaperAttack2);
			zAttack3 = new JLabel(NewspaperAttack3);
			zAttack4 = new JLabel(NewspaperAttack4);
			zAttack5 = new JLabel(NewspaperAttack5);
			zAttack6 = new JLabel(NewspaperAttack6);
			zAttack7 = new JLabel(NewspaperAttack7);
			zAttack8 = new JLabel(NewspaperAttack8);
			zAttack9 = new JLabel(NewspaperAttack9);
			zDie0 = new JLabel(NewspaperDie0);
			zDie1 = new JLabel(NewspaperDie1);
			zDie2 = new JLabel(NewspaperDie2);
			zDie3 = new JLabel(NewspaperDie3);
			zDie4 = new JLabel(NewspaperDie4);
			zDie5 = new JLabel(NewspaperDie5);
			zDie6 = new JLabel(NewspaperDie6);
			zDie7 = new JLabel(NewspaperDie7);
			zDie8 = new JLabel(NewspaperDie8);
			zDie9 = new JLabel(NewspaperDie9);
			
			
			z0.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			z1.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			z2.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			z3.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			z4.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			z5.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			z6.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			z7.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			z8.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			z9.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zAttack0.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zAttack1.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zAttack2.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zAttack3.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zAttack4.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zAttack5.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zAttack6.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zAttack7.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zAttack8.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zAttack9.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zDie0.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zDie1.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zDie2.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zDie3.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zDie4.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zDie5.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zDie6.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zDie7.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zDie8.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			zDie9.setBounds(this.x, 20 + y * 90, NewspaperW, NewspaperH);
			
			z0.setVisible(false);
			z1.setVisible(false);
			z2.setVisible(false);
			z3.setVisible(false);
			z4.setVisible(false);
			z5.setVisible(false);
			z6.setVisible(false);
			z7.setVisible(false);
			z8.setVisible(false);
			z9.setVisible(false);
			zAttack0.setVisible(false);
			zAttack1.setVisible(false);
			zAttack2.setVisible(false);
			zAttack3.setVisible(false);
			zAttack4.setVisible(false);
			zAttack5.setVisible(false);
			zAttack6.setVisible(false);
			zAttack7.setVisible(false);
			zAttack8.setVisible(false);
			zAttack9.setVisible(false);
			zDie0.setVisible(false);
			zDie1.setVisible(false);
			zDie2.setVisible(false);
			zDie3.setVisible(false);
			zDie4.setVisible(false);
			zDie5.setVisible(false);
			zDie6.setVisible(false);
			zDie7.setVisible(false);
			zDie8.setVisible(false);
			zDie9.setVisible(false);
			
			zFrame.add(z0);
			zFrame.add(z1);
			zFrame.add(z2);
			zFrame.add(z3);
			zFrame.add(z4);
			zFrame.add(z5);
			zFrame.add(z6);
			zFrame.add(z7);
			zFrame.add(z8);
			zFrame.add(z9);
			zFrame.add(zAttack0);
			zFrame.add(zAttack1);
			zFrame.add(zAttack2);
			zFrame.add(zAttack3);
			zFrame.add(zAttack4);
			zFrame.add(zAttack5);
			zFrame.add(zAttack6);
			zFrame.add(zAttack7);
			zFrame.add(zAttack8);
			zFrame.add(zAttack9);
			zFrame.add(zDie0);
			zFrame.add(zDie1);
			zFrame.add(zDie2);
			zFrame.add(zDie3);
			zFrame.add(zDie4);
			zFrame.add(zDie5);
			zFrame.add(zDie6);
			zFrame.add(zDie7);
			zFrame.add(zDie8);
			zFrame.add(zDie9);
		
		}
		if(type == 4) {

			z0 = new JLabel(FootballMove0);
			z1 = new JLabel(FootballMove1);
			z2 = new JLabel(FootballMove2);
			z3 = new JLabel(FootballMove3);
			z4 = new JLabel(FootballMove4);
			z5 = new JLabel(FootballMove5);
			z6 = new JLabel(FootballMove6);
			z7 = new JLabel(FootballMove7);
			z8 = new JLabel(FootballMove8);
			z9 = new JLabel(FootballMove9);
			zAttack0 = new JLabel(FootballAttack0);
			zAttack1 = new JLabel(FootballAttack1);
			zAttack2 = new JLabel(FootballAttack2);
			zAttack3 = new JLabel(FootballAttack3);
			zAttack4 = new JLabel(FootballAttack4);
			zAttack5 = new JLabel(FootballAttack5);
			zAttack6 = new JLabel(FootballAttack6);
			zAttack7 = new JLabel(FootballAttack7);
			zAttack8 = new JLabel(FootballAttack8);
			zAttack9 = new JLabel(FootballAttack9);
			zDie0 = new JLabel(FootballDie0);
			zDie1 = new JLabel(FootballDie1);
			zDie2 = new JLabel(FootballDie2);
			zDie3 = new JLabel(FootballDie3);
			zDie4 = new JLabel(FootballDie4);
			zDie5 = new JLabel(FootballDie5);
			zDie6 = new JLabel(FootballDie6);
			zDie7 = new JLabel(FootballDie7);
			zDie8 = new JLabel(FootballDie8);
			zDie9 = new JLabel(FootballDie9);
			
			
			z0.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			z1.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			z2.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			z3.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			z4.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			z5.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			z6.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			z7.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			z8.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			z9.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zAttack0.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zAttack1.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zAttack2.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zAttack3.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zAttack4.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zAttack5.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zAttack6.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zAttack7.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zAttack8.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zAttack9.setBounds(this.x, 20 + y * 90, FootballW, FootballH);
			zDie0.setBounds(this.x, 20 + y * 90, FootballDieW, FootballDieH);
			zDie1.setBounds(this.x, 20 + y * 90, FootballDieW, FootballDieH);
			zDie2.setBounds(this.x, 20 + y * 90, FootballDieW, FootballDieH);
			zDie3.setBounds(this.x, 20 + y * 90, FootballDieW, FootballDieH);
			zDie4.setBounds(this.x, 20 + y * 90, FootballDieW, FootballDieH);
			zDie5.setBounds(this.x, 20 + y * 90, FootballDieW, FootballDieH);
			zDie6.setBounds(this.x, 20 + y * 90, FootballDieW, FootballDieH);
			zDie7.setBounds(this.x, 20 + y * 90, FootballDieW, FootballDieH);
			zDie8.setBounds(this.x, 20 + y * 90, FootballDieW, FootballDieH);
			zDie9.setBounds(this.x, 20 + y * 90, FootballDieW, FootballDieH);
			
			z0.setVisible(false);
			z1.setVisible(false);
			z2.setVisible(false);
			z3.setVisible(false);
			z4.setVisible(false);
			z5.setVisible(false);
			z6.setVisible(false);
			z7.setVisible(false);
			z8.setVisible(false);
			z9.setVisible(false);
			zAttack0.setVisible(false);
			zAttack1.setVisible(false);
			zAttack2.setVisible(false);
			zAttack3.setVisible(false);
			zAttack4.setVisible(false);
			zAttack5.setVisible(false);
			zAttack6.setVisible(false);
			zAttack7.setVisible(false);
			zAttack8.setVisible(false);
			zAttack9.setVisible(false);
			zDie0.setVisible(false);
			zDie1.setVisible(false);
			zDie2.setVisible(false);
			zDie3.setVisible(false);
			zDie4.setVisible(false);
			zDie5.setVisible(false);
			zDie6.setVisible(false);
			zDie7.setVisible(false);
			zDie8.setVisible(false);
			zDie9.setVisible(false);
			
			zFrame.add(z0);
			zFrame.add(z1);
			zFrame.add(z2);
			zFrame.add(z3);
			zFrame.add(z4);
			zFrame.add(z5);
			zFrame.add(z6);
			zFrame.add(z7);
			zFrame.add(z8);
			zFrame.add(z9);
			zFrame.add(zAttack0);
			zFrame.add(zAttack1);
			zFrame.add(zAttack2);
			zFrame.add(zAttack3);
			zFrame.add(zAttack4);
			zFrame.add(zAttack5);
			zFrame.add(zAttack6);
			zFrame.add(zAttack7);
			zFrame.add(zAttack8);
			zFrame.add(zAttack9);
			zFrame.add(zDie0);
			zFrame.add(zDie1);
			zFrame.add(zDie2);
			zFrame.add(zDie3);
			zFrame.add(zDie4);
			zFrame.add(zDie5);
			zFrame.add(zDie6);
			zFrame.add(zDie7);
			zFrame.add(zDie8);
			zFrame.add(zDie9);
		
		}
		zombies[y].add(this);
		new Thread(new moveZombie()).start();
	
	}
	
	public boolean isBurned() {
		return isBurned;
	}
	public void setBurned(boolean isBurned) {
		this.isBurned = isBurned;
	}
	public class moveZombie implements Runnable{
		
		@SuppressWarnings("unlikely-arg-type")
		@Override
		public void run() {
			while(hit_Point > 0)
			{
				try {
					if(x <= 880) {
						
						if (GameGUI.plants[y][(x + 20 - 240) / 75] != null){
							isMove = false;
							eat = true;
							GameGUI.plants[y][(x  + 20- 240) / 75].setHp(GameGUI.plants[y][(x + 20 - 240) / 75].getHp() - attack_Point);
						}
						else isMove = true;
					}
					if (isMove) {
						if (isSlow) x -= (move_Speed / 20);
						else x -= move_Speed / 10;
		
						z0.setVisible(true);
						z0.setLocation(x,40 + y * 90);	
						Thread.sleep(120);
						z0.setVisible(false);
						
						if (isSlow) x -= (move_Speed / 20);
						else x -= move_Speed / 10;
		
						z1.setVisible(true);
						z1.setLocation(x,40 + y * 90);	
						Thread.sleep(120);
						z1.setVisible(false);
						
						if (isSlow) x -= (move_Speed / 20);
						else x -= move_Speed / 10;
		
						z2.setVisible(true);
						z2.setLocation(x,40 + y * 90);	
						Thread.sleep(120);
						z2.setVisible(false);
	
						if (isSlow) x -= (move_Speed / 20);
						else x -= move_Speed / 10;
		
						z3.setVisible(true);
						z3.setLocation(x,40 + y * 90);	
						Thread.sleep(120);
						z3.setVisible(false);
						
						if (isSlow) x -= (move_Speed / 20);
						else x -= move_Speed / 10;
		
						z4.setVisible(true);
						z4.setLocation(x,40 + y * 90);	
						Thread.sleep(120);
						z4.setVisible(false);
						
						if (isSlow) x -= (move_Speed / 20);
						else x -= move_Speed / 10;
		
						z5.setVisible(true);
						z5.setLocation(x,40 + y * 90);	
						Thread.sleep(120);
						z5.setVisible(false);
						
						if (isSlow) x -= (move_Speed / 20);
						else x -= move_Speed / 10;
		
						z6.setVisible(true);
						z6.setLocation(x,40 + y * 90);	
						Thread.sleep(120);
						z6.setVisible(false);
						
						if (isSlow) x -= (move_Speed / 20);
						else x -= move_Speed / 10;
		
						z7.setVisible(true);
						z7.setLocation(x,40 + y * 90);	
						Thread.sleep(120);
						z7.setVisible(false);
						
						z8.setVisible(true);
						z8.setLocation(x,40 + y * 90);	
						Thread.sleep(120);
						z8.setVisible(false);
						
						z9.setVisible(true);
						z9.setLocation(x,40 + y * 90);	
						Thread.sleep(120);
						z9.setVisible(false);
					}else {
						
						AudioPlayer t1 = new AudioPlayer("Resource/audio/chomp.mp3");
						Thread t =new Thread(t1);
				        t.start();
				        
						zAttack0.setVisible(true);
						zAttack0.setLocation(x,40 + y * 90);
						Thread.sleep(120);
						zAttack0.setVisible(false);
						
						zAttack1.setVisible(true);
						zAttack1.setLocation(x,40 + y * 90);
						Thread.sleep(120);
						zAttack1.setVisible(false);
						
						zAttack2.setVisible(true);
						zAttack2.setLocation(x,40 + y * 90);
						Thread.sleep(120);
						zAttack2.setVisible(false);
						
						zAttack3.setVisible(true);
						zAttack3.setLocation(x,40 + y * 90);
						Thread.sleep(120);
						zAttack3.setVisible(false);
						
						zAttack4.setVisible(true);
						zAttack4.setLocation(x,40 + y * 90);
						Thread.sleep(120);
						zAttack4.setVisible(false);
						
						zAttack5.setVisible(true);
						zAttack5.setLocation(x,40 + y * 90);
						Thread.sleep(120);
						zAttack5.setVisible(false);
						
						zAttack6.setVisible(true);
						zAttack6.setLocation(x,40 + y * 90);
						Thread.sleep(120);
						zAttack6.setVisible(false);
						
						zAttack7.setVisible(true);
						zAttack7.setLocation(x,40 + y * 90);
						Thread.sleep(120);
						zAttack7.setVisible(false);
						
						zAttack8.setVisible(true);
						zAttack8.setLocation(x,40 + y * 90);
						Thread.sleep(120);
						zAttack8.setVisible(false);
						
						zAttack9.setVisible(true);
						zAttack9.setLocation(x,40 + y * 90);
						Thread.sleep(120);
						zAttack9.setVisible(false);
						
						if(eat == true) {
							Thread musiThread = new Thread(new eatMusic());
							musiThread.start();
							eat = false;
						}
					}
					if (x <= 150) {
						gameOver = true;
						break;
					}
				
					
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				
			}
			
				try {
					zDie0.setVisible(true);
					zDie0.setLocation(x,40 + y * 90);
					Thread.sleep(120);
					zDie0.setVisible(false);
					
					zDie1.setVisible(true);
					zDie1.setLocation(x,40 + y * 90);
					Thread.sleep(120);
					zDie1.setVisible(false);
					
					zDie2.setVisible(true);
					zDie2.setLocation(x,40 + y * 90);
					Thread.sleep(120);
					zDie2.setVisible(false);
					
					zDie3.setVisible(true);
					zDie3.setLocation(x,40 + y * 90);
					Thread.sleep(120);
					zDie3.setVisible(false);
					
					zDie4.setVisible(true);
					zDie4.setLocation(x,40 + y * 90);
					Thread.sleep(120);
					zDie4.setVisible(false);
					
					zDie5.setVisible(true);
					zDie5.setLocation(x,40 + y * 90);
					Thread.sleep(120);
					zDie5.setVisible(false);
					
					zDie6.setVisible(true);
					zDie6.setLocation(x,40 + y * 90);
					Thread.sleep(120);
					zDie6.setVisible(false);
					
					zDie7.setVisible(true);
					zDie7.setLocation(x,40 + y * 90);
					Thread.sleep(120);
					zDie7.setVisible(false);
					
					zDie8.setVisible(true);
					zDie8.setLocation(x,40 + y * 90);
					Thread.sleep(120);
					zDie8.setVisible(false);
					
					zDie9.setVisible(true);
					zDie9.setLocation(x,40 + y * 90);
					Thread.sleep(1200);
					zDie9.setVisible(false);
					
					zombies[y].remove(this);
					zFrame.remove(z0);
					zFrame.remove(z1);
					zFrame.remove(z2);
					zFrame.remove(z3);
					zFrame.remove(z4);
					zFrame.remove(z5);
					zFrame.remove(z6);
					zFrame.remove(z7);
					zFrame.remove(z8);
					zFrame.remove(z9);
					zFrame.remove(zAttack0);
					zFrame.remove(zAttack1);
					zFrame.remove(zAttack2);
					zFrame.remove(zAttack3);
					zFrame.remove(zAttack4);
					zFrame.remove(zAttack5);
					zFrame.remove(zAttack6);
					zFrame.remove(zAttack7);
					zFrame.remove(zAttack8);
					zFrame.remove(zAttack9);
					zFrame.remove(zDie0);
					zFrame.remove(zDie1);
					zFrame.remove(zDie2);
					zFrame.remove(zDie3);
					zFrame.remove(zDie4);
					zFrame.remove(zDie5);
					zFrame.remove(zDie6);
					zFrame.remove(zDie7);
					zFrame.remove(zDie8);
					zFrame.remove(zDie9);
					zFrame.invalidate();
				} catch (InterruptedException e) {
					e.printStackTrace();
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
	public int getAttack_Point() {
		return attack_Point;
	}
	public void setAttack_Point(int attack_Point) {
		this.attack_Point = attack_Point;
	}
	public int getMove_Speed() {
		return move_Speed;
	}
	public void setMove_Speed(int move_Speed) {
		this.move_Speed = move_Speed;
	}
	public int getHit_Point() {
		return hit_Point;
	}
	public void setHit_Point(int hit_Point) {
		this.hit_Point = hit_Point;
	}
	public boolean isSlow() {
		return isSlow;
	}
	public void setSlow(boolean isSlow) {
		this.isSlow = isSlow;
	}
	public boolean isMove() {
		return isMove;
	}
	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

}