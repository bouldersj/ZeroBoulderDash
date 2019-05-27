/**
 * 
 */
package boulder.game;

import java.awt.Graphics;

/**
 * @author liabe
 *
 */
public abstract class State {
	
	private static State curreState = null ;
	
	protected Handler handler ; 

	public static void setState (State state) {
		curreState = state ;
	}
	
	public static State getState () {
		return curreState; 
	}
	
	
	public State (Handler handler) {
		this.handler = handler  ;
	}

	public abstract void tick ()  ;
	
	public abstract void render (Graphics g);

}
