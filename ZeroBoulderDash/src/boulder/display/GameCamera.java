/**
 * 
 */
package boulder.display;

import boulder.entity.Entity;
import boulder.game.Game;
import boulder.game.Handler;
import boulder.model.Tile;

/**
 * @author liabe
 *
 */
public class GameCamera {
	
	private Handler handler ; 
	private float xOffset , yOffset ; 
	
	public GameCamera (Handler handler, float xOffset, float yOffset) {
		this.handler = handler ; 
		this.xOffset = xOffset ;
		this.yOffset = yOffset ;
		
	}

	public void checkBackgroundSpace ()	{
		if (xOffset <0 ) {
			
			xOffset = 0 ; 
			
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth() ) {
			xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
		}
		
		if (yOffset < 0 ) {
			
			yOffset = 0 ; 
			
		}else if (yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight() ;
		}
	}
	
	

	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 +e.getWidth() / 2 ;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() /2 ;
		checkBackgroundSpace();
	}
	
	//ammout
	public void move (float xAmt,float yAmt) {
		xOffset += xAmt ; 
		yOffset += yAmt ; 
		checkBackgroundSpace();
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
