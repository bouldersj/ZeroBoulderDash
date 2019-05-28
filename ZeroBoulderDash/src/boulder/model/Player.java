 /**
 * 
 */
package boulder.model;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import boulder.entity.Creature;
import boulder.game.Handler;

/**
 * @author liabel
 *
 */
public class Player extends Creature {
	/*
	 * Animation
	 */
	private Animation animIdle ,animLeft , animRight , animDown , animUp ; 
/**
 * 
 * @param handler
 * @param x
 * @param y
 */
	
	public Player(Handler handler,float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		// TODO Auto-generated constructor stub
		
		bounds.x = 4; 
		bounds.y = 8 ;
		bounds.width = 20 ; 
		bounds.height = 20 ; 
		/*
		 * animation speed and frame
		 */
		animLeft = new Animation(200, Assets.playerLeft);
		animIdle = new Animation(300, Assets.playerIdle);
		animDown = new Animation(200, Assets.playerDown);
		animRight = new Animation(200, Assets.playerRight);
		animUp = new Animation(200, Assets.playerUp);
		
	}

	@Override
	public void tick() {
		/*
		 * animation tick
		 */
	animLeft.tick();
	animRight.tick();
	animDown.tick();
	animUp.tick();
	animIdle.tick();
	/*
	 * Movement 
	 */
	getInput () ;
	move();
	handler.getGameCamera().centerOnEntity(this);
		
		
	}
	
	private void getInput () {
		
		xMove = 0 ; 
		yMove = 0 ; 
		
		if (handler.getKeyManager().up) {
			yMove = -speed;
		}else if (handler.getKeyManager().down) {
			yMove = speed ; 
		}else if (handler.getKeyManager().left) {
			xMove= -speed;
		}else if (handler.getKeyManager().right){
			xMove = speed ;
		}
		
		
		
	}

	@Override
	public void render(Graphics g) {


		boulderMan(g);
		/*g.setClip(Color.TRANSLUCENT,0,0,0);
		g.fillRect((int) (x+ bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y+ bounds.y - handler.getGameCamera().getyOffset()), 
				bounds.width, bounds.height);*/
	}
	
	/*
	 * call Sprite 
	 */
	public void boulderMan (Graphics g) {
		if (handler.getKeyManager().up) {
			
			g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset()),width,height, null);
			
		}else if (handler.getKeyManager().down) {
			
			g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset()),width,height, null);
			
		}else if (handler.getKeyManager().left) {
			
			g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset()),width,height, null);
			
		}else if (handler.getKeyManager().right){
			
			g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset()),width,height, null);
			
		}else {
			
			g.drawImage(getCurrentAnimationFrame(),(int)(x - handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		}
			
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		
		if (xMove < 0 ) {
			
			return animLeft.getCurrentFrame();
			
		}else if (xMove > 0) {
			
			return animRight.getCurrentFrame()	;
			
		}else if (yMove < 0 ) {
			
			return animUp.getCurrentFrame()	;
			
		}else if (yMove > 0 ) {
			
			return animDown.getCurrentFrame();
			
		}else {
			
			return animIdle.getCurrentFrame();
		}
			
	}

}//player
