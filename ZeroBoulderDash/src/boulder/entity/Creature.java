/**
 * 
 */
package boulder.entity;


import boulder.game.Handler;
import boulder.model.Tile;

/**
 * @author liabe
 *
 */
public abstract class Creature extends Entity {
	
	
	
	public static final float DEFAULT_SPEED = 4.0f;
	
	public static final int DEFAULT_WIDTH = 32, 
							DEFAULT_HEIGHT = 32 ; 
	
	
	protected float speed ; 
	
	protected float xMove , yMove ; 

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove =0 ; 
		yMove = 0 ; 
		// TODO Auto-generated constructor stub
	}
	
	public void move () {
		if (!checkEntityCollinsion(xMove, 0f)) {
			moveX();
			
	}
		
		if (!checkEntityCollinsion(0f, yMove)) {
			moveY();
		}
	}
	
	public void moveX() {
		if(xMove > 0 ) { // moving right
			int tx = (int)(x + xMove + bounds.x + bounds.width ) / Tile.TILE_WIDTH ;
			
			if (!collisionWithTile(tx, (int) (y + bounds.y )/ Tile.TILE_HEIGHT) 
					&&  !collisionWithTile(tx, (int) (y + bounds.y + bounds.height )/ Tile.TILE_HEIGHT) ) {
				x += xMove;
				
			}else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width -1 ;
			}
			
		}else if (xMove <0) { // moving left 
			int tx = (int)(x + xMove + bounds.x  ) / Tile.TILE_WIDTH ;
			 
			if (!collisionWithTile(tx, (int) (y + bounds.y )/ Tile.TILE_HEIGHT) 
					&&  !collisionWithTile(tx, (int) (y + bounds.y + bounds.height )/ Tile.TILE_HEIGHT) ) {
				x += xMove;
				
			}else {
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x ; 
			}
		}
	}
	
	public void moveY() {
		if (yMove < 0) {//UP
			
			int ty = (int)(y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			
			if (!collisionWithTile( (int) (x + bounds.x )/ Tile.TILE_WIDTH, ty) 
					&& !collisionWithTile( (int) (x + bounds.x + bounds.width)/ Tile.TILE_WIDTH, ty)) {
				y += yMove ;
				
			}else {
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y ; 
			}
			
		}else if(yMove > 0){ //Down
			
			int ty = (int)(y + yMove + bounds.y + bounds.height ) / Tile.TILE_HEIGHT;
			
			if (!collisionWithTile( (int) (x + bounds.x )/ Tile.TILE_WIDTH, ty) 
					&& !collisionWithTile( (int) (x + bounds.x + bounds.width)/ Tile.TILE_WIDTH, ty)) {
				y += yMove ;
				
			} else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height -1 ; 
			}
		}
	}
	
	protected boolean collisionWithTile (int x , int y ) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	/**
	 * Geeters and Stters 
	 */

	/**
	 * @return the xMove
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * @param xMove the xMove to set
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return the yMove
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * @param yMove the yMove to set
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	
	
	

}
