package apps;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import adapters.FrameAdapter;
import adapters.TrigonometryGrid;


public class TrigonometryGraph extends FrameAdapter {
	String function = null;
	String title = null; //Window Title
	private int size, xLength, yLength; //Window Size
	int mouseX = 0, mouseY = 0, mouseXLoc= 0, mouseYLoc = 0; //Mouse Location
	//int x[] = {12,45,125,48,15,78,123,11,78,96,57};
	//int y[] = {48,68,72,91,108,117,322,452,545,621,712};
	String mouseMessage = ""; //Mouse click message
	TrigonometryGrid trigonometryGrid ;
	TrigonometryGrid tempGrid ;
	GridBagConstraints bagConstraints ;
	TextField aField, bField;
	
	public TrigonometryGraph(){
		
	}
	
	public TrigonometryGraph(String function){
		
		this.function = function;
		
	}
	public TrigonometryGraph(String title, int width, int height){
		
		setLayout(new GridBagLayout());
		bagConstraints = new GridBagConstraints();
		bagConstraints.fill = GridBagConstraints.BOTH;
		this.xLength= width;
		this.yLength= height;
		setTitle(title);
		setSize(width,height);
		setResizable(false);setVisible(true);
	   	
		setBackground(Color.lightGray);
		
		bagConstraints.gridx = 2;
	   	bagConstraints.gridy = 0;
	   	bagConstraints.gridheight=7;
	   	trigonometryGrid = new TrigonometryGrid(4*xLength/5,yLength);
		add(trigonometryGrid,bagConstraints);
	   	
	   	bagConstraints.gridx = 0;
	   	bagConstraints.gridy = 0;
	   	bagConstraints.weightx=1;
	   	bagConstraints.gridheight=1;
	   	bagConstraints.gridwidth=2;
	   	bagConstraints.insets = new Insets(10,10,10,10);
	   	Button plotSineButton = new Button("Plot Sine");
	   	add(plotSineButton,bagConstraints);

	   	bagConstraints.gridx = 0;
	   	bagConstraints.gridy = 1;
	   	bagConstraints.weightx=1;
	   	bagConstraints.gridheight=1;
	   	bagConstraints.gridwidth=2;
	   	bagConstraints.insets = new Insets(10,10,10,10);
	   	Button plotCosineButton = new Button("Plot Cosine");
	   	add(plotCosineButton,bagConstraints);
	   	
	   	bagConstraints.gridx = 0;
	   	bagConstraints.gridy = 2;
	   	bagConstraints.weightx=1;
	   	bagConstraints.gridheight=1;
	   	bagConstraints.gridwidth=2;
	   	bagConstraints.insets = new Insets(10,10,10,10);
	   	Button plotTanButton = new Button("Plot Tangent");
	   	add(plotTanButton,bagConstraints);
	   	
	   	bagConstraints.gridx = 0;
	   	bagConstraints.gridy = 3;
	   	bagConstraints.weightx=1;
	   	bagConstraints.gridheight=1;
	   	bagConstraints.insets = new Insets(10,10,10,10);
	   	Button clearButton = new Button("Clear");
	   	add(clearButton,bagConstraints);
	   	
	   	bagConstraints.gridx = 0;
	   	bagConstraints.gridy = 4;
	   	bagConstraints.weightx=0.5;
	   	bagConstraints.gridheight=1;
	   	bagConstraints.gridwidth=1;
	   	bagConstraints.insets = new Insets(10,10,10,10);
	   	aField  = new TextField();
	   	add(aField,bagConstraints);
	   	
	   	bagConstraints.gridx = 1;
	   	bagConstraints.gridy = 4;
	   	bagConstraints.weightx=0.5;
	   	bagConstraints.gridheight=1;
	   	bagConstraints.gridwidth=1;
	   	bagConstraints.insets = new Insets(10,10,10,10);
	   	Label aLabel = new Label("= a" );
	   	add(aLabel,bagConstraints);
	   	
	   	bagConstraints.gridx = 0;
	   	bagConstraints.gridy = 5;
	   	bagConstraints.weightx=0.5;
	   	bagConstraints.gridheight=1;
	   	bagConstraints.gridwidth=1;
	   	bagConstraints.insets = new Insets(10,10,10,10);
	   	bField  = new TextField();
	   	add(bField,bagConstraints);
	   	
	   	bagConstraints.gridx = 1;
	   	bagConstraints.gridy = 5;
	   	bagConstraints.weightx=0.5;
	   	bagConstraints.gridheight=1;
	   	bagConstraints.gridwidth=1;
	   	bagConstraints.insets = new Insets(10,10,10,10);
	   	Label bLabel = new Label("= b" );
	   	add(bLabel,bagConstraints);
	   	
	   	
	   	setVisible(true);
	   	
	   	plotSineButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				   Point point =new Point(trigonometryGrid.getLocation());
				   remove(trigonometryGrid);
				   
				   int a  = Integer.parseInt(aField.getText());
				   int b  = Integer.parseInt(bField.getText());
				   
				   if(a == 0 || b == 0){
					   FrameAdapter errorAdapter = new FrameAdapter("proper values", 300,200);
					   errorAdapter.setBackground(Color.gray);
					   Label msgLabel = new Label("          Please enter a value for a and b.");
					   errorAdapter.add("Center",msgLabel);
					   errorAdapter.show();
				   }else{

				   trigonometryGrid = new TrigonometryGrid(4*xLength/5,yLength,e.getActionCommand(), a, b);
				   trigonometryGrid.setLocation(point);
				   add(trigonometryGrid);
				   }

			}
		});
		plotCosineButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						   Point point =new Point(trigonometryGrid.getLocation());
						   remove(trigonometryGrid);
						   
						   int a  = Integer.parseInt(aField.getText());
						   int b  = Integer.parseInt(bField.getText());
						   if(a == 0 || b == 0){
							   FrameAdapter errorAdapter = new FrameAdapter("proper values", 300,200);
							   errorAdapter.setBackground(Color.gray);
							   Label msgLabel = new Label("          Please enter a value for a and b.");
							   errorAdapter.add("Center",msgLabel);
							   errorAdapter.show();
						   }else{
						   
						   
						   trigonometryGrid = new TrigonometryGrid(4*xLength/5,yLength,e.getActionCommand(), a, b);
						   trigonometryGrid.setLocation(point);
						   add(trigonometryGrid);
						   }
		
					}
				});
		
		plotTanButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				   Point point =new Point(trigonometryGrid.getLocation());
				   remove(trigonometryGrid);

				   int a  = Integer.parseInt(aField.getText());
				   int b  = Integer.parseInt(bField.getText());
				   if(a == 0 || b == 0){
					   FrameAdapter errorAdapter = new FrameAdapter("proper values", 300,200);
					   errorAdapter.setBackground(Color.gray);
					   Label msgLabel = new Label("          Please enter a value for a and b.");
					   errorAdapter.add("Center",msgLabel);
					   errorAdapter.show();
				   }else{

				   trigonometryGrid = new TrigonometryGrid(4*xLength/5,yLength,e.getActionCommand(), a, b);
				   trigonometryGrid.setLocation(point);
				   add(trigonometryGrid);
				   }				  

			}
		});

	   	
	   	clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubbagConstraints.gridx = 1;
			   Point point =new Point(trigonometryGrid.getLocation());
			   remove(trigonometryGrid);
			   trigonometryGrid = new TrigonometryGrid(4*xLength/5,yLength,e.getActionCommand());
			   trigonometryGrid.setLocation(point);
			   add(trigonometryGrid);
			  
			}
		});
	   	
	   	
	   	
	   	
	}
	
}
