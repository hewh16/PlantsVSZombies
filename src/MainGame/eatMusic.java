package MainGame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.URI;
import java.net.URL;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

import javax.naming.directory.AttributeInUseException;

@SuppressWarnings({ "unused", "deprecation" })
public class eatMusic implements Runnable{

	@Override
	public void run() {
			
			try {  
				AudioPlayer t1 = new AudioPlayer("Resource/audio/chomp.mp3");
				Thread t =new Thread(t1);
				t.start();
		           
	           } catch (Exception e) 
	           { 
	            e.printStackTrace();
	           } 
			
		
		
	}
	
	

}

