/**
 * 
 */
package boulder.model;


import boulder.entity.Entity;
import boulder.game.Handler;

/**
 * @author liabe
 *
 */
public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 10 ; 
	
	public static final float DEFAULT_SPEED = 4.0f;
	
	public static final int DEFAULT_WIDTH = 32, 
							DEFAULT_HEIGHT = 32 ; 
	
	protected int health ;
	
	protected float speed ; 
	
	protected float xMove , yMove ; 

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH ; 
		speed = DEFAULT_SPEED;
		xMove =0 ; 
		yMove = 0 ; 
		// TODO Auto-generated constructor stub
	}
	
	public void move () {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0 ) { // moving right
			int tx = (int)(x + xMove + bounds.x + bounds.width ) / Tile.TILE_WIDTH ;
			if (!collisionWithTile(tx, (int) (y + bounds.y )/ Tile.TILE_HEIGHT) 
					&&  !collisionWithTile(tx, (int) (y + bounds.y + bounds.height )/ Tile.TILE_HEIGHT) ) {
				x += xMove;
			}
		}else if (xMove <0) { // moving left 
			int tx = (int)(x + xMove + bounds.x  ) / Tile.TILE_WIDTH ;
			if (!collisionWithTile(tx, (int) (y + bounds.y )/ Tile.TILE_HEIGHT) 
					&&  !collisionWithTile(tx, (int) (y + bounds.y + bounds.height )/ Tile.TILE_HEIGHT) ) {
				x += xMove;
			}
		}
	}
	
	public void moveY() {
		if (yMove < 0) {//UP
			int ty = (int)(y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			if (!collisionWithTile( (int) (x + bounds.x )/ Tile.TILE_WIDTH, ty) 
					&& !collisionWithTile( (int) (x + bounds.x + bounds.width)/ Tile.TILE_WIDTH, ty)) {
				y += yMove ;
			}
		}else if(yMove > 0){ //Down
			int ty = (int)(y + yMove + bounds.y + bounds.height ) / Tile.TILE_HEIGHT;
			if (!collisionWithTile( (int) (x + bounds.x )/ Tile.TILE_WIDTH, ty) 
					&& !collisionWithTile( (int) (x + bounds.x + bounds.width)/ Tile.TILE_WIDTH, ty)) {
				y += yMove ;
				
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
