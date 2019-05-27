/**
 * 
 */
package boulder.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * @author liabe
 *
 */
public class KeyManager implements KeyListener{
	
	
	private boolean [] keys ;
	
	public boolean up, down, left, right ; 
	

	
	public KeyManager() {
		// TODO Auto-generated constructor stub	
		keys = new boolean[256];
		
	}
	
	public void tick () {
		
		up = keys[KeyEvent.VK_Z];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_Q];
		right = keys[KeyEvent.VK_D];

		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = true ; 
		
		/**
		 * for test
		 
		System.out.println("pressed : "+e.getKeyCode());*/
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = false ; 

		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
