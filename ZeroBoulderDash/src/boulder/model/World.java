/**
 * 
 */
package boulder.model;

import java.awt.Graphics;

/**
 * @author liabe
 *
 */
public class World {
	
	private int width , height ;
	private int spawnX, spawnY ; 
	private int  [][] tiles ; 
	
	public World (String path) {
		loadWorld(path);
	}
	
	
	public void tick ()	{
		
	}
	
	public void render (Graphics g)	{
		for (int y = 0 ;y< height; y++ ) {
			for (int x =0 ; x < width; x++) {
				getTile(x,y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
				
			}
		}
		
	}
	
	public Tile getTile(int x , int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		
		if (t == null ) {
			return Tile.dirtTile;
		}
		
		return t ;
	}
	private void loadWorld(String path ) {
		
		String file = Utils.loadFileAsString(path);
		
		String [] tokens  = file.split("\\s+");
		
		width = Utils.praseInt(tokens[0]);
		height = Utils.praseInt(tokens[1]);
		spawnX = Utils.praseInt(tokens[2]);
		spawnY = Utils.praseInt(tokens[3]);
		
		tiles = new int [width][height]; 
		
		for (int y =0 ; y < height ; y++ ) {
			for (int x = 0 ; x < width ; x++) {
				tiles [x] [y] = Utils.praseInt(tokens [(x+y * width)+ 4]);
			}
		}
		

	}

}
