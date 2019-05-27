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
	
	 public GameState(Handler handler) {
		// TODO Auto-generated constructor stub
		 super(handler);
		 
		 //init level
		 world = new World (handler, "res/worlds/level1");
		 handler.setWorld(world); 
		 player = new Player (handler, handler.getWorld().getSpawnX() ,handler.getWorld().getSpawnY()) ; 
		 handler.getGameCamera().move(100, 200);
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
