package adapters;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class TrigonometryGrid extends Canvas{
	private int width, height;
	int mouseX = 0, mouseY = 0, mouseXLoc= 0, mouseYLoc = 0, a =1 , b =1; //Mouse Location
	//int x[] = {12,45,125,48,15,78,123,11,78,96,57};
	//int y[] = {48,68,72,91,108,117,322,452,545,621,712};
	String mouseMessage = ""; //Mouse click message
	Graphics graphics;
	Graphics2D graphics2D ;
	public String action = "Hello" ;
    public TrigonometryGrid(){

		
	}
	
public TrigonometryGrid( int width, int height){
		
		setSize(new Dimension(width-20,height-20));
		setBackground(Color.white);
		this.height = height;
		//System.out.println(action);
		this.width = width;
		this.setVisible(true);
		//System.out.println(action);
		}
	
	
	public TrigonometryGrid( int width, int height, String string , int a, int b){
		
		setSize(new Dimension(width-20,height-20));
		setBackground(Color.white);
		this.height = height;
		//System.out.println(action);
		this.width = width;
		this.a = a;
		this.b = b;
		this.setVisible(true);
		action = string;
		//System.out.println(action);
		}
	

	
	public TrigonometryGrid( int width, int height, String string){
		
		setSize(new Dimension(width-20,height-20));
		setBackground(Color.white);
		this.height = height;
		//System.out.println(action);
		this.width = width;
		this.a = a;
		this.b = b;
		this.setVisible(true);
		action = string;
		//System.out.println(action);
		}
	
	
	//Return Sine Value of x
			double fSin(double x){
				return Math.sin(x);
			}

			//Return Cosine Value of x
			double fCos(double x){
				return Math.cos(x);
				
			}

			//Return Tan Value of x
			double fTan(double x){
				return Math.tan(x);
				
			}
			
			public void paint(Graphics graphics){
				
				if(action.equals("Plot Sine")){

					System.out.println("Its plot");
					Polygon p1 = new Polygon();
					
					
					//Plot Graphics
					plotSineGraph(p1,graphics, a, b);
					
					//Center Axis
					drawCenterAxis(graphics);
					
					graphics.fillOval(mouseXLoc, mouseYLoc, 1, 1);
					graphics.drawString(mouseMessage, mouseXLoc, mouseYLoc);
					
				}else if(action.equals("Clear")){
					System.out.println("Its clear");
					drawCenterAxis(graphics);
			
					
					graphics.fillOval(mouseXLoc, mouseYLoc, 1, 1);
					graphics.drawString(mouseMessage, mouseXLoc, mouseYLoc);
				
				}else if(action.equals("Plot Cosine")){
					Polygon p1 = new Polygon();
					
					
					//Plot Graphics
					plotCosineGraph(p1,graphics, a, b);
					
					//Center Axis
					drawCenterAxis(graphics);
					
					graphics.fillOval(mouseXLoc, mouseYLoc, 1, 1);
					graphics.drawString(mouseMessage, mouseXLoc, mouseYLoc);
					
						
				}else if(action.equals("Plot Tangent")){
					Polygon p1 = new Polygon();
					
					
					//Plot Graphics
					plotTanGraph(p1,graphics, a, b);
					
					//Center Axis
					drawCenterAxis(graphics);
					
					graphics.fillOval(mouseXLoc, mouseYLoc, 1, 1);
					graphics.drawString(mouseMessage, mouseXLoc, mouseYLoc);
					
						
				}
			}
						//Tangent Graph
			public void plotTanGraph(Polygon polygon, Graphics graphics, int a, int b) {
				for(int x = -width/2;x<=width/2; x++){
					polygon.addPoint(x+width/2 ,height/2- a*(int)(50 * fTan((b*x / 100.0) * 2 * Math.PI)));
				}
				graphics.setColor(Color.cyan);
				graphics.drawPolyline(polygon.xpoints, polygon.ypoints, polygon.npoints);
				
			}

			//Cosine Graph
			public void plotCosineGraph(Polygon polygon, Graphics graphics, int a, int b) {
				for(int x = -width/2;x<=width/2; x++){
					polygon.addPoint(x+width/2 ,height/2- a*(int)(50 * fCos((b*x / 100.0) * 2 * Math.PI)));
				}
				graphics.setColor(Color.red);
				graphics.drawPolyline(polygon.xpoints, polygon.ypoints, polygon.npoints);
				
				
			}

			
			//Sine Graph
			public void plotSineGraph(Polygon polygon, Graphics graphics ,int a , int b) {
				for(int x = -width/2;x<=width/2; x++){
					polygon.addPoint(x+width/2 ,height/2- a*(int)(50 * fSin((b*x / 100.0) * 2 * Math.PI)));
				}
				graphics.setColor(Color.blue);
				graphics.drawPolyline(polygon.xpoints, polygon.ypoints, polygon.npoints);
				
			}
			
			//Center Axis
			public void drawCenterAxis(Graphics graphics) {
				graphics.setColor(Color.black);
				graphics.drawLine(0, height/2, width, height/2);
				graphics.drawLine( width/2, 0, width/2, height);
				graphics.drawString(" <- x",10,height/2+110);
				graphics.drawString("y",width/2+10,100);
				graphics.drawString("^",width/2+8,80);
				graphics.drawString("|",width/2+11,80);
				graphics.drawString("\u03c0",(int) (width/2+Math.PI*10),height/2+10);
				graphics.drawString("-\u03c0",(int) (width/2-Math.PI*10),height/2+10);
				graphics.drawString("2\u03c0",(int) (width/2+2*Math.PI*10),height/2+10);
				graphics.drawString("-2\u03c0",(int) (width/2-2*Math.PI*10),height/2+10);
				graphics.drawString("3\u03c0",(int) (width/2+3*Math.PI*10),height/2+10);
				graphics.drawString("-3\u03c0",(int) (width/2-3*Math.PI*10),height/2+10);
				graphics.drawString("4\u03c0",(int) (width/2+4*Math.PI*10),height/2+10);
				graphics.drawString("-4\u03c0",(int) (width/2-4*Math.PI*10),height/2+10);
				graphics.drawString("5\u03c0",(int) (width/2+5*Math.PI*10),height/2+10);
				graphics.drawString("-5\u03c0",(int) (width/2-5*Math.PI*10),height/2+10);
				graphics.drawString("6\u03c0",(int) (width/2+6*Math.PI*10),height/2+10);
				graphics.drawString("-6\u03c0",(int) (width/2-6*Math.PI*10),height/2+10);
				graphics.drawString("7\u03c0",(int) (width/2+7*Math.PI*10),height/2+10);
				graphics.drawString("-7\u03c0",(int) (width/2-7*Math.PI*10),height/2+10);
				graphics.drawString("8\u03c0",(int) (width/2+8*Math.PI*10),height/2+10);
				graphics.drawString("-8\u03c0",(int) (width/2-8*Math.PI*10),height/2+10);
				graphics.drawString("9\u03c0",(int) (width/2+9*Math.PI*10),height/2+10);
				graphics.drawString("-9\u03c0",(int) (width/2-9*Math.PI*10),height/2+10);
				graphics.drawString("1",(int) (width/2+10),height/2-(int)Math.PI*20);
				graphics.drawString("-1",(int) (width/2+10),height/2+(int)Math.PI*20);
				graphics.drawRect(width/2+100,50, 150, 70);
				graphics.setColor(Color.red);
				graphics.drawLine(width/2+110,60, width/2+150, 60);
				graphics.drawString("y = cosine(x)", width/2+150, 65);
				graphics.setColor(Color.blue);
				graphics.drawLine(width/2+110,80, width/2+150, 80);
				graphics.drawString("y =sine(x)", width/2+150, 85);
				graphics.setColor(Color.cyan);
				graphics.drawLine(width/2+110,100, width/2+150, 100);
				graphics.drawString("y =tan(x)", width/2+150, 105);
				}
			
		
			
		


}
