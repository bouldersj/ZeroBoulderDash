/**
 * 
 */
package boulder.game;


import java.awt.Graphics;


import java.awt.image.BufferStrategy;

import boulder.controller.KeyManager;
import boulder.display.Display;
import boulder.display.GameCamera;
import boulder.model.Assets;

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
	//private State menuState;
	/**
	 * INPUT
	 */
	private KeyManager keyManager ; 
	
	/**
	 * camera
	 *
	 */
	private GameCamera gameCamera ; 
	/**
	 * Handler
	 */
	private Handler handler ; 
	
	public Game(String title, int width, int height)	{
		
		this.width = width ; 
		
		this.height = height ; 
		
		this.title = title ;
		
		keyManager= new KeyManager()	;
		 
		
	
		
	}//constructor
	

	
	private void init ()	{
		display = new Display (title, width, height)	;
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler (this); 
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		//menuState = new MenuState(handler);
		
		//State.setState(menuState);
		State.setState(gameState);

	}
	

	
	private void tick()	{
		
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
		
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

	/**
	 * 
	 * @return keyManager
	 * get Keys
	 */
	public  KeyManager getKeyManager()	{
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
		
		if (running) {
			 return;
		}
		running = true ; 
		thread = new Thread(this)	;
		thread.start();
	}
	
	public synchronized void stop () {
		if(!running) {
			return ;

		}
		running = false ;
		try {
			thread.join ()	;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}//Game
