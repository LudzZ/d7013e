import java.awt.BorderLayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import GUI.PaintPanel;
import GUI.Painter;



public class Main {
	
	
	

	public static void main(String[] args){	
		
		JApplet app = new Painter();
		PaintPanel pp = new PaintPanel();
		
		JFrame frame = new JFrame();
		frame.pack();
		frame.setResizable(false);
		frame.setContentPane(app);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	

}
