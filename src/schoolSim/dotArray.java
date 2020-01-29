package schoolSim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class dotArray extends JPanel{
	ArrayList<dot> dots = new ArrayList<>();
	public int mult = 1;
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
		Color[][] mapColor = new Color[113][100];
		try {
			mapColor = reader.readFromExcel(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 113; i+=1) {
			for(int j = 0; j < 100; j+=1) {
				
				g.setColor(mapColor[i][j]);	
				if (i == 112 && j == 99)
					g.setColor(Color.BLACK);
				g.fillRect(mult*j,  mult*i, mult, mult);
				
			}
		} 
		try {
			mapColor = reader.readFromExcel(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 113; i+=1) {
			for(int j = 0; j < 100; j+=1) {
				
				g.setColor(mapColor[i][j]);	
				if (i == 112 && j == 99)
					g.setColor(Color.BLACK);
				g.fillRect(mult*j + mult*105,  mult*i, mult, mult);
				
			}
		} 
		
		for (int i = 0; i < dots.size(); i++) {
			if (dots.get(i).getFloor() == 1) {
				g.setColor(dots.get(i).getColor());
				g.fillRect(mult*dots.get(i).yStart, mult*dots.get(i).xStart, mult, mult);
			}
			else {
				g.setColor(dots.get(i).getColor());
				g.fillRect(mult*dots.get(i).yStart + mult*105, mult*dots.get(i).xStart, mult, mult);
			}
		}

	}
}
