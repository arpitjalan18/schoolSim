package schoolSim;



import java.awt.Color;

public class dot {

	Color color;
	int xStart;
	int yStart;
	int xDest;
	int yDest;
	public dot( Color color, int xStart, int yStart, int xDest, int yDest) {
		
		this.color = color;
		this.xStart = xStart;
		this.yStart = yStart;
		this.xDest = xDest;
		this.yDest = yDest;
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
		return(", " + x + ", " + y);
	}
}
