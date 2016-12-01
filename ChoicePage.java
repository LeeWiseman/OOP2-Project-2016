//ChoicePage.java
//First interactable output the user will see, to choose which type of bet to make

import javax.swing.*;
import java.awt.*;

public class ChoicePage extends JFrame{
	
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
	
	Container pane1 = getContentPane();
	pane1.setLayout(null);
	randomNumGame = new JButton("Random Number");
	chooseNumGame = new JButton("Choose Your Number");
	
		pane1.add(randomNumGame);
			randomNumGame.setBounds(90,500,200,40);
		pane1.add(chooseNumGame);
			chooseNumGame.setBounds(310,500,200,40);
			JOptionPane.showInputDialog("Enter the amount you want to bet");
	/*JTextField bet = new JTextField("Your Bet Amount");
	pane1.add(bet);
	bet.setBounds(290,400,200,40);
	*/
		}
	
	
	
	
	
	
	
	

	
		
}