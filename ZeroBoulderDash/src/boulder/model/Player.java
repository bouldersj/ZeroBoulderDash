 /**
 * 
 */
package boulder.model;

import java.awt.Color;
import java.awt.Graphics;


import boulder.display.Assets;
import boulder.game.Handler;

/**
 * @author liabe
 *
 */
public class Player extends Creature {
	

	
	public Player(Handler handler,float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_WIDTH);
		// TODO Auto-generated constructor stub
		
		bounds.x = 4; 
		bounds.y = 8 ;
		bounds.width = 20 ; 
		bounds.height = 20 ; 
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub 
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
		// TODO Auto-generated method stub
		boulderMan (g) ;
		
		g.setClip(Color.TRANSLUCENT,0,0,0);
		g.fillRect((int) (x+ bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y+ bounds.y - handler.getGameCamera().getyOffset()), 
				bounds.width, bounds.height);
	}
	
	/*
	 * call Sprite 
	 */
	public void boulderMan (Graphics g) {
		if (handler.getKeyManager().up) {
			g.drawImage(Assets.playerUp, (int)(x - handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		}else if (handler.getKeyManager().down) {
			g.drawImage(Assets.playerDown, (int)(x - handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		}else if (handler.getKeyManager().left) {
			g.drawImage(Assets.playerLeft, (int)(x - handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		}else if (handler.getKeyManager().right){
			g.drawImage(Assets.playerRight, (int)(x - handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		}else {
			g.drawImage(Assets.player, (int)(x - handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		}
			
	}

}
