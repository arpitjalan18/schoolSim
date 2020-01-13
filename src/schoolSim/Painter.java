package schoolSim;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Painter extends JPanel{
	
	public Color Back = new Color(0x252525);
	public Color grey1 = new Color(0x2F2F2F);
	public Color grey2 = new Color(0x2B2B2B);
	public Color flatBlue = new Color(0x0AB7F2);
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Back);
		g.fillRect(0, 0, 1130, 1190);
		
		readExcel reader = new readExcel();
		Color[][] mapColor = new Color[113][119];
		try {
			mapColor = reader.readFromExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int j = 0; j < 119; j+=1) {
			for(int i = 0; i < 113; i+=1) {

				g.setColor(mapColor[i][j]);
				g.fillRect(9*j, 9*i, 9, 9);
			
			
			}
		} 
		Frame tetris = Frame.tetris;	
		
	}
	
}