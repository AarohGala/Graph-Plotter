

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import adapters.FrameAdapter;
import apps.DataAnalysis;
import apps.TrigonometryGraph;

public class Main extends FrameAdapter {
	
	public static final String appName = "MathLab"; //Window Title
	static Dimension dimension  = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int width = (int) dimension.getWidth()-100;
	public static final int height = (int) dimension.getHeight()-100;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		
		
		FrameAdapter frameAdapter = new FrameAdapter("MathLab  - Trigonometric Functions", width,height);
		frameAdapter.init();
		
		//Work Area
		Panel workPanel = new Panel();
		workPanel.setLayout(new BorderLayout());
		workPanel.setBackground(Color.white);
		frameAdapter.add("Center",workPanel);
		//Panel for Application Text
		Panel appTitlePanel = new Panel();
		appTitlePanel.setLayout(new BorderLayout());
		Label titleLabel = new Label("MathTool");
		titleLabel.setFont(new Font("Century", Font.ITALIC, 100));
		titleLabel.setAlignment(Label.CENTER);
		Label metaLabel = new Label("ver - 7.7.06");
		metaLabel.setAlignment(Label.CENTER);
		appTitlePanel.add("Center",titleLabel);
		appTitlePanel.add("South",metaLabel);
		//Panel for two buttons
		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.white);
		Button trigButton = new Button("Trigonometric Function");
		Button dataAnalysisButton = new Button("Data Analysis");
		buttonPanel.add(dataAnalysisButton);
		buttonPanel.add(trigButton);
		workPanel.add("South",buttonPanel);
		workPanel.add("Center",appTitlePanel);
		Panel paddingPanel = new Panel();
		Label paddingLabel = new Label(" ");
		frameAdapter.add("South", paddingPanel);
		
		trigButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TrigonometryGraph trigonometryGraph = new TrigonometryGraph(appName + " - " + "Trignometric Graph", width, height );
				trigonometryGraph.show();
			}
		});
		
		dataAnalysisButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DataAnalysis dataAnalysis = new DataAnalysis(appName + " - " + "Data Analysis", width, height);
				dataAnalysis.show();
			}
		});
		frameAdapter.show();
		
	}
	
}
