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
	public JPanel upperPanel, lowerPanel;
	
	
	public double getBet(){
		return betAmountD;
	}
	
	
	
	public Betting(){
		super("Betting");
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setOpaque(true);
		add(contentPane);
		
		upperPanel = new JPanel();
		upperPanel.setLayout(new FlowLayout());
		upperPanel.setOpaque(true);
		contentPane.add(upperPanel);
				
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new FlowLayout());
		lowerPanel.setOpaque(true);
		contentPane.add(lowerPanel);
		
		ImageIcon img = new ImageIcon("moneyBag.png");
		setIconImage(img.getImage());
		
		JPanel top = new JPanel();
		top.setBackground(Color.blue);
		if(balanceAmount<1){
			top.setBackground(Color.red);
		}
		upperPanel.add(top, BorderLayout.NORTH);
		
		balanceText = new JLabel("Your Balance is €"+balanceAmount);
		top.add(balanceText, BorderLayout.NORTH);
		
		JPanel top2 = new JPanel();
		upperPanel.add(top2, BorderLayout.CENTER);
		wincountLabel = new JLabel("You have won "+wincount+" times");
		top2.add(wincountLabel);
		
		JPanel top3 = new JPanel();
		upperPanel.add(top3, BorderLayout.CENTER);
		
		
		betLabel = new JLabel("Change your bet?");
		top3.add(betLabel);
		
		inputBet = new JTextField(5);
		inputBet.setSize(10,5);
		top3.add(inputBet, BorderLayout.CENTER);
		
		
		betButton = new JButton("Change Bet Amount");
		top3.add(betButton);
		
		
		addBet = new JButton("+");
		top3.add(addBet);
		
	
		
	//	JLabel moneyBagImg = new JLabel(new ImageIcon("moneyBag.png"));

		betAmountLabel = new JLabel("Your current bet is "+betAmountD);
		lowerPanel.add(betAmountLabel);
		
	
		
		JPanel bottom = new JPanel();
		lowerPanel.add(bottom, BorderLayout.SOUTH);
		
		randomButton = new JButton("Random Number");
		bottom.add(randomButton, BorderLayout.EAST);
		
		
		chooseButton = new JButton("Choose Number");
		bottom.add(chooseButton, BorderLayout.WEST);
		
		
	
		
		
		
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
			randomWindow.setSize(400,300);
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
			chooseWindow.setSize(400,300);
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

