import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StudentPage extends JPanel{
	private int width = 600;
	private int height = 600;
	private MenuController controller;
	
	public static void main(String[] args) {

		new StudentPage();
	}
	
	public StudentPage() {
		 controller = new MenuController();
		JFrame frame = new JFrame();
		frame.setSize(width, height);
		createStudentMenu(frame);
	}

	private void createStudentMenu(JFrame frame) {
		this.setSize(width, height);
		this.setLayout(new GridLayout(6, 1));
		
		JLabel label1 = new JLabel("Welcome to Student Interface");
		label1.setBounds(100, -10, 400, 100);
		label1.setForeground(Color.blue);
		label1.setBounds(100, -10, 400, 100);
		label1.setFont(new Font("", Font.BOLD, 20));
		this.add(label1);
		
		JButton checkRooms = new JButton("Check Rooms Availability");
		JButton applyForm = new JButton("Apply a Form Dorm");
		JButton checkAppointment = new JButton("Check Appointed a Room");
		JButton payDormFee = new JButton("Pay Dorm Fee");
		JButton LogOff = new JButton("Log Off");
		
		checkRooms.setVisible(true);
		this.add(checkRooms);
		checkRooms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		applyForm.setVisible(true);
		this.add(applyForm);
		
		checkAppointment.setVisible(true);
		this.add(checkAppointment);
		
		payDormFee.setVisible(true);
		this.add(payDormFee);
		
		
		
		LogOff.setVisible(true);
		this.add(LogOff);
		
		LogOff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, " Logged Off Successfully ");
				System.exit(0);
			}
		});
		
		frame.add(this);
		frame.setVisible(true);
	}
}
