package GUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import algorithms.ConvexHull;

public class PaintPanel extends JPanel implements MouseListener{
	private static Color background = Color.WHITE;
	private BufferedImage bufImg = null;
	private Point _start = null; // Where mouse is pressed.
    private Point _end   = null; // Where mouse is dragged to or released.
	private enum State {IDLE, CLICK}
    
    private State state = State.IDLE;
    
    
	public PaintPanel(){
		setPreferredSize(new Dimension(500,500));
		setBackground(background);
		
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g){
	
//		super.paintComponent(g);
			
		Graphics2D g2 = (Graphics2D)g;
		
		// init 
		if(bufImg == null){
			int w = this.getWidth();
            int h = this.getHeight();
            bufImg = (BufferedImage)this.createImage(w, h);
            Graphics2D gc = bufImg.createGraphics();
            gc.setColor(background);
            gc.fillRect(0, 0, w, h); // fill in background
		}
		
		// Display saved img
		g2.drawImage(bufImg, null, 0, 0);	
		
		if(state == State.CLICK){
			drawCurrentShape(g2);
		}
		


	
	}
	
//	private ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
	private ArrayList<int[]> nodes = new ArrayList<int[]>();
	private HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
	
	
	public ArrayList getNodes(){
		return nodes;
	}
	
	private void drawCurrentShape(Graphics2D g2){
		g2.setColor(Color.BLACK);
		g2.fillOval(_start.x, _start.y, 5, 5);
		
		/*
		ArrayList<Integer> point = new ArrayList<Integer>();
		if(point.size() != 2){
			point.add(0, _start.x);
			point.add(1, _start.y);
		}
		point.set(0, _start.x);
		point.set(1, _start.y);
		nodes.add(point);
		ConvexHull ch = new ConvexHull();
		ch.sort(nodes);
		*/
		int[] a = new int[2];
		a[0] = _start.x;
		a[1] = _start.y;
		
		nodes.add(a);
		
		System.out.println("x: " + a[0] + "   y: " + a[1]);
		for(int[] i : nodes){
			System.out.println(i[0] + "     " +i[1]);
		}
		
		
	}
	
	public void mousePressed(MouseEvent e){

		
	}
	
	
    public void mouseMoved  (MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
    	
    }
    public void mouseExited (MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {
	//	state = State.CLICK;
	//	_start = e.getPoint();
	//	_end = _start;
		
    }

	

	@Override
	public void mouseReleased(MouseEvent e) {
//		if(state == State.CLICK){
//			state = State.IDLE;
//		}
		_start = e.getPoint();
		drawCurrentShape(bufImg.createGraphics());
		this.repaint();
		
	}
	
}
