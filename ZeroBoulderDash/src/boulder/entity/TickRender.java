/**
 * 
 */
package boulder.entity;

import java.awt.Graphics;

/**
 * @author liabe
 *
 */
public interface TickRender {
	
	public abstract void tick ();
	public abstract void render (Graphics g);
	public abstract void die ();
	
}
