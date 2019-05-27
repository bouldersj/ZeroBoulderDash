/**
 * 
 */
package boulder.game;

import boulder.controller.KeyManager;
import boulder.display.GameCamera;
import boulder.model.World;

/**
 * @author liabe
 *
 */

	
public class Handler {
	
	private Game game;
	private World world ;
	
	public Handler (Game game)	{
		this.game = game ; 
	}
	
	public GameCamera getGameCamera () {
		return game.getGameCamera();
	}
	public KeyManager getKeyManager () {
		return game.getKeyManager();
	}
	
	public int getWidth () {
		return game.getWidth();
	}
	
	public int getHeight ()	{
		return game.getHeight();
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @param world the world to set
	 */
	public void setWorld(World world) {
		this.world = world;
	}

}
