package schoolSim;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Painter extends JPanel{
	
	public Color Back = new Color(0x252525);
	public Color boundaryGray = new Color(0x666666);
	
	 @Override
		public void paintComponent(Graphics g) {
		
			super.paintComponent(g);
			
		}
	
}