package GUI;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JPanel;

public class Painter extends JApplet{
	PaintPanel ppanel = new PaintPanel();
	public Painter(){
     
        //... layout the applet ...........................................
        setLayout(new BorderLayout(5,5));
        add(ppanel    , BorderLayout.CENTER);
    }
}

	
	

