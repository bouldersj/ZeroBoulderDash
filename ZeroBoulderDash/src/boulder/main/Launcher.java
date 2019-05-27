/**
 * 
 */
package boulder.main;

import boulder.game.Game;

/**
 * @author liabe
 *
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game game = new Game("boulder dash", 800, 600);
		game.start();
		

	}

}
