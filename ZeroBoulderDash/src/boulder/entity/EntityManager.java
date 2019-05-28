/**
 * 
 */
package boulder.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import boulder.game.Handler;
import boulder.model.BoulderEntity;
import boulder.model.BoulderTile;
import boulder.model.Player;

/**
 * @author liabe
 *
 */
public class EntityManager {
	
	private Handler handler ; 
	private Player player ; 
	
	private ArrayList<Entity> entities ; 
	
	public EntityManager (Handler handler, Player player) {
		this.handler = handler ; 
		this.player = player ; 
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void tick () {
		for  (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
		
	}
	
	public void render (Graphics g)	{
		for  (Entity e : entities) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}

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
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the entities
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}
 
	/**
	 * @param entities the entities to set
	 */
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	

}
