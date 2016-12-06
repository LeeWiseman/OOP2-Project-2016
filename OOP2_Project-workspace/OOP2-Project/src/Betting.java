import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Betting extends JFrame {
	private JButton randomButton, chooseButton, betButton, addBet;
	private JLabel betLabel, betAmountLabel;
	public static JLabel wincountLabel;
	private JTextField inputBet;
	public static double betAmountD;
	public static double betAmountAdd;
	public static double balanceAmount = 500.00;
	private JLabel balanceText, moneyBag;
	public static int wincount;
	
	
	public double getBet(){
		return betAmountD;
	}
	
	
	
	public Betting(){
		super("Betting");
		
		setLayout(new FlowLayout());
		
		moneyBag = (new JLabel(new ImageIcon("moneyBag.png")));
		add(moneyBag);
		
		ImageIcon img = new ImageIcon("moneyBag.png");
		setIconImage(img.getImage());
		
		
		
		betLabel = new JLabel("Change your bet?");
		add(betLabel);
		
		
		inputBet = new JTextField(5);
		add(inputBet);
		
		
		
		betButton = new JButton("Change Bet Amount");
		add(betButton);
		
		addBet = new JButton("+");
		add(addBet);
		
		betAmountLabel = new JLabel("Your current bet is "+betAmountD);
		add(betAmountLabel);
		
		randomButton = new JButton("Random Number");
		add(randomButton);
		
		chooseButton = new JButton("Choose Number");
		add(chooseButton);
		
		balanceText = new JLabel("Your Balance is "+balanceAmount);
		add(balanceText);
		
		wincountLabel = new JLabel("You have won "+wincount+" times");
		add(wincountLabel);
		
		
		placeBetHandler placeBet = new placeBetHandler();
		betButton.addActionListener(placeBet);
		
		randomHandler randomGameBtn = new randomHandler();
		randomButton.addActionListener(randomGameBtn);
		
		chooseHandler chooseBtn = new chooseHandler();
		chooseButton.addActionListener(chooseBtn);
		
		addBetHandler addBetListener = new addBetHandler();
		addBet.addActionListener(addBetListener);
		
	}
	
	private class placeBetHandler implements ActionListener{
		public void actionPerformed(ActionEvent changeBetPress){
				betAmountD = Double.parseDouble(inputBet.getText());
				inputBet.setText("");
				betAmountLabel.setText("Your bet amount is " + betAmountD);
				
				
	}
	}
		
	private class randomHandler implements ActionListener{
		public void actionPerformed(ActionEvent randomPress){
			RandomGame randomWindow = new RandomGame();
			randomWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			randomWindow.setSize(400,500);
			randomWindow.setLocation(500,100);
			randomWindow.setResizable(false);
			randomWindow.setVisible(true);
			
			setVisible(false);
		
	}
	}
		
	
	private class chooseHandler implements ActionListener{
		public void actionPerformed(ActionEvent choosePress){
			ChooseGame chooseWindow = new ChooseGame();
			chooseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			chooseWindow.setSize(400,500);
			chooseWindow.setLocation(500,100);
			chooseWindow.setResizable(false);
			chooseWindow.setVisible(true);
			
			setVisible(false);
		
	}
	}
	
	private class addBetHandler implements ActionListener{
		public void actionPerformed(ActionEvent addPress){
			betAmountAdd = (Double.parseDouble(inputBet.getText()));
			betAmountD += betAmountAdd;
			inputBet.setText("");
			betAmountLabel.setText("Your bet amount is " + betAmountD);
		
	}
	}
	
}

