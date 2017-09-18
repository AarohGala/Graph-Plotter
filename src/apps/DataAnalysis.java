package apps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import adapters.DataAnalysisGrid;
import adapters.FrameAdapter;
import adapters.TrigonometryGrid;

public class DataAnalysis extends FrameAdapter{
	
	private int size; //Window Size
	private int xLength;
	private int yLength;
	private GridBagConstraints bagConstraints;
	DataAnalysisGrid analysisGrid;
	public DataAnalysis(){
		
	}
	
	public DataAnalysis(String title, int size){
		setLayout(new BorderLayout());
		this.size = size;
		this.setTitle(title);
		this.setSize(size,size);
		this.setResizable(false);
		this.setBackground(Color.white);
		
	}
	
	public DataAnalysis(String title, int width, int height){
		setLayout(new GridBagLayout());
		this.xLength= width;
		this.yLength= height;
		bagConstraints = new GridBagConstraints();
		bagConstraints.fill = GridBagConstraints.BOTH;
		this.xLength= width;
		this.yLength= height;
		setTitle(title);
		setSize(width,height);
		setResizable(false);setVisible(true);
	   	
		
		bagConstraints.gridx = 2;
	   	bagConstraints.gridy = 0;
	   	bagConstraints.gridheight=7;
	   	analysisGrid = new DataAnalysisGrid(4*xLength/5,yLength,"time","frequency");
		add(analysisGrid,bagConstraints);
	   	
	}
	
}
