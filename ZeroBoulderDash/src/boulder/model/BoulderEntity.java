/**
 * 
 */
package boulder.model;

import java.awt.Graphics;

import boulder.entity.StaticItem;
import boulder.game.Handler;

/**
 * @author liabe
 *
 */

//////testing 
public class BoulderEntity extends StaticItem {


	public BoulderEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT );
		bounds.x = 2; 
		bounds.y = 2;
		bounds.width = 29 ; 
		bounds.height = 29 ; 
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.boulder,(int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null); 
	}


}
