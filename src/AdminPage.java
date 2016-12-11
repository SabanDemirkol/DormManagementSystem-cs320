import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminPage extends JFrame {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = screenSize.width; // width of the computer screen
	int screenHeight = screenSize.height; // height of the computer screen
	Admin admin;
	JPanel buttonPanel = new JPanel();
	JPanel actionPanel = new JPanel();

	public AdminPage(Admin admin) {

		this.admin = admin;
		this.setSize(screenWidth, screenHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		buttonPanel.setSize(screenWidth/3, screenHeight);
		buttonPanel.setBackground(Color.red);
		buttonPanel.setLayout(null);
		
		addButtons(admin, buttonPanel);
		addLabels(admin.getName(), buttonPanel);
		
		actionPanel.setLayout(null);
		actionPanel.setBounds(screenWidth-screenWidth*2/3, 0 , screenWidth*2/3, screenHeight);
actionPanel.setBackground(Color.black);
		this.add(actionPanel);
		
		
		this.setVisible(true);
	}
	public void setActionPanel(JPanel panel ){
		actionPanel = panel;
		repaint();
	}

	private void addButtons(Admin admin, JPanel buttonPanel) {

		int buttonWidth = screenWidth / 3;
		int buttonHeight = screenHeight / 6;
		int xCoordinate = 0;
		int yCoordinate = 0;

		JButton checkRoomButton = new JButton("Check Rooms");
		JButton checkStudentsButton = new JButton("Check Students");
		JButton startAllocationButton = new JButton("Start Allocation"); 
		JButton deleteButton = new JButton("Delete");
		JButton updateButton = new JButton("Update");
		JButton logOffButton = new JButton("Log-off");

		checkRoomButton.setBounds(xCoordinate, yCoordinate, buttonWidth, buttonHeight);
		checkStudentsButton.setBounds(xCoordinate, yCoordinate + buttonHeight, buttonWidth, buttonHeight);
		startAllocationButton.setBounds(xCoordinate, yCoordinate + buttonHeight * 2, buttonWidth, buttonHeight);
		deleteButton.setBounds(xCoordinate, yCoordinate + buttonHeight * 3, buttonWidth, buttonHeight);
		updateButton.setBounds(xCoordinate, yCoordinate + buttonHeight * 4, buttonWidth, buttonHeight);
		logOffButton.setBounds(xCoordinate, yCoordinate + buttonHeight * 5, buttonWidth, buttonHeight);

		checkRoomButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		checkStudentsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		startAllocationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		logOffButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonPanel.add(checkRoomButton);
		buttonPanel.add(checkStudentsButton);
		buttonPanel.add(startAllocationButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(logOffButton);
	}

	private void addLabels(String name, JPanel panel) {
		JLabel label = new JLabel("admin: ");
		JLabel nameLabel = new JLabel(name);
		label.setBounds(650, 20, 50, 20);
		nameLabel.setBounds(700, 20, 50, 20);
		label.setFont(new Font(null, Font.BOLD, 15));
		nameLabel.setFont(new Font(null, Font.BOLD, 15));
		panel.add(label);
		panel.add(nameLabel);
		this.add(panel);
	}

}
