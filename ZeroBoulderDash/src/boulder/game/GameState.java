/**
 * 
 */
package boulder.game;

import java.awt.Graphics;

import boulder.model.World;

/**
 * @author liabe
 *
 */
public class GameState extends State {
	
	//private Player player ;
	private World world ;
		
	 public GameState(Handler handler) {
		 super(handler); 
		 //init level
		 world = new World (handler, ("res/worlds/Monde.txt"));
		 handler.setWorld(world); 
		 handler.getGameCamera().move(100, 200);
		// player = new Player (handler, handler.getWorld().getSpawnX() ,handler.getWorld().getSpawnX()) ; 
		 
	}
 
	@Override
	public void tick() {
		world.tick();
		//player.tick();

		
	}

	@Override
	public void render(Graphics g) {
		//test if tiles Work
		//Tile.tiles[0].render(g, 0, 0);
		
		world.render(g);
		//player.render(g);

	}


	

}
