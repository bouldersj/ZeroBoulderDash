/**
 * 
 */
package boulder.model;

import java.awt.Graphics;

import boulder.entity.Items;
import boulder.game.Handler;

/**
 * @author liabe
 *
 */

//////testing 
public class BoulderEntity extends Items{
	
	private static boolean isDestructible;
	private static boolean canMove;

	static {
		isDestructible = false;
		canMove = true;
	}

	public BoulderEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, isDestructible, canMove);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.boulder,(int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null); 
	}


}
