 /**
 * 
 */
package boulder.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import boulder.game.Handler;

/**
 * @author liabe 
 *
 */
public class ItemManager {///F****
	
	private Handler handler ; 
	private ArrayList<Items> items ; 
	
	/**
	 * 
	 * @param handler
	 */
	
	public ItemManager (Handler handler)	{
		this.handler = handler ; 
		items = new ArrayList<Items>();
	}
	
	public void tick () {
		
		Iterator<Items> it = items.iterator();
		while (it.hasNext()) {
			Items i = it.next();
			i.tick();
			if (i.getCount() == Items.PICKEDUP) 
				it.remove();
			
		}
		
		
	}
	
	public void render (Graphics g) {
		for (Items i :  items )
			i.render(g);
	}
	
	public void addItem (Items i) {
		i.setHandler(handler);
		items.add(i);
	}
	
	/**
	 * Geeters and seters 
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

}
