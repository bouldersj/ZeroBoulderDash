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
public class Boulders extends Items{

	public Boulders(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.boulder,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null); 
	}


}
