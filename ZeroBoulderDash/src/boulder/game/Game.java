/**
 * 
 */
package boulder.game;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.net.ssl.KeyManager;

import boulder.display.Assets;
import boulder.display.Display;
import boulder.display.GameCamera;

/**
 * @author liabe
 *
 */
public class Game implements Runnable{
	/**
	 * 
	 * @param title
	 * @param width
	 * @param height
	 */
	
	public String title ; 

	private Display display ;
	
	private int width, height ; 
		
	private Thread thread ; 
		
	private boolean running = false ;

	private BufferStrategy bs ; 
	
	private Graphics g ;
	/**
	 * States
	 */
	private State gameState; 
	private State menuState;
	/**
	 * INPUT
	 */
	private boulder.controller.KeyManager keyManager ; 
	
	/**
	 * camera
	 *
	 */
	private GameCamera gameCamera ; 
	
	public Game(String title, int width, int height)	{
		
		this.width = width ; 
		
		this.height = height ; 
		
		this.title = title ;
		
		keyManager= new boulder.controller.KeyManager()	;
		 
		
	
		
	}//constructor
	

	
	private void init ()	{
		display = new Display (title, width, height)	;
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0, 0);
		gameState = new GameState(this);
		menuState = new MenuState(this);
		
		State.setState(gameState);

		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		init ();
		
		int fps = 60 ;
		int oneSec = 1000000000;
		double timePerTick = oneSec / fps ;
		double delta = 0 ; 
		long now ;
		long lastTime = System.nanoTime();
		long timer = 0 ;
		int ticks = 0 ;
		
		while (running) {
			
			now = System.nanoTime() ;
			delta += (now - lastTime) / timePerTick ;
			timer += now - lastTime ;
			lastTime = now ;
					
			if(delta >= 1) {
				tick();
				render();
				ticks ++ ;
				delta -- ;
			}
			
			if (timer > oneSec ) {
				//show FPS
				System.out.println("F :" + ticks);
				ticks = 0 ;
				timer = 0 ;
				
			}
			
		}
		
		stop () ; 
		
	}
	

	private void render ()	{
		
		
		bs = display.getCanvas().getBufferStrategy();
		
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//clear screan 
		g.clearRect(0,0,  width, height);
		
		//Drawing
	
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		//end drawing 
		bs.show();
		g.dispose();
		
	}
	

	
	private void tick()	{
		
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
		
	}
	
	/**
	 * 
	 * @return keyManager
	 * get Keys
	 */
	public boulder.controller.KeyManager getKeyManager()	{
		return keyManager ; 
	}
	
	public GameCamera getGameCamera () {
		return gameCamera ; 
	}
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * 
	 * @return the height
	 */
	public int getHeight() {
		return height ;
	}
		
	public synchronized void start () {
		
		if (running)
			return;
		running = true ; 
		thread = new Thread(this)	;
		thread.start();
	}
	
	public synchronized void stop () {
		if(!running)
			return ;
		running = false ;
		try {
			thread.join ()	;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}//Game
