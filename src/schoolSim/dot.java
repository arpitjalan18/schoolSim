package schoolSim;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class dot extends JPanel {

	Color color;
	int xStart;
	int yStart;
	int xDest;
	int yDest;
	ArrayList<Point> path;
	Point x; 
	int speedDiv;
	public dot( Color color, int xStart, int yStart, int xDest, int yDest) {
		
		this.color = color;
		this.xStart = xStart;
		this.yStart = yStart;
		this.xDest = xDest;
		this.yDest = yDest;
	
		AStar runner = new AStar();
		path = runner.test(xStart, yStart, xDest, yDest);
		
		
	}

	public void updatePosition() {

			if (path.size()> 0) {
				xStart = path.get(path.size()-1).x;
				yStart = path.get(path.size()-1).y;
				path.remove(path.size()-1);
			}

		
		
	}
	
	public Color getColor() {
		return color;
	}
	
	public boolean full() {
		if (color != null){
			return true;
		}
		else {
			return false;
		}
	}

	public String toString(){
		return("y");
	}
}
