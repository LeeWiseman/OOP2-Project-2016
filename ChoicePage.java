//ChoicePage.java
//First interactable output the user will see, to choose which type of bet to make

import javax.swing.*;
import java.awt.*;

public class ChoicePage extends JFrame{
	
	double bet=0.0;
	JButton randomNumGame;
	JButton chooseNumGame;
	
	public ChoicePage(){

	setSize(600,800);
	setTitle("Welcome!");
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);	
	//Set window logo
	ImageIcon logoicon = new ImageIcon("MoneyBag.png");
	Image logo = logoicon.getImage();
	setIconImage(logo);
	//position
	setResizable(false);
	setLocation(700,100);
	
	//container
	Container pane1 = getContentPane();
	pane1.setLayout(null);
	randomNumGame = new JButton("Random Number");
	chooseNumGame = new JButton("Choose Your Number");
	
	pane1.add(randomNumGame);
		randomNumGame.setBounds(90,500,200,40);
	pane1.add(chooseNumGame);
		chooseNumGame.setBounds(310,500,200,40);
	
	JTextField betField = new JTextField("€0");
	betField.setBounds(200,400,100,40);
	JButton makeBetButton = new JButton("Change Bet");
	makeBetButton.setBounds(310,404,100,30);
	pane1.add(betField);	
	pane1.add(makeBetButton);
	
	makeBetButton.addActionListener(new myListener());
	}	
	public class myListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==makeBetButton){
					betField("");
					}
		}
	
	
	
	
	
	
	
	

	
		
}
	
}