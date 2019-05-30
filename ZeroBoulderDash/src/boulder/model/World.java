/**
 * 
 */
package boulder.model;

import java.awt.Graphics;

import boulder.entity.EntityManager;
import boulder.entity.ItemManager;
import boulder.entity.Items;
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
	
	/*
	 * Entities
	 */
	private EntityManager entityManager ; 
	/*
	 * ITems 
	 */
	private ItemManager itemManager ; 
	
	
	public World (Handler  handler, String path) {
		this.handler = handler ; 
		/*
		 * loading Entities
		 */
		entityManager = new EntityManager(handler, new Player (handler,0,0) );
		
		//testtestsetst
		itemManager = new ItemManager(handler);
		
	    getItemManager().addItem(Items.rockItem.createNew(300,300 ));
		entityManager.addEntity(new DirtEntity(handler, 100, 300, width, height));
		entityManager.addEntity(new DirtEntity(handler, 100, 300 + 32, width, height));
		entityManager.addEntity(new DirtEntity(handler, 100, 300 + 32 *2, width, height));
		entityManager.addEntity(new DirtEntity(handler, 100, 300 + 32 * 3 , width, height));
		entityManager.addEntity(new DirtEntity(handler, 100, 300 + 32 *4 , width, height));		
		entityManager.addEntity(new DirtEntity(handler, 100, 300 + 32 * 5 , width, height));
		entityManager.addEntity(new DirtEntity(handler, 100, 300 + 32 * 6 , width, height));
		entityManager.addEntity(new DirtEntity(handler, 200, 300, width, height));
		entityManager.addEntity(new DirtEntity(handler, 200, 300 + 32, width, height));
		entityManager.addEntity(new DirtEntity(handler, 200, 300 + 32 *2, width, height));
		entityManager.addEntity(new DirtEntity(handler, 200, 300 + 32 * 3 , width, height));
		entityManager.addEntity(new DirtEntity(handler, 200, 300 + 32 *4 , width, height));		
		entityManager.addEntity(new DirtEntity(handler, 200, 300 + 32 * 5 , width, height));
		entityManager.addEntity(new DirtEntity(handler, 200, 300 + 32 * 6 , width, height));

		

		
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		/*
		 * 
		 */
	
	}
	
	
	public void tick ()	{
		
		//testetset
		itemManager.tick();
		
		entityManager.tick();
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
		/**
		 * Items tests
		 */
		itemManager.render(g);
		/**
		 *Entities
		 */
		entityManager.render(g);
		
	} 
	
	public Tile getTile(int x , int y) {
		
		if (x < 0 || y < 0 || x >= width ||  y >= height) {
			
			return Tile.dirtBackgroundTile ; 
		}
		
		
		Tile t = Tile.tiles[tiles[x][y]];
		
		
		if (t == null ) {
			return Tile.dirtBackgroundTile;
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


		/**
		 * @return the entityManager
		 */
		public EntityManager getEntityManager() {
			return entityManager;
		}


		/**
		 * @return the handler
		 */
		public Handler getHandler() {
			return handler;
		}


		/**
		 * @param handler the handler to set
		 */
		public void setHandler(Handler handler) {
			this.handler = handler;
		}


		/**
		 * @return the itemManager
		 */
		public ItemManager getItemManager() {
			return itemManager;
		}


		/**
		 * @param itemManager the itemManager to set
		 */
		public void setItemManager(ItemManager itemManager) {
			this.itemManager = itemManager;
		}
		
		
		


}
