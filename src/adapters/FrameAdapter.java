/**
 * 
 */
package adapters;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;

/**
 * @author kaunil
 *
 */
public class FrameAdapter extends Frame{
	
	public static final String appName = "MathLab"; //Window Title
	private int size; //Window Size
	protected int xLength;
	protected int yLength;
	int mouseX = 0, mouseY = 0, mouseXLoc= 0, mouseYLoc = 0; //Mouse Location
	//int x[] = {12,45,125,48,15,78,123,11,78,96,57};
	//int y[] = {48,68,72,91,108,117,322,452,545,621,712};
	
	public FrameAdapter(){
		
	}
	public void init(){
		setLayout(new BorderLayout());
			
	}
	
	public FrameAdapter(String title, int size){
		setLayout(new BorderLayout());
		this.size = size;
		this.setTitle(title);
		this.setSize(size,size);
		this.setResizable(false);
		this.setBackground(Color.white);
	}
	

	public FrameAdapter(String title, int width, int height){
		setLayout(new BorderLayout());
		this.xLength= width;
		this.yLength= height;
		this.setTitle(title);
		this.setSize(width,height);
		this.setResizable(false);
		this.setBackground(Color.white);
		}
	
	
		public boolean handleEvent(Event event) {
		if(event.id == Event.WINDOW_DESTROY){
			
			System.exit(0);
			
		}
		return super.handleEvent(event);
		
	}
	
	
}
