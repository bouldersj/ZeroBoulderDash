/**
 * 
 */
package boulder.model;


import boulder.display.Assets;

/**
 * @author liabe
 *
 */

public class BoulderTile extends Tile{

	public BoulderTile( int id) {
		super(Assets.boulder, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid ()	{
		return true ; 
	}

}
