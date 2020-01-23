package schoolSim;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Frame{
	
	static Frame sim;
	JFrame frame;
	Painter painter;

	public ArrayList<dot> dots = new ArrayList<>();
	//public ArrayList<class> classes = new ArrayList<>();
	public int ticks = 0;
	public static void main(String args[]) {
		sim = new Frame();
	}
	public int pieceIndex = 6;
	public void initializeDots() {
		int i = 0;
		dots.add(new dot(Color.RED, 0, 0 , 10, 10));
		dots.add(new dot(Color.RED, 14, 80, 10, 20));
		while (i++ < 30)
			dots.add(new dot(Color.RED, 45, 22, 31, 65));
	}
	public Frame(){
		frame = new JFrame("");
		frame.setVisible(true);
		frame.setSize(1071 + 16 ,1017 + 39);
		//frame.setResizable(false);
		//frame.setLocationRelativeTo(null);
		initializeDots();
		painter = new Painter();	
		frame.add(painter);
		System.out.println(frame.getInsets());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

