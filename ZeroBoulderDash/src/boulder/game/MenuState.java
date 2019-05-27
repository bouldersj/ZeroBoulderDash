/**
 * 
 */
package boulder.game;

import java.awt.Color;
import java.awt.Graphics;

import boulder.display.Assets;

/**
 * @author liabe
 *
 */
public class MenuState extends State{
	
	public MenuState (Handler handler) {
		super(handler);

		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		menu(g);
		
	}
	
	public void menu (Graphics g)	{

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(130, 180, 130, 40 );
		g.fillRect(130, 230, 130, 40);
		g.fillRect(130, 280, 130, 40);
		g.fillRect(130, 330, 130, 40);
		
		
		//x60
		g.drawImage(Assets.title, 60,20, null) ; 
		
		
	}
	
	

}
