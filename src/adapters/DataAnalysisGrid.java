package adapters;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

public class DataAnalysisGrid extends Canvas {
	
	private int width, height;
	private String xTitle, yTitle;
	public DataAnalysisGrid(){
		
	}
	
	public DataAnalysisGrid(int width, int height, String xTitle, String yTitle){
		setSize(new Dimension(width-20,height-20));
		setBackground(Color.white);
		this.height = height;
		//System.out.println(action);
		this.width = width;
		this.setVisible(true);
		this.xTitle = xTitle;
		this.yTitle = yTitle;
		//System.out.println(action);
		
	}
	
	public void paint(Graphics graphics){
		drawQuadrantAxis(graphics);
	}
	

	//Center Axis
	public void drawQuadrantAxis(Graphics graphics) {
		graphics.setColor(Color.black);
		graphics.drawLine(0, height-50, width, height-50);
		graphics.drawLine( 50, 0, 50, height);
		for(int i = 0, j =0; i< xTitle.length(); i++, j+=14){
			graphics.drawString(new String(""+xTitle.charAt(i)),200+j,height-30);
		}
		for(int i = 0, j =0; i< yTitle.length(); i++, j+=14){
			graphics.drawString(new String(""+yTitle.charAt(i)),30,100+j);
				
		}
		
		
	}

}
