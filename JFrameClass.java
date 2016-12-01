//JFrameClass.java

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class JFrameClass extends JFrame {
	JButton jb;	
		
			
	public JFrameClass(){
	//setup
	setTitle("Welcome");
	setSize(200,80);
	setResizable(false);
	setLocation(700,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	Container pane = getContentPane();
	pane.setLayout(new FlowLayout());
	
	jb = new JButton("Start");
	pane.add(jb);
	
	jb.addActionListener(new myListener());
	
	setVisible(true);
	}
	
	public static void main(String args[]){
		new JFrameClass();
	}
	
	public class myListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==jb){
				ChoicePage cp = new ChoicePage();
				setVisible(false);
					}
				}
	
			}	
		}