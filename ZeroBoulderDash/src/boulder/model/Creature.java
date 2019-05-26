/**
 * 
 */
package boulder.model;


import boulder.entity.Entity;

/**
 * @author liabe
 *
 */
public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 10 ; 
	
	public static final float DEFAULT_SPEED = 2.0f;
	
	public static final int DEFAULT_WIDTH = 32, 
							DEFAULT_HEIGHT = 32 ; 
	
	protected int health ;
	
	protected float speed ; 
	
	protected float xMove , yMove ; 

	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		health = DEFAULT_HEALTH ; 
		speed = DEFAULT_SPEED;
		xMove =0 ; 
		yMove = 0 ; 
		// TODO Auto-generated constructor stub
	}
	
	public void move () {
		x+= xMove ; 
		y+=yMove ;
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
