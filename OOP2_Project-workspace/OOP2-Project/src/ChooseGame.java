import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ChooseGame extends JFrame {
	private JTextField inputNumber, inputBet;
	private JTextArea numbers;
	private JLabel enterNo, choosenNum, betAmount, balanceText, betLabel;
	private JButton backBtn, spinBtn, setBtn, betButton, addBet;
	private int chosenNumber, winningNumber;
	private boolean win=false, valid=false;
	Random spinner = new Random();
	
	
	
	public ChooseGame(){
		super("ChooseGame");
		setLayout(new FlowLayout());
		
		ImageIcon img = new ImageIcon("moneyBag.png");
		setIconImage(img.getImage());
		
		betLabel = new JLabel("Choose your bet");
		add(betLabel);
		
		
		inputBet = new JTextField(5);
		add(inputBet);
		
		
		
		betButton = new JButton("Change Bet Amount");
		add(betButton);
		
		
		addBet = new JButton("+");
		add(addBet);
		
		
		betAmount = new JLabel("Youre betting "+Betting.betAmountD+" per spin");
		add(betAmount);
		
		balanceText = new JLabel("Your Balance is "+Betting.balanceAmount);
		add(balanceText);
		
		enterNo = new JLabel("Enter your number (1-10)");
		add(enterNo);
		
		inputNumber = new JTextField(3);
		add(inputNumber);
		
		choosenNum= new JLabel("Your Chosen Number is ");
		add(choosenNum);
		
		setBtn = new JButton("Set Choice");
		add(setBtn);
		
		
		spinBtn = new JButton("Spin");
		add(spinBtn);
		
		backBtn = new JButton("Back");
		add(backBtn);
		
		numbers = new JTextArea("Your results will Be Displayed Here");
		numbers.setEditable(false);
		numbers.setOpaque(false);
		numbers.setEditable(false);
	    numbers.setBackground(new Color(0,0,0,0));
	    numbers.setFont(numbers.getFont().deriveFont(14f));
		add(numbers);
		
		
		backHandler pressBack = new backHandler();
		backBtn.addActionListener(pressBack);
		
		spinHandler spinIt = new spinHandler();
		spinBtn.addActionListener(spinIt);
		
		setNumHandler setNo = new setNumHandler();
		setBtn.addActionListener(setNo);
		
		placeBetHandler placeBet = new placeBetHandler();
		betButton.addActionListener(placeBet);
		
		addBetHandler addBetListener = new addBetHandler();
		addBet.addActionListener(addBetListener);
		
		
	}
	
		private class placeBetHandler implements ActionListener{
		public void actionPerformed(ActionEvent changeBetPress){
				Betting.betAmountD = Double.parseDouble(inputBet.getText());
				inputBet.setText("");
				betAmount.setText("Your bet amount is " + Betting.betAmountD);
				
				
	}
	}
	
	private class addBetHandler implements ActionListener{
		public void actionPerformed(ActionEvent addPress){
			Betting.betAmountAdd = (Double.parseDouble(inputBet.getText()));
			Betting.betAmountD += Betting.betAmountAdd;
			inputBet.setText("");
			betAmount.setText("Your bet amount is " + Betting.betAmountD);
		
	}
	}
	
	private class backHandler implements ActionListener{
		public void actionPerformed(ActionEvent backPress){
			Betting bettingFrame = new Betting();
			bettingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			bettingFrame.setSize(400,500);
			bettingFrame.setLocation(500,100);
			bettingFrame.setResizable(false);
			bettingFrame.setVisible(true);
			
			setVisible(false);
			
		}
			
		
	}
	private class setNumHandler implements ActionListener{
		public void actionPerformed(ActionEvent setPress){
			chosenNumber = Integer.parseInt(inputNumber.getText());
			inputNumber.setText("");
			
			if(chosenNumber<=0 || chosenNumber>10){
				numbers.setText("You didnt set a valid number\n Please choose a number between 1 and 10");
			}
			
			else{
			choosenNum.setText("Your current Number is "+chosenNumber);
			numbers.setText("Your results will be displayed here");
			valid=true;
			}
		}		
	}
	
	
	private class spinHandler implements ActionListener{
		public void actionPerformed(ActionEvent spinPress){
			winningNumber = 1+(spinner.nextInt(10));
			
			if(valid=true && Betting.balanceAmount-Betting.betAmountD>(-1)){
			if(chosenNumber == winningNumber){
				numbers.setText("Your number was "+chosenNumber+"\nThe winning Number was "+winningNumber+"\nCongratulation, You Won!");
				win = true;
				Betting.wincount++;
				Betting.balanceAmount += Betting.betAmountD*3;
				balanceText.setText("You're new balance is "+Betting.balanceAmount);
			}
			else{
				numbers.setText("Your number was "+chosenNumber+"\nThe winning Number was "+winningNumber+"\nBetter Luck Next Time");
				Betting.balanceAmount -= Betting.betAmountD;
				balanceText.setText("You're new balance is "+Betting.balanceAmount);
			}
			}
			
			else{
				JOptionPane.showMessageDialog(null,"You're out of money");
			}
			
			if(valid=false){
				numbers.setText("Please choose a valid number");
			}
			
		}		
	}

}
