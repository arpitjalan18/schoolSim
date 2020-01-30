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
	ArrayList<Point> path = new ArrayList<>();
	AStar runner;
	int speedDiv;
	public dot( Color color, int xStart, int yStart, int xDest, int yDest, int floorStart, int floorDest) {
		
		this.color = color;
		this.xStart = xStart;
		this.yStart = yStart;
		this.xDest = xDest;
		this.yDest = yDest;
		this.floorDest = floorDest;
		this.floorStart = floorStart;
		
		runner = new AStar();
		
		//needs to go down and back up
		if (( floorDest == 2 && floorStart ==2) ) {
			if ( runner.test(xStart, yStart, xDest, yDest, 2).size()==0) {
				findPortalGoingDown();
				findPortalGoingUp();
				normalPathFind(2);
			}
			else {
				normalPathFind(2);
			}
		}// 2nd to first but the coordinates technicaly still work
		else if(floorDest > floorStart) {
			findPortalGoingUp();
			normalPathFind(2);
		}
		else if(floorDest < floorStart) {
			
			findPortalGoingDown();
			normalPathFind(1);
		
		}
		else {
			normalPathFind(1);
		}
		
		
	}
	public void newDest(int x, int y, int floor) {
		xDest = x;
		yDest = y;
		int floorDest = floor;
		runner = new AStar();
		
		//needs to go down and back up
		if (( floorDest == 2 && floorStart ==2) ) {
			if ( runner.test(xStart, yStart, xDest, yDest, 2).size()==0) {
				findPortalGoingDown();
				findPortalGoingUp();
				normalPathFind(2);
			}
			else {
				normalPathFind(2);
			}
		}// 2nd to first but the coordinates technicaly still work
		else if(floorDest > floorStart) {
			findPortalGoingUp();
			normalPathFind(2);
		}
		else if(floorDest < floorStart) {
			
			findPortalGoingDown();
			normalPathFind(1);
		
		}
		else {
			normalPathFind(1);
		}
	}
	public void addToPath(ArrayList<Point> addThis) {
			for (Point point: addThis) {
				path.add(point);
			}
	}
	public void normalPathFind(int newFloor) {

		if (path.size()> 1) {
			
			int x = path.get(1).x;
			int y= path.get(1).y;
			path.addAll(0, runner.test(x, y, xDest, yDest, newFloor));
		}
		else{path.addAll(0, runner.test(xStart, yStart, xDest, yDest, floorStart));}
	}
	public void findPortalGoingDown() {
		int x ; int y;
		if (path.size() > 0) {
			 x = path.get(1).x;
			 y = path.get(1).y;
		}
		else {
			x = xStart;
			y = yStart;
		}
		
		if (xStart < 43) {
			path.addAll(0, runner.test(x, y, 26, 67, 2));
			
		}
		else if (xStart <  56) {
			if (yStart < 85)
				path.addAll(0, runner.test(x, y, 46, 67, 2));
			if (yStart > 84)	{
				path.addAll(0, runner.test(x, y, 52, 96, 2));
			}
		}
		else if (yStart > 14 && yStart < 20) {
			if (xStart < 86)  {
				path.addAll(0, runner.test(x, y, 63, 16, 2));
			}
			if (xStart > 85) {
				path.addAll(0, runner.test(x, y, 107, 16, 2));		
			}
		  }
		else if (yStart > 19 && yStart < 37) {
			if (xStart < 86)  {
				path.addAll(0, runner.test(x, y, 67, 29, 2));
				
			}
			if (xStart > 85) {
				path.addAll(0, runner.test(x, y, 103, 29, 2));			
			}
		}
		else if(yStart > 60 && yStart < 68) {
			if (xStart < 86)  {
				path.addAll(0, runner.test(x, y, 67, 57, 2));
			}
			if (xStart > 85) {
				path.addAll(0, runner.test(x, y, 103, 57, 2));		
			}
		  }
		else if (yStart > 67) {
			if (xStart < 86)  {
				path.addAll(0, runner.test(x, y, 63, 70, 2));
				
			}
			if (xStart > 85) {
				path.addAll(0, runner.test(x, y, 107, 70, 2));			
			}
		}
		path.add(0, new Point (-1, -1));
	}
	public void findPortalGoingUp() {
		int x; int y;
		if (path.size() > 1) {
			 x = path.get(1).x;
			 y = path.get(1).y;
		}
		else {
			x = xStart;
			y = yStart;
		}
		
		if (xDest < 43) {
			path.addAll(0, runner.test(x, y, 26, 67, 1));
			
		}
		else if (xDest <  56) {
			if (yDest < 85)
				path.addAll(0,runner.test(x, y, 46, 67, 1));
			if (yDest > 84)	
				path.addAll(0, runner.test(x, y, 52, 96, 1));
		}
		else if (yDest > 14 && yDest < 20) {
			if (xDest < 86)  {
				path.addAll(0,runner.test(x, y, 63, 16, 1));
			}
			if (xDest > 85) {
				path.addAll(0,runner.test(x, y, 107, 16, 1));		
			}
		  }
		else if (yDest > 19 && yDest < 37) {
			if (xDest < 86)  {
				path.addAll(0,runner.test(x, y, 67, 29, 1));
				
			}
			if (xDest > 85) {
				path.addAll(0,runner.test(x, y, 103, 29, 1));			
			}
		}
		else if(yDest > 60 && yDest < 68) { 
			if (xDest < 86)  {
				path.addAll(0,runner.test(x, y, 67, 57, 1));
			}
			if (xDest > 85) {
				path.addAll(0,runner.test(x, y, 103, 57, 1));		
			}
		  }
		else if (yDest > 67) {
			if (xDest < 86)  {
				path.addAll(0,runner.test(x, y, 63, 70, 1));
				
			}
			if (xDest > 85) {
				path.addAll(0, runner.test(x, y, 107, 70, 1));			
			}
		}	
		path.add(0, new Point (-1, -1));
	}
	

	public void updatePosition() {

			if (path.size()> 0) {
				int x = path.get(path.size()-1).x;
				int y = path.get(path.size()-1).y;
				//System.out.println(x + "  " + y + "   " + path.size());
				if (x==-1 & y==-1) {
					if (floorStart == 2)floorStart--;
					else {floorStart++;}
					//path.addAll()
				}
				else {
					xStart = x;
					yStart = y;
				}
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
