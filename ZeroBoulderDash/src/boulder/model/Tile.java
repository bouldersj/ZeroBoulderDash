/**
 * 
 */
package boulder.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author liabe
 *
 */
public class Tile {
	
	public static Tile [] tiles = new Tile[256];
	
	
	public static Tile dirtBackgroundTile = new DirtBackgroundTile (0)	;
	
	public static Tile dirtTile = new DirtTile (1)	;
	
	public static Tile boulderTile = new BoulderTile (2)	;
	
	public static Tile wallTile = new WallTile (3)	;
	
	public static Tile diamondTiles = new DiamondTiles (4);



	
	public static final int TILE_WIDTH = 32, 
							TILE_HEIGHT = 32 ; 
	
	protected BufferedImage texture ;
	
	protected final int id ;
	
	public Tile (BufferedImage texture, int id ) {
		
		this.texture = texture ; 
		this.id = id ; 
		
		tiles[id] = this ; 
		
	}
	public void tik() {
		
	}
	
	public void render (Graphics g, int x , int y ) {
		g.drawImage(texture, x, y,TILE_WIDTH ,TILE_HEIGHT,null	) ;
	}
	
	public boolean isSolid ()	{
		return false ; 
	}
	public int getId() {
		return id ; 
	}

}
