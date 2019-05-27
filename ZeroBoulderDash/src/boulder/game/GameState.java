/**
 * 
 */
package boulder.game;

import java.awt.Graphics;

import boulder.model.Player;
import boulder.model.World;

/**
 * @author liabe
 *
 */
public class GameState extends State {
	
	private Player player ;
	private World world ;
	
	 public GameState(Game game) {
		// TODO Auto-generated constructor stub
		 super(game);  
		 player = new Player (game, 100	,100) ; 
		 
		 //init level
		 world = new World (game, "res/worlds/level1");
		 
		 game.getGameCamera().move(100, 200);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
		world.tick();
		player.tick();

		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		//test if tiles Work
		//Tile.tiles[0].render(g, 0, 0);
		
		world.render(g);
		player.render(g);
		
	
		
		
	}
	

}
