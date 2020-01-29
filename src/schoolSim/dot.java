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
	int floorDest;
	int floorStart;
	ArrayList<Point> path;
	Point x; 
	int speedDiv;
	public dot( Color color, int xStart, int yStart, int xDest, int yDest, int floorStart, int floorDest) {
		
		this.color = color;
		this.xStart = xStart;
		this.yStart = yStart;
		this.xDest = xDest;
		this.yDest = yDest;
		this.floorDest = floorDest;
		this.floorStart = floorStart;
		
		AStar runner = new AStar();
		path = runner.test(xStart, yStart, xDest, yDest, floorStart);
		
		//needs to go down and back up
		if (path.size() == 0 &&( floorDest == 2 && floorStart ==2) ) {
			//do something
		}// 2nd to first but the coordinates technicaly still work
		else if(floorDest > floorStart) {
			//do something
			//first to second
		}
		else if(floorDest < floorStart) {
			//do something
			//second to first
		}
		else {
			
		}
		
	}
	
	public void findPortal() {
		
	}
	public void updatePosition() {

			if (path.size()> 0) {
				xStart = path.get(path.size()-1).x;
				yStart = path.get(path.size()-1).y;
				path.remove(path.size()-1);
			}

		
		
	}
	public void setColor(Color col) {
		color = col;
	}
	public Color getColor() {
		return color;
	}
	public int getFloor() {
		
		return floorStart;
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
