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
public class DiamondEntity extends Items{
	
	public DiamondEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		bounds.x = 0; 
		bounds.y = 0 ;
		bounds.width = 32 ; 
		bounds.height = 32 ; 
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.diamonds,(int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null); 
	}


}
