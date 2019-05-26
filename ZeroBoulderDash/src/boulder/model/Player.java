 /**
 * 
 */
package boulder.model;

import java.awt.Graphics;

import boulder.display.Assets;
import boulder.game.Game;

/**
 * @author liabe
 *
 */
public class Player extends Creature {
	
	private Game game ; 

	public Player(Game game,float x, float y) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_WIDTH);
		this.game = game ; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub 
	getInput () ;
	move();
		
		
	}
	
	private void getInput () {
		
		xMove = 0 ; 
		yMove = 0 ; 
		
		if (game.getKeyManager().up) {
			yMove = -speed;
		}else if (game.getKeyManager().down) {
			yMove = speed ; 
		}else if (game.getKeyManager().left) {
			xMove= -speed;
		}else if (game.getKeyManager().right){
			xMove = speed ;
		}
		
		
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		boulderMan (g) ;
	}
	
	/*
	 * call Sprite 
	 */
	public void boulderMan (Graphics g) {
		if (game.getKeyManager().up) {
			g.drawImage(Assets.playerUp, (int)x, (int)y,width,height, null);
		}else if (game.getKeyManager().down) {
			g.drawImage(Assets.playerDown, (int)x, (int)y,width,height, null);
		}else if (game.getKeyManager().left) {
			g.drawImage(Assets.playerLeft, (int)x, (int)y,width,height, null);
		}else if (game.getKeyManager().right){
			g.drawImage(Assets.playerRight, (int)x, (int)y,width,height, null);
		}else {
			g.drawImage(Assets.player, (int)x, (int)y,width,height, null);
		}
			
	}

}
