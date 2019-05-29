/**
 * 
 */
package boulder.entity;




import boulder.game.Handler;
import boulder.model.Tile;

/**
 * @author liabe
 *
 */////testing 
public abstract class Items extends Entity{
	
public static final float DEFAULT_SPEED = 4.0f;
	
	public static final int DEFAULT_WIDTH = 32, 
							DEFAULT_HEIGHT = 32 ; 

	protected float speed ; 
	
	protected float yMove ; 
	
	private boolean destructible;
    private boolean falling;
	
	public Items(Handler handler, float x, float y, int width, int height, boolean destructible, boolean falling) {
		super(handler, x, y, width, height);
		// TODO Auto-generated constructor stub
		this.destructible = destructible ;
		this.falling = falling;
		
		falling = false ;
		destructible = false ; 
		speed = DEFAULT_SPEED ; 
		yMove = 0 ; 
		
	}
		
		public void move () {
			if (!checkEntityCollinsion(0f, yMove)) {
				falling();
			}
		}
		
		public void falling() {
			if(yMove > 0){ //Down
				
				int ty = (int)(y + yMove + bounds.y + bounds.height ) / Tile.TILE_HEIGHT;
				
				if (!collisionWithTile( (int) (x + bounds.x )/ Tile.TILE_WIDTH, ty) 
						&& !collisionWithTile( (int) (x + bounds.x + bounds.width)/ Tile.TILE_WIDTH, ty)) {
					y += yMove ;
					
				} else {
					y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height -1 ; 
				}
			}
		}
		
		protected boolean collisionWithTile (int x , int y ) {
			return handler.getWorld().getTile(x, y).isSolid();
		}

		/**
		 * @return the speed
		 */
		public float getSpeed() {
			return speed;
		}

		/**
		 * @param speed the speed to set
		 */
		public void setSpeed(float speed) {
			this.speed = speed;
		}
		/**
		 * @return the yMove
		 */
		public float getyMove() {
			return yMove;
		}

		/**
		 * @param yMove the yMove to set
		 */
		public void setyMove(float yMove) {
			this.yMove = yMove;
		}

		/**
		 * @return the destructible
		 */
		public boolean isDestructible() {
			return destructible;
		}

		/**
		 * @param destructible the destructible to set
		 */
		public void setDestructible(boolean destructible) {
			this.destructible = destructible;
		}


		/**
		 * @return the falling
		 */
		public boolean isFalling() {
			return falling;
		}

		/**
		 * @param falling the falling to set
		 */
		public void setFalling(boolean falling) {
			this.falling = falling;
		}






}
