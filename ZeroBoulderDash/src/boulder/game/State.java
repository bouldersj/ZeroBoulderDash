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
	
 

	public static void setState (State state) {
		curreState = state ;
	}
	
	public static State getState () {
		return curreState; 
	}
	
	protected Game game ; 
	
	public State (Game game) {
		this.game = game ;
	}

	public abstract void tick ()  ;
	
	public abstract void render (Graphics g);

}
