import javax.swing.*;


public class BettingAppMain {
	
	public static void main(String args[]){
		
		
		
		Betting bettingFrame = new Betting();
		bettingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bettingFrame.setSize(380,500);
		bettingFrame.setLocation(500,100);
		bettingFrame.setResizable(false);
		bettingFrame.setVisible(true);
	
		
		
	}
}

/*Have user input random number size, adjust reward algorithm accordingly.
 * Embedded change bet field in each window for quicker bet change during play.
 * Clean UI.
*/