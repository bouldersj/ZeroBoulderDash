/**
 * 
 */
package boulder.entity;

import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import boulder.game.Handler;

import boulder.model.Player;

/**
 * @author liabe
 *
 */
public class EntityManager {
	
	private Handler handler ; 
	private Player player ; 
	private ArrayList<Entity> entities ; 
	/*private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {

			if (a.getY() < b.getY()) {
				return -1;
			}
		return 1 ;

		}
	};*/
	
	public EntityManager (Handler handler, Player player) {
		this.handler = handler ; 
		this.player = player ; 
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void tick () {
		Iterator<Entity> it = entities.iterator()	;
	 while  (it.hasNext()) {
			Entity e = it.next();
			e.tick(); 
			if (!e.isActive()) {
				it.remove();
			}
		}
		
	//entities.sort(renderSorter);

	}
	
	public void render (Graphics g)	{
		for  (Entity e : entities) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	public void RemoveEntity(Entity e) {
		entities.remove(e);
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
