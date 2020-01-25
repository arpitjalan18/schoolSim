package schoolSim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class dotArray extends JPanel{
	ArrayList<dot> dots = new ArrayList<>();
	public int mult = 9;
	public void add(dot dot) {
		dots.add(dot);
	}
	public void remove(dot dot) {
		dots.remove(dot);
	}
	public void setHeight(int height) {
		mult = height/113;
	}
	
	@Override
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 11900, 11300  );
		
		readExcel reader = new readExcel();
		Color[][] mapColor = new Color[113][119];
		try {
			mapColor = reader.readFromExcel();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 113; i+=1) {
			for(int j = 0; j < 119; j+=1) {
				
				g.setColor(mapColor[i][j]);	
				g.fillRect(mult*j, mult*i, mult, mult);
				
			}
		}  
		for (int i = 0; i < dots.size(); i++) {
			g.setColor(Color.BLUE);
			g.fillRect(mult*dots.get(i).yStart, mult*dots.get(i).xStart, mult, mult);
		}

	}
}
