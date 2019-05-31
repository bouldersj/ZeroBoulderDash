/**
 * 
 */
package boulder.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;


import boulder.game.MenuState;

/**
 * @author liabe
 *
 */
public class Launcher {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("res/worlds/Monde.txt")); 
		Connect haha = new Connect();
		
		writer.write(haha.lvl2());
	
		writer.close();
		
		MenuState menu = new MenuState(null);
		//menu.menu();
		
		

	}

}
