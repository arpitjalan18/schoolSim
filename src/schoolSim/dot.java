package schoolSim;
import java.awt.Color;
import java.awt.Point;

public class dot {

	Color color;
	int xStart;
	int yStart;
	int xDest;
	int yDest;
	Point x; 
	public dot( Color color, int xStart, int yStart, int xDest, int yDest) {
		
		this.color = color;
		this.xStart = xStart;
		this.yStart = yStart;
		this.xDest = xDest;
		this.yDest = yDest;
		x = new Point(xStart, yStart);
		
		AStar runner = new AStar();
		runner.runAStar(xStart, yStart, xDest, yDest);
	}
	public void updatePosition(int newxPosition, int newyPosition) {
		
		xStart = newxPosition;
		yStart = newyPosition;
		
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
