package boulder.TestAissa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {

	protected JFrame f;
	protected JPanel p;
	protected Icon img;
	protected JLabel lab;
	protected JButton b1,b2;
	protected JComboBox liste;
	protected String[] lvl = {"Choisire le Niveau","Niveau 1", "Niveau 2", "Niveau 3", "Niveau 4", "Niveau 5"};
	
	
	
//--------------------------------------------------------------------------------------------------------------------------//
	public Menu() {
		gui();
	}
//--------------------------------------------------------------------------------------------------------------------------//	
	
	
	
	
	public void gui() {
		
		Font fontEntered = new Font(Font.DIALOG, Font.ITALIC, 20);
		Font fontEnteredliste = new Font(Font.DIALOG, Font.ITALIC, 15);
		Icon img = new ImageIcon("src/Images/menu.jpg");
		
		
		
		f = new JFrame();
		
		p = new JPanel();
		
		lab = new JLabel();
		
		b1 = new JButton("Start");
		
		b2 = new JButton("Exit");
		
		liste = new JComboBox(lvl);
		
		
		
		
		
		b1.setBackground(Color.lightGray);
		b1.setFont(fontEntered);
		b1.setBounds(550, 240, 150, 40);
		
		b2.setBackground(Color.lightGray);
		b2.setFont(fontEntered);
		b2.setBounds(550, 360, 150, 40);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		});
			
		
		
		
		liste.setBackground(Color.lightGray);
		liste.setFont(fontEnteredliste);
		liste.setBounds(550, 300, 150, 40);
		
		
		
		
		f.setSize(800,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		
		
		lab.setIcon(img);
		lab.setBounds(0, 0, 800, 600);
		
		p.add(b1);
		p.add(b2);
		p.add(liste);	
		p.add(lab);
			
		
		f.add(p);
		p.setLayout(null);
		f.setVisible(true);
		
		
	}
	
	
	
	
	
	
	
}
