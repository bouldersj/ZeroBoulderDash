/**
 * 
 */
package boulder.entity;


import boulder.game.Handler;

/**
 * @author liabe
 *
 */
public abstract class StaticItem extends Entity  {
	public static final int DEFAULT_WIDTH = 32, 
			DEFAULT_HEIGHT = 32 ;
	
	protected float xMove , yMove ;

	


	public StaticItem(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		xMove =0 ; 
		yMove = 0 ; 
		// TODO Auto-generated constructor stub
	}
	
	public void remove () {
		
		
		if (!checkEntityCollinsion(xMove, 0f)) {
			handler.getWorld().getEntityManager().getEntities().remove(this);

		}
	if (!checkEntityCollinsion(0f, yMove)) {
		handler.getWorld().getEntityManager().getEntities().remove(this);

	}
		
		
			
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


}
