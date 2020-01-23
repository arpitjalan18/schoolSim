package schoolSim;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Painter extends JPanel{
	
	public Color Back = new Color(0x252525);
	public Color boundaryGray = new Color(0x666666);
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 11900, 11300  );
		
		readExcel reader = new readExcel();
		Color[][] mapColor = new Color[113][119];
		try {
			mapColor = reader.readFromExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int j = 0; j < 113; j+=1) {
			for(int i = 0; i < 119; i+=1) {
				
				g.setColor(mapColor[i][j]);	
				g.fillRect(9*j, 9*i, 9, 9);	
					
			}
		}
		Frame sim = Frame.sim;	
		for (int i = 0; i < sim.dots.size(); i++) {
			g.setColor(Color.BLUE);
			g.fillRect(9*sim.dots.get(i).yStart, 9*sim.dots.get(i).xStart, 9, 9);
			g.setColor(Color.BLUE);
			g.fillRect(1062, 1008, 9, 9);
		
		}
		
	}
	
}