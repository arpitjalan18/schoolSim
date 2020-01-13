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
	
	static Frame tetris;
	public Color flatBlue = new Color(0x0AB7F2);
	public Color darkBlue = new Color(0x1E59CF);
	public Color orange = new Color(0xFB7C10);
	public Color yellow = new Color(0xF6BA25);
	public Color purple = new Color(0xC531A9);
	public Color green = new Color(0x66BF33);
	public Color red = new Color(0xDA2941);
	JFrame frame;
	Painter painter;

	public int ticks = 0;
	public static void main(String args[]) {
		tetris = new Frame();
	}
	public int pieceIndex = 6;
	
	public Frame(){
		frame = new JFrame("");
		frame.setVisible(true);
		frame.setSize(1017, 1071);
		frame.setResizable(false);
		//frame.setLocationRelativeTo(null);
		painter = new Painter();
		frame.add(painter);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

