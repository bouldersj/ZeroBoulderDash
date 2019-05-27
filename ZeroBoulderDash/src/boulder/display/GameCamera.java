/**
 * 
 */
package boulder.display;

import boulder.entity.Entity;
import boulder.game.Game;

/**
 * @author liabe
 *
 */
public class GameCamera {
	
	private Game game ; 
	private float xOffset , yOffset ; 
	
	public GameCamera (Game game, float xOffset, float yOffset) {
		this.game = game ; 
		this.xOffset = xOffset ;
		this.yOffset = yOffset ;
		
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - game.getWidth() / 2 +e.getWidth() / 2 ;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() /2 ;

	}
	
	//ammout
	public void move (float xAmt,float yAmt) {
		xOffset += xAmt ; 
		yOffset += yAmt ; 
	}

	/**
	 * @return the xOffset
	 */
	public float getxOffset() {
		return xOffset;
	}

	/**
	 * @param xOffset the xOffset to set
	 */
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	/**
	 * @return the yOffset
	 */
	public float getyOffset() {
		return yOffset;
	}

	/**
	 * @param yOffset the yOffset to set
	 */
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
