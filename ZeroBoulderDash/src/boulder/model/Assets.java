/**
 * 
 */
package boulder.model;

import java.awt.image.BufferedImage;


/**
 * @author liabe
 *
 */
public class Assets {
	
	private static final int width = 16, height = 16; 
	
	public static BufferedImage 
							wall, 
							title, 
							diamonds,
							dirt, 
							dirtBlack, 
							boulder ;
						
	
	
	public static  BufferedImage[]playerLeft ,playerIdle,playerDown,playerRight,playerUp;
						


	public static void init () {
	
		
		SpritesSheet dwarf = new SpritesSheet(ImageLoader.loadImage("/sprites/player.png"));
		SpritesSheet tiles = new SpritesSheet(ImageLoader.loadImage("/sprites/assets.png"));
		SpritesSheet titleMenue = new SpritesSheet(ImageLoader.loadImage("/sprites/titre.png"));

		
		playerIdle	= new BufferedImage[3];
		playerDown	= new BufferedImage[3];
		playerLeft 	= new BufferedImage[3];
		playerRight	= new BufferedImage[3];
		playerUp	= new BufferedImage[3];
		
		/*
		playerDying = new BufferedImage[4]
		
		playerDying[0]=dwarf.crop(80, 0, width, height);
		playerDying[1]=dwarf.crop(96, 0, width, height);
		playerDying[2]=dwarf.crop(80, 80, width, height);
		playerDying[3]=dwarf.crop(96, 80, width, height);
*/


		wall = tiles.crop(0, 0, width, height);
	
		diamonds = tiles.crop(64, 0, width, height);

		dirtBlack = tiles.crop(32, 0, width, height);
		
		dirt = tiles.crop(16, 0, width, height);
		
		boulder = tiles.crop(48, 0, width, height);

		title = titleMenue.crop(0,0,268,151);
		
		playerLeft [0]  = dwarf.crop(0, 16, width, height);
		playerLeft [1]  = dwarf.crop(16, 16, width, height);
		playerLeft [2]  = dwarf.crop(32, 16, width, height);

		
		playerIdle [0]= dwarf.crop(0, 0, width, height);
		playerIdle [1] = dwarf.crop(16, 0, width, height);
		playerIdle [2] = dwarf.crop(0, 0, width, height);

		
		playerDown[0]= dwarf.crop(0, 64, width, height);
		playerDown[1]= dwarf.crop(16, 64, width, height);
		playerDown[2]= dwarf.crop(32, 64, width, height);

		
		playerRight[0]=dwarf.crop(0, 48, width, height);
		playerRight[1]=dwarf.crop(16, 48, width, height);
		playerRight[2]=dwarf.crop(32, 48, width, height);


		playerUp[0]=dwarf.crop(0, 32, width, height);
		playerUp[1]=dwarf.crop(16, 32, width, height);
		playerUp[2]=dwarf.crop(32, 32, width, height);
		
	}
	
}//Assets
