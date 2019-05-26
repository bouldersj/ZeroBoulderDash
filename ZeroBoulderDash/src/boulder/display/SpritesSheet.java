/**
 * 
 */
package boulder.display;

import java.awt.image.BufferedImage;

/**
 * @author liabe
 *
 */
public class SpritesSheet {
	
	private BufferedImage sheet ; 
	
	public SpritesSheet (BufferedImage sheet)	{
		
		this.sheet = sheet ;
		
	}
	
	
	public BufferedImage crop (int x, int y , int width, int height) {
		
		return sheet.getSubimage(x, y, width, height) ; 
		
	}

}
