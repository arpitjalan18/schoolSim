package schoolSim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Frame implements ActionListener{
	
	
	JFrame frame;
	public Timer timer = new Timer(20, this);
	public int ticks = 0;

	public dotArray dots = new dotArray();

	public void initializeDots() {
			dots.add(new dot(Color.RED, 100, 10 , 100, 100));
			dots.add(new dot(Color.RED, 100, 10 , 100, 100));
			dots.add(new dot(Color.RED, 100, 10 , 100, 100));
			dots.add(new dot(Color.RED, 100, 10 , 100, 100));
			dots.add(new dot(Color.RED, 100, 10 , 100, 100));
			dots.add(new dot(Color.RED, 100, 10 , 100, 100));
			
			
	}
	public Frame(){
		frame = new JFrame("");
		frame.setVisible(true);
		frame.setSize(1071 + 16 ,1017 + 39);  
		frame.add(dots);
		initializeDots();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		timer.start();		  
		
	}
	
	public void actionPerformed(ActionEvent e) {
		ticks++;
		ArrayList<Point> dotPositions = new ArrayList<>();
		for (int i = 0; i < dots.dots.size(); i++) {
			dotPositions.add(new Point(dots.dots.get(i).xStart, dots.dots.get(i).yStart));
		}
		for (int i = 0; i < dots.dots.size(); i++) {
				int otherDots = -1;	
				System.out.println("h");
		
				for (Point x : dotPositions){
					if(x.x == dotPositions.get(i).x && x.y ==dotPositions.get(i).y) {otherDots++;}
				}
				if (ticks%(10+ otherDots*2) == 0) {
					dots.dots.get(i).updatePosition();
				}

				dots.dots.get(0).repaint();
				
		}
		dots.repaint();

	}

	public void moveDots() {

		
	}

   
}

