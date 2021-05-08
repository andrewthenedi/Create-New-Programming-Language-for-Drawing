//package Draw2021;

import java.io.*;
import java.util.*;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Test extends DrawEngine {

	public Test() {
		super("Group XYZ: Drawing Demo");
	}
	
	public void drawObjects(Graphics2D g2d) {
		//g2d.setBackground(Color.WHITE);
		
		// ADD/REPLACE code in the following to draw
/////////////////////////////////////////////////////////////////////////		
		g2d.setColor(Color.RED);
		g2d.drawLine(100,50,300,150);
		g2d.setColor(Color.YELLOW);
		g2d.drawLine(100,100,300,200);
		g2d.setColor(Color.BLUE);
		g2d.drawLine(100,150,300,250);

		double xcur,ycur,xnext,ynext;
		g2d.setColor(Color.GREEN);
		xcur=ycur=300;
		double angle_rad=0;
		for (int i=0;i<5;i++) {
			angle_rad+=2*Math.PI/5;
			xnext=xcur+100*Math.cos(angle_rad);
			ynext=ycur+100*Math.sin(angle_rad);
			g2d.drawLine((int)xcur,(int)ycur,(int)xnext,(int)ynext);
			xcur=xnext;
			ycur=ynext;
		}

		g2d.setColor(Color.BLACK);
		g2d.drawOval(300,300,150,150);
/////////////////////////////////////////////////////////////////////////
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {new Test().setVisible(true);}}
		);
	}

}