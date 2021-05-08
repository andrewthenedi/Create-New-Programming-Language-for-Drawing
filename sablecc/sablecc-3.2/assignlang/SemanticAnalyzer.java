package assignlang;

import assignlang.analysis.*;
import assignlang.node.*;

import java.util.ArrayList;

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SemanticAnalyzer extends DepthFirstAdapter {
	public ArrayList<String> assignStatement = new ArrayList<String>();
	public ArrayList<String> assignAssignRestSeen = new ArrayList<String>();
	public int temp;

	public void outAAssignStatement(AAssignStatement node){
		//Storing identifiers
		TIdentifier temp = node.getIdentifier();
		String str = temp.getText();
		assignStatement.add(str);
	}
	
	public void outAAssignAssignrest(AAssignAssignrest node){
	  //Storing the values of identifiers
		TIdentifier temp = node.getIdentifier();
		String str = temp.getText();
		assignAssignRestSeen.add(str);
    } 
            
	public void outAListProgram(AListProgram node)
	{
		TreeMap<String, java.util.List<Integer>> map_integers = new TreeMap();
		TreeMap<String, java.util.List<String>> map_strings = new TreeMap();

		for (int i = 0; i < assignStatement.size(); i++) 
		{
			if (assignStatement.get(i).equals("X_CURRENT") 
				|| assignStatement.get(i).equals("Y_CURRENT") 
				|| assignStatement.get(i).equals("X_NEXT") 
				|| assignStatement.get(i).equals("Y_NEXT")
				|| assignStatement.get(i).equals("WIDTH") 
				|| assignStatement.get(i).equals("HEIGHT")) 
			{
				map_integers.computeIfAbsent(assignStatement.get(i), 
					k -> new ArrayList<>()).add(Integer.parseInt(assignAssignRestSeen.get(i)));
			}
			else if (assignStatement.get(i).equals("SHAPE") 
				|| assignStatement.get(i).equals("COLOR")) 
			{
				map_strings.computeIfAbsent(assignStatement.get(i), 
					k -> new ArrayList<>()).add(assignAssignRestSeen.get(i));
			}
		}
		System.out.println("\n");
		
		System.out.println("Integer Key-Value Pairs: ");
		map_integers.forEach((key, value) -> System.out.println(key + " : " + value));
		
		System.out.println("\n");
		
		System.out.println("String Key-Value Pairs: ");
		map_strings.forEach((key, value) -> System.out.println(key + " : " + value));
		
		class MyCanvas extends JComponent 
		{ 
			public void paint(Graphics g2d) 
			{ 
				int SIZE_SHAPE = 0;
				int SIZE_COLOR = 0;
				int SIZE_X_CURRENT = 0;
				int SIZE_Y_CURRENT = 0;
				int SIZE_X_NEXT = 0;
				int SIZE_Y_NEXT = 0;
				int SIZE_WIDTH = 0;
				int SIZE_HEIGHT = 0;
				
				for (String statement : map_strings.keySet()) {
					if (!map_strings.get(statement.toUpperCase()).isEmpty()) 
					{
						if (statement.toUpperCase().equals("SHAPE"))
						{
							SIZE_SHAPE = map_strings.get(statement.toUpperCase()).size();
						}
						else if (statement.toUpperCase().equals("COLOR"))
						{
							SIZE_COLOR = map_strings.get(statement.toUpperCase()).size();
						}
						else
						{
							System.out.println("ERROR: Unrecognized Feature");
							return;
						}
					}
					else 
					{
						System.out.println("ERROR: Undefined Prerequisite Input");
						return;
					}
				}
				
				for (String statement : map_integers.keySet()) {
					if (!map_integers.get(statement.toUpperCase()).isEmpty()) 
					{
						if (statement.toUpperCase().equals("X_CURRENT"))
						{
							SIZE_X_CURRENT = map_integers.get(statement.toUpperCase()).size();
						}
						else if (statement.toUpperCase().equals("Y_CURRENT"))
						{
							SIZE_Y_CURRENT = map_integers.get(statement.toUpperCase()).size();
						}
						else if (statement.toUpperCase().equals("X_NEXT"))
						{
							SIZE_X_NEXT = map_integers.get(statement.toUpperCase()).size();
						}
						else if (statement.toUpperCase().equals("Y_NEXT"))
						{
							SIZE_Y_NEXT = map_integers.get(statement.toUpperCase()).size();
						}
						else if (statement.toUpperCase().equals("WIDTH"))
						{
							SIZE_WIDTH = map_integers.get(statement.toUpperCase()).size();
						}
						else if (statement.toUpperCase().equals("HEIGHT"))
						{
							SIZE_HEIGHT = map_integers.get(statement.toUpperCase()).size();
						}
						else
						{
							System.out.println("ERROR: Unrecognized Feature");
							return;
						}
					}
					else
					{
						System.out.println("ERROR: Undefined Prerequisite Input");
						return;
					}
				}
				
				if (SIZE_X_CURRENT != SIZE_Y_CURRENT)
				{
					System.out.println("ERROR: Mismatch Size: Coordinate Input");
					return;
				}
				
				if (SIZE_COLOR != SIZE_SHAPE)
				{
					System.out.println("ERROR: Mismatch Size: Color AND Shape Input");
					return;
				}
				
				int SIZE_SHAPE_1 = 0;
				int SIZE_SHAPE_2 = 0;
				int exist_shape_only_pos = 0;
				
				for (String shape : map_strings.get("SHAPE")) {
					if (shape.toUpperCase().equals("LINE"))
					{
						SIZE_SHAPE_1++;
					}
					else if (shape.toUpperCase().equals("CIRCLE") 
							|| shape.toUpperCase().equals("RECTANGLE")
							|| shape.toUpperCase().equals("HOUSE"))
					{
						SIZE_SHAPE_2++;
					}
					else if (shape.toUpperCase().equals("CAR")
							|| shape.toUpperCase().equals("SMILEY")
							|| shape.toUpperCase().equals("PENTAGON"))
					{
						exist_shape_only_pos = 1;
					}
				}
				if (exist_shape_only_pos == 0) {
					if ((SIZE_X_NEXT == 0 && SIZE_Y_NEXT == 0) 
						&& (SIZE_WIDTH == 0 && SIZE_HEIGHT == 0))
					{
						System.out.println("ERROR: Undefined Coordinate Input");
						return;
					}
				}
				if (SIZE_SHAPE_1 != SIZE_Y_NEXT || SIZE_SHAPE_2 != SIZE_HEIGHT)
				{
					System.out.println("ERROR: Mismatch Size: Coordinate Input");
					return;
				}
				
				else
				{
					System.out.println("\n");
					TreeMap<Integer, Integer> x_current = new TreeMap();
					TreeMap<Integer, Integer> y_current = new TreeMap();
					TreeMap<Integer, Integer> x_next = new TreeMap();
					TreeMap<Integer, Integer> y_next = new TreeMap();
					TreeMap<Integer, Integer> width = new TreeMap();
					TreeMap<Integer, Integer> height = new TreeMap();
					TreeMap<Integer, String> color = new TreeMap();
					TreeMap<Integer, String> shape = new TreeMap();
					
					for (String statement : map_integers.keySet()) {
						for (int j = 0; j < map_integers.get(statement).size(); j++){
							if (statement.toUpperCase().equals("X_CURRENT")) {
								x_current.put(new Integer(j), map_integers.get(statement.toUpperCase()).get(j));
							}
							else if (statement.toUpperCase().equals("Y_CURRENT")) {
								y_current.put(new Integer(j), map_integers.get(statement.toUpperCase()).get(j));
							}
							else if (statement.toUpperCase().equals("X_NEXT")) {
								x_next.put(new Integer(j), map_integers.get(statement.toUpperCase()).get(j));
							}
							else if (statement.toUpperCase().equals("Y_NEXT")) {
								y_next.put(new Integer(j), map_integers.get(statement.toUpperCase()).get(j));
							}
							else if (statement.toUpperCase().equals("WIDTH")) {
								width.put(new Integer(j), map_integers.get(statement.toUpperCase()).get(j));
							}
							else if (statement.toUpperCase().equals("HEIGHT")) {
								height.put(new Integer(j), map_integers.get(statement.toUpperCase()).get(j));
							}
						}
					}
					
					for (String statement : map_strings.keySet()) {
						for (int j = 0; j < map_strings.get(statement).size(); j++){
							if (statement.toUpperCase().equals("COLOR")) {
								color.put(new Integer(j), map_strings.get(statement.toUpperCase()).get(j));
							}
							else if (statement.toUpperCase().equals("SHAPE")) {
								shape.put(new Integer(j), map_strings.get(statement.toUpperCase()).get(j));
							}
						}
					}
					
					for (Integer idx : shape.keySet())
					{
						double angle_rad_double = 0;
						double xcur_double = 0;
						double ycur_double = 0;
						double xnext_double = 0;
						double ynext_double = 0;
						int xcur_int = 0;
						int ycur_int = 0;
						int w_int = 0;
						int h_int = 0;
						if (shape.get(idx).toUpperCase().equals("LINE"))
						{
							if (x_next.size() != y_next.size() || y_next.size() > x_current.size())
							{
								System.out.println("ERROR: Mismatch Size: Coordinate Input");
								break;
							}
						}
						else if (shape.get(idx).toUpperCase().equals("CIRCLE")
								|| shape.get(idx).toUpperCase().equals("RECTANGLE")
								|| shape.get(idx).toUpperCase().equals("HOUSE")
								|| shape.get(idx).toUpperCase().equals("CAR")
								|| shape.get(idx).toUpperCase().equals("SMILEY")
								|| shape.get(idx).toUpperCase().equals("PENTAGON"))
						{
							if (width.size() != height.size() || height.size() > x_current.size())
							{
								System.out.println("ERROR: Mismatch Size: Coordinate Input");
								break;
							}
						}
						switch(color.get(idx).toUpperCase())
						{
							case "RED":
								g2d.setColor(Color.RED);
								break;
							case "GREEN":
								g2d.setColor(Color.GREEN);
								break;
							case "BLUE":
								g2d.setColor(Color.BLUE);
								break;
							case "YELLOW":
								g2d.setColor(Color.YELLOW);
								break;
							case "BLACK":
								g2d.setColor(Color.BLACK);
								break;
							case "CYAN":
								g2d.setColor(Color.CYAN);
								break;
							case "DARK GRAY":
								g2d.setColor(Color.DARK_GRAY);
								break;
							case "LIGHT GRAY":
								g2d.setColor(Color.LIGHT_GRAY);
								break;
							case "MAGENTA":
								g2d.setColor(Color.MAGENTA);
								break;
							case "ORANGE":
								g2d.setColor(Color.ORANGE);
								break;
							case "PINK":
								g2d.setColor(Color.PINK);
								break;
							case "WHITE":
								g2d.setColor(Color.WHITE);
								break;
							default:
								System.out.println("ERROR: Undefined Color Input");
								return;
						}
						int idx_next = 0;
						int idx_width_height = 0;
						
						switch(shape.get(idx).toUpperCase())
						{
							case "LINE":
								g2d.drawLine
								(
									x_current.get(idx),
									y_current.get(idx),
									x_next.get(idx_next),
									y_next.get(idx_next)
								);
								idx_next++;
								break;
							case "PENTAGON":
								angle_rad_double=0;
								xcur_double = x_current.get(idx);
								ycur_double = y_current.get(idx);
								
								for (int i=0;i<5;i++) {
									angle_rad_double+=2*Math.PI/5;
									xnext_double=xcur_double+100*Math.cos(angle_rad_double);
									ynext_double=ycur_double+100*Math.sin(angle_rad_double);
									g2d.drawLine
									(
										(int)xcur_double,
										(int)ycur_double,
										(int)xnext_double,
										(int)ynext_double
									);
									xcur_double=xnext_double;
									ycur_double=ynext_double;
								}
								break;
							case "CIRCLE":
								g2d.drawOval
								(
									x_current.get(idx),
									y_current.get(idx), 
									width.get(idx_width_height), 
									height.get(idx_width_height)
								);
								idx_width_height++;
								break;
							case "RECTANGLE":
								g2d.drawRect
								(
									x_current.get(idx),
									y_current.get(idx),
									width.get(idx_width_height), 
									height.get(idx_width_height)
								);
								idx_width_height++;
								break;
							case "HOUSE":
								xcur_int = x_current.get(idx);
								ycur_int = y_current.get(idx);
								w_int = width.get(idx_width_height);
								h_int = height.get(idx_width_height);
								
								g2d.drawRect(xcur_int, ycur_int, w_int, h_int);
								// Draw front of house.
								g2d.drawRect(xcur_int - (w_int/20), ycur_int, w_int + (w_int/10), h_int/3); // Roof with some overhang.
								g2d.drawRect(xcur_int + (2 * w_int/3), ycur_int + h_int/2, w_int/8, h_int/2); // Draw the door.
								g2d.drawRect(xcur_int+(w_int/4),ycur_int+h_int/2, w_int/8, h_int/8); // Draw the window.
								g2d.drawRect(xcur_int+(3*w_int/4), ycur_int-h_int/8, w_int/8, h_int/8); // Draw the chimney.
								idx_width_height++;
								break;
							case "CAR":
								xcur_int = x_current.get(idx);
								ycur_int = y_current.get(idx);
								
								g2d.drawRect(xcur_int, ycur_int + 10, 60, 10);
								g2d.drawOval(xcur_int + 10, ycur_int + 20, 10, 10);
								g2d.drawOval(xcur_int + 40, ycur_int + 20, 10, 10);
								g2d.drawLine(xcur_int + 10, ycur_int + 10, xcur_int + 20, ycur_int);
								g2d.drawLine(xcur_int + 20, ycur_int, xcur_int + 40, ycur_int);
								g2d.drawLine(xcur_int + 40, ycur_int, xcur_int + 50, ycur_int + 10);
								break;
							case "SMILEY":
								xcur_int = x_current.get(idx);
								ycur_int = y_current.get(idx);
								
								int rad = 3 * w_int;
								
								// Ovals for eyes
								g2d.drawOval(xcur_int, ycur_int, 150, 150);
								g2d.drawOval(xcur_int+40, ycur_int+40, 15, 15);
								g2d.drawOval(xcur_int+90, ycur_int+40, 15, 15);
								
								// Arc for the smile
								g2d.drawArc(xcur_int+50, ycur_int+110, 50, 20, 180, 180);
								break;
							default:
								System.out.println("ERROR: Undefined Shape Input");
								return;
						}	
					}
				}
			}
		}
			
		// creating object of JFrame(Window popup) 
		JFrame window = new JFrame(); 
  
		// setting closing operation 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
		window.getContentPane().setBackground(Color.WHITE);
		// setting size of the pop window 
		window.setBounds(30, 30, 600, 600); 
		
		window.setTitle("Group XYZ: Drawing Demo");
  
		// setting canvas for draw 
		window.getContentPane().add(new MyCanvas()); 
		
  
		// set visibility 
		window.setVisible(true); 
	}
}
