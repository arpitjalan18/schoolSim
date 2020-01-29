package schoolSim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
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
	public ArrayList<classes> cl = new ArrayList<>();
	public int c, nc, x, nx, y, ny;
	
	public void initializeClass()
	{
		//yellow buildings
		cl.add(new classes(21, 44, 1));
		cl.add(new classes(25, 44, 1));
		cl.add(new classes(29, 44, 1));
		cl.add(new classes(21, 53, 1));
		cl.add(new classes(25, 53, 1));
		cl.add(new classes(29, 53, 1));
		//blue buildings
		cl.add(new classes(30, 64 , 1));
		cl.add(new classes(30, 70, 1));
		cl.add(new classes(34, 64, 1));
		cl.add(new classes(34, 70, 1));
		cl.add(new classes(38, 64, 1));
		cl.add(new classes(38, 70, 1));
		cl.add(new classes(45, 76, 1));
		cl.add(new classes(49, 76, 1));
		cl.add(new classes(45, 80, 1));
		cl.add(new classes(49, 80, 1));
		cl.add(new classes(45, 84, 1));
		cl.add(new classes(49, 84, 1));
		cl.add(new classes(45, 88, 1));
		cl.add(new classes(49, 88, 1));
		cl.add(new classes(45, 92, 1));
		cl.add(new classes(49, 92, 1));
		//gray buildings
		cl.add(new classes(61, 23, 1));
		cl.add(new classes(61, 27, 1));
		cl.add(new classes(67, 16, 1));
		cl.add(new classes(71, 16, 1));
		cl.add(new classes(75, 16, 1));
		cl.add(new classes(79, 16, 1));
		cl.add(new classes(83, 16, 1));
		cl.add(new classes(87, 16, 1));
		cl.add(new classes(91, 16, 1));
		cl.add(new classes(95, 16, 1));
		cl.add(new classes(99, 16, 1));
		cl.add(new classes(103, 16, 1));
		cl.add(new classes(67, 23, 1));
		cl.add(new classes(71, 23, 1));
		cl.add(new classes(75, 23, 1));
		cl.add(new classes(79, 23, 1));
		cl.add(new classes(91, 23, 1));
		cl.add(new classes(95, 23, 1));
		cl.add(new classes(99, 23, 1));
		cl.add(new classes(103, 23, 1));
		cl.add(new classes(61, 59, 1));
		cl.add(new classes(61, 63, 1));
		cl.add(new classes(67, 63, 1));
		cl.add(new classes(71, 63, 1));
		cl.add(new classes(75, 63, 1));
		cl.add(new classes(79, 63, 1));
		cl.add(new classes(91, 63, 1));
		cl.add(new classes(95, 63, 1));
		cl.add(new classes(99, 63, 1));
		cl.add(new classes(103, 63, 1));
		cl.add(new classes(109, 59, 1));
		cl.add(new classes(109, 63, 1));
		cl.add(new classes(67, 70, 1));
		cl.add(new classes(71, 70, 1));
		cl.add(new classes(75, 70, 1));
		cl.add(new classes(79, 70, 1));
		cl.add(new classes(83, 70, 1));
		cl.add(new classes(87, 70, 1));
		cl.add(new classes(91, 70, 1));
		cl.add(new classes(95, 70, 1));
		cl.add(new classes(99, 70, 1));
		cl.add(new classes(103, 70, 1));
		cl.add(new classes(109, 23, 1));
		cl.add(new classes(109, 27, 1));
		//66 classes		
	
		//blue 2
		cl.add(new classes(30, 64 , 2));
		cl.add(new classes(30, 70, 2));
		cl.add(new classes(34, 64, 2));
		cl.add(new classes(34, 70, 2));
		cl.add(new classes(38, 64, 2));
		cl.add(new classes(38, 70, 2));
		cl.add(new classes(45, 76, 2));
		cl.add(new classes(49, 76, 2));
		cl.add(new classes(45, 80, 2));
		cl.add(new classes(49, 80, 2));
		cl.add(new classes(45, 84, 2));
		cl.add(new classes(49, 84, 2));
		cl.add(new classes(45, 88, 2));
		cl.add(new classes(49, 88, 2));
		cl.add(new classes(45, 92, 2));
		cl.add(new classes(49, 92, 2));
		

		//grey 2
		cl.add(new classes(67, 16, 2));
		cl.add(new classes(71, 16, 2));
		cl.add(new classes(75, 16, 2));
		cl.add(new classes(79, 16, 2));
		cl.add(new classes(83, 16, 2));
		cl.add(new classes(87, 16, 2));
		cl.add(new classes(91, 16, 2));
		cl.add(new classes(95, 16, 2));
		cl.add(new classes(99, 16, 2));
		cl.add(new classes(103, 16, 2));
		cl.add(new classes(67, 23, 2));
		cl.add(new classes(71, 23, 2));
		cl.add(new classes(75, 23, 2));
		cl.add(new classes(79, 23, 2));
		cl.add(new classes(91, 23, 2));
		cl.add(new classes(95, 23, 2));
		cl.add(new classes(99, 23, 2));
		cl.add(new classes(103, 23, 2));

		cl.add(new classes(67, 63, 2));
		cl.add(new classes(71, 63, 2));
		cl.add(new classes(75, 63, 2));
		cl.add(new classes(79, 63, 2));
		cl.add(new classes(91, 63, 2));
		cl.add(new classes(95, 63, 2));
		cl.add(new classes(99, 63, 2));
		cl.add(new classes(103, 63, 2));

		cl.add(new classes(67, 70, 2));
		cl.add(new classes(71, 70, 2));
		cl.add(new classes(75, 70, 2));
		cl.add(new classes(79, 70, 2));
		cl.add(new classes(83, 70, 2));
		cl.add(new classes(87, 70, 2));
		cl.add(new classes(91, 70, 2));
		cl.add(new classes(95, 70, 2));
		cl.add(new classes(99, 70, 2));
		cl.add(new classes(103, 70, 2));

		//second floor
		
	}


	public void initializeDots() {
		initializeClass();
		int xAdd = -1, yAdd=-1;
		for(int i = 0;  i < 594 ;i++)
		{
					
			
			c = (int)(Math.random()*(66));
			nc = (int)(Math.random()*(66));
			if(c==nc)
			{
			}
			else
			{
			 x = cl.get(c).getX() +xAdd;
			 y = cl.get(c).getY() + yAdd;
			 nx = cl.get(nc).getX()+xAdd;
			 ny = cl.get(nc).getY()+yAdd;
			 
			 xAdd++;
				if (xAdd==2) {
					xAdd=-1; yAdd++;
					if (yAdd ==2) {
						yAdd=-1;
					}
				}
			 
			// dots.add(new dot(Color.BLACK, x, y, nx, ny, 1);
			}
		}	
		for (int i = 0; i < cl.size();i++) {
			if (/*cl.get(i).getfloorNum()*/true)
				dots.add(new dot (Color.BLACK, cl.get(i).getX(), cl.get(i).getY(),  50, 50, cl.get(i).getfloorNum(), 1));
		}	
	}
	public Frame(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		frame = new JFrame("");
		frame.setVisible(true);
		frame.setSize(screenWidth, screenHeight); 
		dots.setHeight(screenHeight);
		frame.add(dots);
		initializeDots();
		colorByGender();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		timer.start();		  
		
	}
	public void colorByGender() {
		for (int i = 0; i < dots.dots.size(); i++) {
			if (i%2 == 0)
				dots.dots.get(i).setColor(Color.pink);
			else {
				dots.dots.get(i).setColor(Color.blue);
			}			
		}

	}
	public void colorByGrade() {
		for (int i = 0; i < dots.dots.size(); i++) {
			if (i%4 == 0)
				dots.dots.get(i).setColor(Color.orange);
			else if (i%3 == 0){
				dots.dots.get(i).setColor(Color.green);
			}	
			else if(i%2 == 0) {
				dots.dots.get(i).setColor(Color.blue);
			}
			else {
				dots.dots.get(i).setColor(Color.MAGENTA);
			}
		}

	}
	public void actionPerformed(ActionEvent e) {
		ticks++;
		ArrayList<Point> dotPositions = new ArrayList<>();
		for (int i = 0; i < dots.dots.size(); i++) {
			dotPositions.add(new Point(dots.dots.get(i).xStart, dots.dots.get(i).yStart));
		}
		for (int i = 0; i < dots.dots.size(); i++) {
				int otherDots = -1;	
			
				for (Point x : dotPositions){
					if(x.x == dotPositions.get(i).x && x.y ==dotPositions.get(i).y) {otherDots++;}
				}
				if (ticks%(10 + otherDots*2) == 0) {
					dots.dots.get(i).updatePosition();
				}

				dots.dots.get(0).repaint();
				
		}
		dots.repaint();

	}

	public void moveDots() {

		
	}

   
}

