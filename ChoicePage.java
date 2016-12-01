//ChoicePage.java
//First interactable output the user will see, to choose which type of bet to make

import javax.swing.*;
import java.awt.*;

public class ChoicePage extends JFrame{
	public ChoicePage(){

	setSize(600,800);
	setTitle("Welcome!");
	setVisible(true);	
	//Set window logo
	ImageIcon logoicon = new ImageIcon("MoneyBag.png");
	Image logo = logoicon.getImage();
	setIconImage(logo);
	//position
	setResizable(false);
	setLocation(700,100);
	JButton randomNumGame = new JButton("Random Number");
	JButton chooseNumgame = new JButton("Choose Your Number");
		}
	
	
	
	
	
	
	
	

	
		
}