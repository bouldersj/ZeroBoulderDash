/**
 * 
 */
package boulder.model;


import boulder.display.Assets;

/**
 * @author liabe
 *
 */
public class WallTile extends Tile {

	public WallTile(  int id) {
		super(Assets.wall, id);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid ()	{
		return true ; 
	}
	
	

}
