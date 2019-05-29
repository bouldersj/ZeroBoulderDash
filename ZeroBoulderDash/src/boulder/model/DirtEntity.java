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
public class DirtEntity extends StaticItem {

	public DirtEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT );
		// TODO Auto-generated constructor stub
		bounds.x = 0; 
		bounds.y = 0 ;
		bounds.width = 32 ; 
		bounds.height = 32 ; 
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		//remove();
	}
	
	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.dirt,(int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null); 
		
	}

	

}
