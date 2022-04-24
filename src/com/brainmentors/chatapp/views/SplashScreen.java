package com.brainmentors.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
 
public class SplashScreen extends JWindow {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.runProgressBar(); //invoking the runprogress function as splash screen will show up
			
		
	}
	private Timer timer; //it will be initialized with null value , instance variable
	
	private void runProgressBar() {
		//there is class name as timer to run progressBar 
		 timer = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				progressBar_3.setValue(count);
				count++;
				if(count > 100) {
					if(timer != null) {
						timer.stop();
						SplashScreen.this.setVisible(false);
						SplashScreen.this.dispose(); //for cleaning it from the memory
						UserScreen userScreen = new UserScreen(); //after the progress bar completely filled the userscreen will show up
						userScreen.setVisible(true);
					}
				}
				
			}
		});
		 
		 timer.start(); //as timer is a thread it need to be start with .start()
	}

	/**
	 * Create the frame.
	 */
	private int count = 0;
	JProgressBar progressBar_3 = new JProgressBar();
	public SplashScreen() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		progressBar_3.setBackground(new Color(240, 240, 240));
		progressBar_3.setForeground(Color.RED);
		progressBar_3.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		progressBar_3.setStringPainted(true);
		progressBar_3.setBounds(49, 394, 626, 20);
		contentPane.add(progressBar_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 16));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/images/chat.jpg")));
		lblNewLabel.setBounds(21, 10, 703, 430);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
}
