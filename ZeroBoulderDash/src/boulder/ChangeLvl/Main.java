package boulder.ChangeLvl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;



public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("res/worlds/Monde.txt")); 
		Connect haha = new Connect();
		
		writer.write(haha.lvl5());
	
		writer.close();
	}

}
