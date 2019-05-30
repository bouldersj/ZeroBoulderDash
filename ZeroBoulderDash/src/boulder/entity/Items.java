/**
 * 
 */
package boulder.entity;




import java.awt.Graphics;
import java.awt.image.BufferedImage;

import boulder.game.Handler;
import boulder.model.Assets;

/**
 * @author liabe
 *
 */////testing 
public class Items {
	/**
	 * Handler
	 */
	public static Items[] items  = new Items [256];
	public static Items rockItem = new Items(Assets.boulder, "boulder", 2) ; 
	public static Items diamondItem = new Items(Assets.diamonds, "diamond", 2) ; 
	/**
	 * Class
	 */
	public static final int TILEWIDTH = 32 , TILEHEIGHT = 32 , PICKEDUP = -1 ; 
	protected Handler handler ; 
	protected BufferedImage texture;
	protected String name ;
	protected final int id ; 
	protected  int  x,y,count ; 
	/**
	 * 
	 * @param texture
	 * @param name
	 * @param id
	 */
	
	public Items(BufferedImage texture, String name, int id) {
		this.texture = texture ; 
		this.name = name ; 
		this.id = id ;
		count = 1; 
		
		items[id] = this ;
	}
	
	public void tick () {
		
	}
	
	public void render (Graphics g ) {
		if(handler == null )
			return;
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}
	
	
	
	public void render (Graphics g, int x, int y ) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null) ;
	}
	
	public Items createNew (int x, int y) {
		Items i = new Items(texture, name, id) ;
		i.setPosition(x, y);
		return i ;
	}
	
	public void setPosition(int x , int y ) {
		this.x = x ; 
		this.y = y ;
	}
	

	
	/**
	 * Getters and setters 
	 */

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
	 * @return the texture
	 */
	public BufferedImage getTexture() {
		return texture;
	}

	/**
	 * @param texture the texture to set
	 */
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
		 
	


		
	





}
