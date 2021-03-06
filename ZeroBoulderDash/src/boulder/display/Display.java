/**
 * 
 */
package boulder.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * @author liabe
 *
 */
public class Display {
	
	private JFrame frame ;
	
	private Canvas canvas ; 
	
	private int width, height ; 
	
	private String title ; 
	
	public Display (String title, int width, int height)	{
		
		this.title = title ; 
		this.width = width ; 
		this.height = height ; 
		
		createDisplay () ;
		
	}//constructor
	


	private void createDisplay () {
		
		frame = new JFrame (title);
		
		frame.setSize(width, height);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(false);
		
		frame.setLocationRelativeTo(null);
		
		frame.setAlwaysOnTop(true);
				
		frame.setVisible(true);
		
		canvas = new Canvas ()	;
		
		canvas.setPreferredSize(new Dimension (width, height));
		
		canvas.setMaximumSize(new Dimension(width, height));
		
		canvas.setMinimumSize(new Dimension(width, height));
		
		canvas.setFocusable(false);
		
		canvas.setBackground(Color.black);
				
		frame.add(canvas);
		
		frame.pack();
		
		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame()	{
		 return frame ;
	}

}//Display
