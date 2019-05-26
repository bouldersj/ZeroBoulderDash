/**
 * 
 */
package boulder.display;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author liabe
 *
 */
public class Assets {
	
	private static final int width = 16, height = 16 ; 
	
	public static BufferedImage 
							playerLeft,
							playerRight,
							playerUp,
							player,
							playerDown, 
							wall, 
							title, 
							vilan, 
							door, 
							diamonds, 
							dirt, 
							dirtBlack, 
							boulder ;
	
	public static void init () {
		
		
		SpritesSheet rockford = new SpritesSheet(ImageLoader.loadImage("/sprites/player.png"));
		SpritesSheet tiles = new SpritesSheet(ImageLoader.loadImage("/sprites/assets.png"));
		SpritesSheet titleMenue = new SpritesSheet(ImageLoader.loadImage("/sprites/titre.png"));

		

		
		
		
		

		playerLeft = rockford.crop(0, 16, width, height);
		
		playerRight = rockford.crop(0, 48, width, height);

		playerUp = rockford.crop(16, 64, width, height);
		
		playerDown= rockford.crop(0, 64, width, height);
		
		player = rockford.crop(0, 0, width, height);

		
		
		wall = tiles.crop(0, 0, width, height);
		
		
		vilan = tiles.crop(160,0,width,height);
		
		door = tiles.crop(112,0,width,height);
		
		diamonds = tiles.crop(64, 0, width, height);
		
		dirtBlack = tiles.crop(32, 0, width, height);
		
		dirt = tiles.crop(16, 0, width, height);
		
		boulder = tiles.crop(48, 0, width, height);
		
		title = titleMenue.crop(0,0,268,151);


		
		
	}

}
