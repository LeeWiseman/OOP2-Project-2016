import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class RandomGame extends JFrame {
	
	private JButton spinBtn;
	private JButton backBtn, betButton, addBet;
	private JTextArea numbers;
	private JTextField inputBet;
	private int choosenNumber, winningNumber;
	private boolean win;
	private JLabel balanceText, betAmount, betLabel;
	Random spinner = new Random();
	
		
	
	
	public RandomGame(){
		super("RandomGame");
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
		
		spinBtn = new JButton("Spin");
		add(spinBtn);
		
		backBtn = new JButton("Back");
		add(backBtn);
		
		numbers = new JTextArea("");
		numbers.setOpaque(false);
		numbers.setEditable(false);
	    numbers.setBackground(new Color(0,0,0,0));
	    numbers.setFont(numbers.getFont().deriveFont(14f));
		add(numbers);
		
		backHandler back = new backHandler();
		backBtn.addActionListener(back);
		
		spinHandler spinit = new spinHandler();
		spinBtn.addActionListener(spinit);
		
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
		
		private class spinHandler implements ActionListener{
			public void actionPerformed(ActionEvent spinPress){
				choosenNumber = 1+(spinner.nextInt(10));
				winningNumber = 1+(spinner.nextInt(10));
				
				
				if(Betting.balanceAmount-Betting.betAmountD>(-1)){
				
				if(choosenNumber == winningNumber){
					numbers.setText("Your number was "+choosenNumber+"\nThe winning Number was "+winningNumber+"\nCongratulation, You Won!");
					win = true;
					Betting.wincount ++;
					Betting.balanceAmount += Betting.betAmountD*3;
					balanceText.setText("You're new balance is "+Betting.balanceAmount);
					
				}
				else{
					numbers.setText("Your number was "+choosenNumber+"\nThe winning Number was "+winningNumber+"\nBetter Luck Next Time");
					Betting.balanceAmount -= Betting.betAmountD;
					balanceText.setText("You're new balance is "+Betting.balanceAmount);
				}
				
				}
				else{
					JOptionPane.showMessageDialog(null,"You're out of money");
				}
				
				
			}		
		}
}
		
		
	


