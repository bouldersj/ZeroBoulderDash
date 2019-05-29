/**
 * 
 */
package boulder.entity;


import java.awt.Rectangle;

import boulder.game.Handler;

/**
 * @author liabe
 *
 */
public abstract class  Entity implements TickRender {

	public static final int DEFAULT_HEALTH = 10 ; 
	
	protected int health ;
	protected Handler handler ; 
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds ; 
	protected boolean active = true;
	
	
	public Entity (Handler handler ,float x , float y, int width, int height) {
		this.handler = handler ; 
		this.x = x; 
		this.y = y;
		this.width = width ; 
		this.height = height;
		health = DEFAULT_HEALTH ; 
		
		bounds = new Rectangle(0,0, width, height);
	}

	
	
	public boolean checkEntityCollinsion (float xOffset, float yOffset)	{
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) {
				continue ; }
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true ;
				}
		}
		return false ;

	}
	
	public Rectangle getCollisionBounds (float xOffset, float yOffset)	{
		 return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	


	public void hurt (int amt) {
		health -= amt ; 
		
		if (health <=0	) {
			active = false ;
			die ();
		}
		
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}



	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
