/**
 * 
 */
package boulder.model;

import java.awt.Graphics;

import boulder.game.Handler;

/**
 * @author liabe
 *
 */
public class World {
	
	
	private Handler handler  ; 
	private int width , height ;
	private int spawnX, spawnY ; 
	private int  [][] tiles ; 
	
	public World (Handler  handler, String path) {
		this.handler = handler ; 
		loadWorld(path);
	}
	
	
	public void tick ()	{
		
	}
	
	public void render (Graphics g)	{
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH) ; 
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILE_HEIGHT) ;
		int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILE_HEIGHT +1 ) ; 
		
		for (int y = yStart ;y< yEnd; y++ ) {
			for (int x = xStart ; x < xEnd; x++) {
				getTile(x,y).render(g,(int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
				
			}
		}
		
	} 
	
	public Tile getTile(int x , int y) {
		
		if (x < 0 || y < 0 || x >= width ||  y >= height) {
			
			return Tile.dirtBackgroundTile ; 
		}
		
		
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
				tiles [x] [y] = Utils.praseInt(tokens [(x + y * width) + 4]);
			}
		}


	}
		public int getWidth () {
			return width ; 
		}
		
		public int getHeight () {
			return height;  
		}


		/**
		 * @return the spawnX
		 */
		public int getSpawnX() {
			return spawnX;
		}


		/**
		 * @param spawnX the spawnX to set
		 */
		public void setSpawnX(int spawnX) {
			this.spawnX = spawnX;
		}


		/**
		 * @return the spawnY
		 */
		public int getSpawnY() {
			return spawnY;
		}


		/**
		 * @param spawnY the spawnY to set
		 */
		public void setSpawnY(int spawnY) {
			this.spawnY = spawnY;
		}


}
